package com.techelevator.service;

import com.techelevator.model.Pokemon;
import com.techelevator.model.PokemonDetail;

import java.util.ArrayList;
import java.util.List;

public interface PokeAPIService {
    //abstract methods. implicitly public so you don't need to state it

    List<Pokemon> getPokemon();

    PokemonDetail getPokemonDetailById(int id);



}
