<template>
  <div id="main_div">
    <ul class="container">
        
        <li class="pokeResults" v-for="pokemon in pokemonArray" :key="pokemon.id">
            <router-link class="poke_text" v-bind:to="{name: 'detail', params: {id: pokemon.id, name: pokemon.name, url: pokemon.url}}">
                {{pokemon.name}} </router-link>
        </li>
        
    </ul>
    <div id="pagination">
    <button class="page_button" v-if="$store.state.startingVal != 0" @click="getPreviousPokemon">Previous</button>&nbsp;&nbsp; || &nbsp;&nbsp;
    <button class="page_button" @click="getNextPokemon">Next</button>
    </div>
  </div>
</template>

<script>
import pokemonService from '../services/PokemonService'
export default {

    // setup data to hold a array of Pokemon
    data() {
        return {
            pokemonArray: [],
        }
    },
    created() {
        // use a service to query the backend
        pokemonService.getAllPokemon() // returns a promise
            .then(response => {
                this.pokemonArray = response.data;
            });
    }, 
    methods: {
        getNextPokemon(){
            let start = this.$store.state.startingVal;
            let end = this.$store.state.endingVal;
            start += 20;
            end += 20;
            pokemonService.getNewPokemon(start, end).then(response => {
                this.pokemonArray = response.data;
                let values = {
                    startingVal: start,
                    endingVal: end,
                };
                this.$store.commit("GET_NEXT_PREVIOUS", values)
            })
        },
        getPreviousPokemon(){
            let start = this.$store.state.startingVal;
            let end = this.$store.state.endingVal;
            start -= 20;
            end -=20;
            pokemonService.getNewPokemon(start, end).then(response => {
                this.pokemonArray = response.data;
                let values = {
                    startingVal: start,
                    endingVal: end,
                };
                this.$store.commit("GET_NEXT_PREVIOUS", values)
            })
        }
    }

}
</script>

<style>

.pokeResults {
    display: flex;
    list-style-type: none;
    background: linear-gradient(90deg, rgb(29, 28, 36) 0%, rgba(103,106,0,1) 42%, rgba(254,255,0,0.80) 91%);
    width: 150px;
    height: 100px;
    margin: 5px;
    justify-content: center;
    align-items: center;
    border-radius: 15px;
    border: black solid 2px;
    opacity: .8;
    position: relative;    
    
}
.poke_text {
    color: aliceblue;
    font: 1em sans-serif;
    text-transform: capitalize;
    text-decoration: none;
    font-family: 'Belanosima', sans-serif;    
}
.container {
    display: flex;
    flex-flow: row wrap;    
    justify-content: space-between; 
    


}
#pagination {
    display: flex;
    justify-content: center;
}
.page_button {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgb(221, 72, 72);
  height: 30px;
  width: 100px;
  border-radius: 15px;
  font-family: 'Belanosima', sans-serif;
  color: aliceblue;
  border: black solid 2px;
  background: linear-gradient(90deg, rgb(29, 28, 36) 0%, rgb(192, 121, 40) 42%, rgba(243, 198, 0, 0.8) 91%);
  
}
</style>