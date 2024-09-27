import { Pokemon } from "./pokemon"

export class PokemonResponse
{
  count!: number
  next!: string
  previous!: string
  results!: Pokemon[]
}