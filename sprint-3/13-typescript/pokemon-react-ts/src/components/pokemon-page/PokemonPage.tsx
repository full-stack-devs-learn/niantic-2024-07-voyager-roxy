import pokemonService from "../../services/pokemon-api-service";
import Header from "../header/Header";
import PokemonCardContainer from "../pokemon-card-container/PokemonCardContainer";

export default function PokemonPage()
{
    async function getAllPokemon()

    {const response = await pokemonService.getAllPokemon()
    response.results.forEach(pokemon =>
        console.log(pokemon)
    )}

    getAllPokemon()

    return(
       <>
        <Header/>
        <PokemonCardContainer/>
        </>
    )
    
}
