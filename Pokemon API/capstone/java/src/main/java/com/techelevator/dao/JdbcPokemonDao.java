package com.techelevator.dao;

import com.techelevator.model.PokemonDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcPokemonDao implements PokemonDao {

    private JdbcTemplate template;

    public JdbcPokemonDao(JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public void savePokemon(PokemonDto pokeDto) {
        String sql = "INSERT INTO pokemon (api_id, name, url) VALUES (?, ?, ?)";
        template.update(sql, pokeDto.getApiId(), pokeDto.getName(), pokeDto.getUrl());
    }
}
