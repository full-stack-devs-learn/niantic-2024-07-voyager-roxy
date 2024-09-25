import ProductService from "../../../services/product-service";
import { XCircleFill } from "react-bootstrap-icons";
import './ProductCard.css'


export default function ProductCard({id, product})
{
    return(
        <div className="card product-card">
            <div id="product-header" className="card-header">{product}</div>
            <div id="product-body" className="card-body">
            </div>
            <div className="card-footer">
                <XCircleFill color="red" />
            </div>
        </div>
    )
}