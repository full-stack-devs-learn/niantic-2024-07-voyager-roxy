import { useEffect, useState } from "react"
import { useParams, Link } from "react-router-dom"
import { Product } from "../../../models/product"
import productService from "../../../services/product-service";

export default function ProductDetails()
{
    const [product, setProducts] = useState<Product>();
    
    const params = useParams()
    const productId = params.productId ?? 0

    useEffect(() => { loadProduct() }, [])

    async function loadProduct()
    {
        const selectedProduct = await productService.getProductById(+productId)
        setProducts(selectedProduct)
    }

    return (<>
    <h3>Product Details</h3>
    <p>Product Name: {product?.productName}</p>
    <p>Quantity Per Unit: {product?.quantityPerUnit}</p>
    <p>Unit Price: {product?.unitPrice}</p>
    <p>Reorder Level: {product?.reorderLevel}</p>
    <p>Units In Stock: {product?.unitsInStock}</p>
    <p>Units On Order: {product?.unitsOnOrder}</p>
    <Link className="btn btn-outline-dark mt-3" to={`/products/${productId}/edit`}>Edit</Link>
    </>)
}