package com.techelevator.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;
import com.techelevator.model.Results;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// @Service connects through spring so spring knows this is the class to run when
// we create a PokeAPIService object
@Service
public class RestPokeAPIService implements PokeAPIService {

    RestTemplate rt = new RestTemplate();
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon/";


    @Override
    public List<Pokemon> getPokemon() {
        String response = rt.getForObject(API_URL, String.class); //gets your data from the db
        ObjectMapper mapper = new ObjectMapper(); // creates object of the ObjectMapper class
        List<Pokemon> pokemonList = new ArrayList<>();
        System.out.println(response);

        try {
            JsonNode jsonNode = mapper.readTree(response); //turns String response into a tree with nodes we can select
            JsonNode root = jsonNode.path("results");
            for (int i = 0; i < root.size(); i++) {
                String name = root.path(i).path("name").asText();
                String url = root.path(i).path("url").asText();
                int id = calculateId(url);
                //create a Pokemon object and set the values
                Pokemon temp = new Pokemon();
                temp.setApiId(id);
                temp.setName(name);
                temp.setUrl(url);
                pokemonList.add(temp);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return pokemonList;
    }
    @Override
    public PokemonDetail getPokemonDetailById(int id) {
        PokemonDetail pokemonDetail = rt.getForObject(API_URL + id, PokemonDetail.class);
        System.out.println(pokemonDetail);
        return pokemonDetail;
    }
    @Override
    public List<Pokemon> getMorePokemon(int startVal, int endVal) {
        Results rs = rt.getForObject(API_URL + "?offset=" + startVal + "&limit=20", Results.class);
        List<Pokemon> list = rs.getResults();
        for (Pokemon poke : list) {
            int id = calculateId(poke.getUrl());
            poke.setApiId(id);
        }
        return list;
    }

    public int calculateId(String url) {
        int pokemonIndex = url.indexOf("pokemon");
        String pokemonString = url.substring(pokemonIndex);
        int slashIndex = pokemonString.indexOf("/");
        String number = pokemonString.substring(slashIndex + 1, pokemonString.length() - 1);
        int id = Integer.parseInt(number);
        return id;
    }
}
