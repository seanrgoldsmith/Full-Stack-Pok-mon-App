package com.techelevator.controller;

import com.techelevator.dao.PokemonDao;
import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;
import com.techelevator.model.PokemonDto;
import com.techelevator.service.PokeAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class  PokemonController {

    @Autowired //lets spring boot take care of things instead of doing a DAO
    PokeAPIService service;

    @Autowired
    PokemonDao dao;

    @RequestMapping(path = "/pokemon", method = RequestMethod.GET)
    public List<Pokemon> getAllPokemon() {
        return service.getPokemon();
    }
    @GetMapping(path="/pokemon/{id}")
    public PokemonDetail getPokemonDetailById(@PathVariable int id) {
        return service.getPokemonDetailById(id);
    }
    @GetMapping(path="/pokemon/{startVal}/{endVal}")
    public List<Pokemon> getMorePokemon(@PathVariable int startVal, @PathVariable int endVal) {
        return service.getMorePokemon(startVal, endVal); }
    @PostMapping("/pokemon")
    public void saveFavoritePokemon (@RequestBody PokemonDto pokemonDto) {
        dao.savePokemon(pokemonDto);
    }
}
