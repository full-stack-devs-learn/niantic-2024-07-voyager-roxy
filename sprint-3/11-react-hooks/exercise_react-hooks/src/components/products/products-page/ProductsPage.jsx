import { useState } from 'react'
import ProductCardContainer from '../product-card-container/ProductCardContainer'
import './ProductsPage.css'

export default function ProductsPage()
{
    const [action, setAction] = useState("list");

    return (
        <>
        <header className="container mt-4">
            <h1>Products</h1>
        </header>

        {action === "list" && <ProductCardContainer></ProductCardContainer>}
        <ProductCardContainer></ProductCardContainer>
        </>
    )
}