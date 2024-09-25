import ProductService from "../../../services/product-service";
import { XCircleFill } from "react-bootstrap-icons";
import './ProductCard.css'
import productService from "../../../services/product-service";


export default function ProductCard({id, product, onProductDeleted})
{
    async function deleteProduct()
    {
        await productService.delete(id);

        onProductDeleted(id);
    }

    return(
        <div className="card product-card">
            <div id="product-header" className="card-header">{product}</div>
            <div id="product-body" className="card-body">
            </div>
            <div className="card-footer">
                <XCircleFill id="delete" onClick={deleteProduct} color="red" />
            </div>
        </div>
    )
}