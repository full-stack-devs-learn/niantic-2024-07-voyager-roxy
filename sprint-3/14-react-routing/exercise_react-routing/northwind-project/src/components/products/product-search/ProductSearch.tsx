import { useLocation } from "react-router-dom"

export default function ProductSearch()
{
    const location = useLocation()
    const queryParams = new URLSearchParams(location.search)
    const categoryId = queryParams.get("catId") ?? 1
    const name = queryParams.get("name")
    const minPrice = queryParams.get("minPrice")
    const maxPrice = queryParams.get("maxPrice")

    return (<><h1>Product Search</h1>
        <h2>Category Id: {categoryId} </h2>
        <h2>Name: {name} </h2>
        <h2>Min Price: {minPrice} </h2>
        <h2>Max Price: {maxPrice} </h2>
        </>
    )
}