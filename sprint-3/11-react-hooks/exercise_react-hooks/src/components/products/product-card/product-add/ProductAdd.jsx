import { useState } from "react";
import productService from "../../../../services/product-service";

export default function ProductAdd({onCancel, onProductAdded})
{
    const [productName, setProductName] = useState('');

    async function addProductHandler(event)
    {
        event.preventDefault()

        const newProduct = {
            productName: productName
        }

        try{
            await productService.add(newProduct)

        onProductAdded()}
        catch (error)
        {
            console.log(error.response?.data)
        }
    }

    return(
        <div className="container">
        <h2 className="mt-4">Add New Product</h2>
        <form onSubmit={addProductHandler}>
            <div className="row">
                <label htmlFor="product-name">Product Name:</label>
                <input type="text" className="form-control container ms-2" name="product-name" id="product-name"
                    onChange={(e) => setProductName(e.target.value)}
                />
            </div>

            <button className="btn btn-danger mr-3 mt-3" type="submit">Add Product</button>
            <button className="btn btn-dark mr-3 mt-3" type="cancel" onClick={onCancel}>Cancel</button>
        </form>
        </div>
    )
}