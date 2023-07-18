package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonDetail {

    private int id;
    private String name;
    @JsonProperty("base_experience") //tells Java where the value is in JSON and to map it to the variable below in Java
    private int baseXp;
    private int height;
    private int weight;

    private Sprite sprite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseXp() {
        return baseXp;
    }

    public void setBaseXp(int baseXp) {
        this.baseXp = baseXp;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "PokemonDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", baseXp=" + baseXp +
                ", height=" + height +
                ", weight=" + weight +
                ", sprite=" + sprite +
                '}';
    }
}
