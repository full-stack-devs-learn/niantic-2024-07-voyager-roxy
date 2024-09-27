import axios from "axios";
import {PokemonResponse} from "../models/pokemon-response"

class PokemonService
{
    async getAllPokemon() : Promise<PokemonResponse>
    {
        const response = await axios.get<PokemonResponse>("https://pokeapi.co/api/v2/pokemon/")
        return response.data
    }
}

const pokemonService = new PokemonService()
export default pokemonService;