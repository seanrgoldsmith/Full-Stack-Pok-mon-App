<template>
<div>
    <h2 id="pokemon_name">{{name}}</h2>
    <div class="container">
        <div id="by_id_info">
            <p class="stats">Base Experience: {{pokemon.base_experience}}</p>
            <p class="stats">Height: {{pokemon.height}}</p>
            <p class="stats">Weight: {{pokemon.weight}}</p>
        </div>    
    </div>
    <div>
            <img class="poke_img" v-bind:src="spriteImgFront" />&nbsp;
            <img class="poke_img" v-bind:src="spriteImgBack" />
    </div> 
    <div class="add_fav">
        <button class="fav_button" v-on:click="savePokemon">Add To Favorites</button>
    </div>
</div>
</template>

<script>
import PokemonService from '../services/PokemonService'

export default {
    name: "pokemon-detail",
    props: {
        id: Number, String, //can be a number or a string
        name: String,
    },
    data() {
        return {
            pokemon: {},
            spriteImgFront: "",
            spriteImgBack: "",
        }
    },
    methods: {
        savePokemon() {
            let pokemonToSave = {
                id: this.id,
                name: this.name,
                url: this.$route.params.url,
            };
            PokemonService.saveFavorite(pokemonToSave).then(() => {
                alert(`${this.name} has been added to your favorites!`)
                this.$router.push({name: 'pokemon'}) //same as '/pokemon' but better practice for future changes
            })
        }
    },
    created() {
        PokemonService.getPokemonById(this.id)
        .then(response => {
            this.pokemon = response.data;
            this.spriteImgFront = response.data.sprites.front_default;
            this.spriteImgBack = response.data.sprites.back_default;
        })

    }
}
</script>

<style>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
}
.add_fav {
    display: flex;
    flex-direction: row;
    justify-content: center;
}
.fav_button {
    font-size: 15px;
    color: gold;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -2px 2px 0 #000, 1px 1px 0 #000;
    background: rgba(54, 50, 50, .6);
    border-radius: 7px;
}
#pokemon_name {
    text-align: center;
    text-transform: capitalize;
    font-size: 30px;
    color:gold;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -2px 2px 0 #000, 1px 1px 0 #000;
}
#by_id_info {
    display: flex;
    justify-content: space-evenly;
    background: rgba(54, 50, 50, .6);
    margin: auto 0px;
    border-radius: 15px;
    width: 600px;
    text-align: center;
}
.stats {
    font-size: 20px;
    color:gold;
    text-shadow: -1px -1px 0 #000, 1px -1px 0 #000, -2px 2px 0 #000, 1px 1px 0 #000;
}
.poke_img {
    height: 175px;
}




</style>