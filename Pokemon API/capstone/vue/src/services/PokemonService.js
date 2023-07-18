import axios from "axios";

const http = axios.create ( {
    baseURL: 'http://localhost:9000'
})
    
//this allows for anything in here accessible in this project
export default {
    getAllPokemon() {
        return http.get('pokemon')
    },
    getPokemonById(id) {
        return http.get(`/pokemon/${id}`);
    },
    // getAbilityById(id) {
    //     return http.get(`/ability/${id}`)
    // },
    saveFavorite(pokemon) {
        return http.post('/pokemon', pokemon);
    },
    getNewPokemon(start, end) {
        return http.get(`pokemon/${start}/${end}`)
    }
    

}