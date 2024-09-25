import ProductCard from "../product-card/ProductCard";
import { useEffect, useState } from "react";
import productService from "../../../services/product-service";
import "./ProductCardContainer.css"


export default function ProductCardContainer() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        productService.getAllProducts().then(data => {
            setProducts(data);
        })
    },
        [])

    return (
        <>
            <main className="container mt-4 product-container" id="product-container">
                {products.map((product) => (
                    <ProductCard key={product.productId}
                        product={product.productName}></ProductCard>
                ))

                }
            </main>
        </>
    )
}