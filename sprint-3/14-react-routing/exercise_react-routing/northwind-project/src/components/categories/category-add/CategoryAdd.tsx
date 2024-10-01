import { useState } from "react"
import { Link, useNavigate } from "react-router-dom"
import categoryService from "../../../services/category-service"

export default function CategoryAdd() {

const [categoryName, setCategoryName] = useState('')
const [description, setDescription] = useState('')

const navigate = useNavigate()

async function addCategoryHandler(event: React.FormEvent<HTMLFormElement>)
{
    event.preventDefault()

    const newCategory: any = 
    {
        categoryName: categoryName,
        description: description
    }

    await categoryService.addCategory(newCategory)

    navigate('/categories')
}

    return (<>
    <div className="container">
        <h2>Add New Category</h2>
        <form method="post" onSubmit={addCategoryHandler}>
            <div className="row">
                <label htmlFor="category-name">Category Name:</label>
                <input type="text" className="form-control" name="category-name" id="category-name"
                onChange={(e) => setCategoryName(e.target.value)}
                />
            </div>

            <div className="row">
                <label htmlFor="description">Description:</label>
                <input type="text" className="form-control" name="description" id="description"
                onChange={(e) => setDescription(e.target.value)}
                />
            </div>
            <button className="btn btn-outline-primary mt-3" type="submit">Add Category</button>
            <Link className="btn btn-outline-dark mt-3" to="/categories">Cancel</Link>
        </form>
    </div>
    </>)
}