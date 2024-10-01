import { useParams } from "react-router-dom"

export default function CategoryEdit()
{
    const params = useParams()
    console.log(params.categoryId)
    return(<h1>Edit Category</h1>)
}