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

        const productDeleted = (productId) => {
            const newList = products.filter(product => product.productId !== productId);
            setProducts(newList);
        }

    return (
        <>
            <main className="container mt-4 product-container" id="product-container">
                {products.map((product) => (
                    <ProductCard key={product.productId}
                        id={product.productId}
                        product={product.productName}
                        onProductDeleted={productDeleted}></ProductCard>
                ))

                }
            </main>
        </>
    )
}