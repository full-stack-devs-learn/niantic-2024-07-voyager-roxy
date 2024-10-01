import { useParams } from "react-router-dom"

export default function ProductEdit()
{
    const params = useParams()
    console.log(params.productId)

    return (<h1>Edit Product</h1>)
}