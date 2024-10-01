import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import { Category } from "../../../models/category"
import categoryService from "../../../services/category-service";

export default function CategoryDetails()
{
    const [category, setCategory] = useState<Category>();
    
    const params = useParams()
    const categoryId = params.categoryId ?? 0

    useEffect(() => { loadCategory() }, [])

    async function loadCategory()
    {
        const selectedCategory = await categoryService.getCategoryById(+categoryId)
        setCategory(selectedCategory)
    }
    return(<>
    <h3>Category Details</h3>
    <p>{category?.categoryName}</p>
    <p>{category?.description}</p>
    </>)
}