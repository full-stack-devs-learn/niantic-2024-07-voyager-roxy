import { useState } from 'react'
import ProductCardContainer from '../product-card-container/ProductCardContainer'
import './ProductsPage.css'
import ProductAdd from '../product-card/product-add/ProductAdd';

export default function ProductsPage()
{
    const [action, setAction] = useState("list");

    return (
        <div className="container">
        <header className="container mt-4">
            <h1>Products</h1>
        </header>
        <button className="btn btn-danger ms-3" onClick={()=> setAction("add")}>Add</button>

        {action === "list" && <ProductCardContainer></ProductCardContainer>}
        {action === "add" && <ProductAdd onCancel={()=>setAction("list")}
                                         onProductAdded={()=>setAction("list")}
                                         ></ProductAdd>}
        </div>
    )
}