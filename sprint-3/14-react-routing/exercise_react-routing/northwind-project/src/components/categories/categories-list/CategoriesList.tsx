import { useEffect, useState } from "react"
import { Category } from "../../../models/category"
import categoryService from "../../../services/category-service"
import { Link } from "react-router-dom"
// import { Link } from "react-router-dom"

export default function CategoriesList()
{
    const [categories, setCategories] = useState<Category[]>([])

    useEffect(() => { loadCategories() }, [])

    async function loadCategories() {
        try{
            const categories = await categoryService.getCategories();
            setCategories(categories)
        } catch (error)
        {
            console.log(error);
        }
        
    }
    return(<>
    <h3>Categories List</h3>
    <ul>
        {categories.map((category: Category) => (
            <li>{category.categoryName}</li>
        ))}
    </ul>

    <Link className="btn btn-outline-primary m-3" to='/categories/add'>Add</Link>
    
    </>)
}