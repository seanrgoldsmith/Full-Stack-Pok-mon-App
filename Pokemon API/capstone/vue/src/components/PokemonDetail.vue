<template>
<div>
    <h2 id="pokemon_name">{{name}}</h2>
    <div class="container">
        <div id="by_id_info">
            <p class="stats">Base Experience: {{pokemon.base_experience}}</p>
            <p class="stats">Height: {{pokemon.height}}</p>
            <p class="stats">Weight: {{pokemon.weight}}</p>
            <p>Abilities: {{abilities}}</p>
        </div>    
    </div>
    <div>
            <img class="poke_img" v-bind:src="spriteImgFront" />&nbsp;
            <img class="poke_img" v-bind:src="spriteImgBack" />
    </div> 
    <div>
        <button v-on:click="savePokemon">Add To Favorites</button>
    </div>
</div>
</template>

<script>
import PokemonService from '../services/PokemonService'

export default {
    props: {
        id: Number, String, //can be a number or a string
        name: String,
    },
    data() {
        return {
            pokemon: {},
            abilities: {},
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
            this.abilities = response.data.abilities;
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
#pokemon_name {
    text-align: center;
    text-transform: capitalize;
    font-size: 30px;
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
}
.poke_img {
    height: 175px;
}


</style>