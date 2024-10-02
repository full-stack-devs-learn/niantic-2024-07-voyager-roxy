import { Link, useLocation} from "react-router-dom"
import { useState, useEffect } from "react"
import { Product } from "../../../models/product"
import productService from "../../../services/product-service"

export default function ProductSearch()
{
    const location = useLocation()
    const queryParams = new URLSearchParams(location.search)
    const categoryId = queryParams.get("catId") ?? 1
    const name = queryParams.get("name")
    const minPrice = queryParams.get("minPrice")
    const maxPrice = queryParams.get("maxPrice")

    const [products, setProducts] = useState<Product[]>([])

    useEffect(() => { loadProducts() }, [])

    async function loadProducts() {
        try{
            const products = await productService.getProducts();
            setProducts(products)
        } catch (error)
        {
            console.log(error);
        }
    }

    return (<><h3>Product Search</h3>
        <h4>Category Id: {categoryId} </h4>
        <h4>Name: {name} </h4>
        <h4>Min Price: {minPrice} </h4>
        <h4>Max Price: {maxPrice} </h4>

        <h3>Products List</h3>
        <ul>
            {products.map((product: Product) => (
                <>
                    <li><Link to={`/products/${product.productId}`}>{product.productName}</Link></li>
                </>
            ))}
        </ul>

        <Link className="btn btn-outline-primary m-3" to='/products/add'>Add</Link>
        </>
    )
}