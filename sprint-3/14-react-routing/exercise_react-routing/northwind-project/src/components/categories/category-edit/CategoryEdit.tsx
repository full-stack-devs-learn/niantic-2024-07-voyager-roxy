import { useParams } from "react-router-dom"
import { useEffect, useState } from "react"
import { useNavigate, Link } from "react-router-dom"
import categoryService from "../../../services/category-service"

export default function CategoryEdit() {
    const params = useParams()
    const id = params.categoryId ?? 0

    const [categoryName, setCategoryName] = useState('')
    const [description, setDescription] = useState('')

    const navigate = useNavigate()

    useEffect(() => {
        const fetchCategory = async () => {
            const repsonse = await categoryService.getCategoryById(+id)
            setCategoryName(repsonse.categoryName)
            setDescription(repsonse.description)
        }

        fetchCategory();
    },
        [id]);

    async function editCategoryHandler(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault()

        const editedCategory: any =
        {
            categoryName: categoryName,
            description: description,
            categoryId: +id
        }

        await categoryService.editCategory(editedCategory)

        navigate(`/categories/${id}`)
    }
        return (<>
            <div className="container">
                <h2>Edit Category</h2>
                <form method="post" onSubmit={editCategoryHandler}>
                    <div className="row">
                        <label htmlFor="category-name">Category Name:</label>
                        <input type="text" className="form-control" value={categoryName} name="category-name" id="category-name"
                            onChange={(e) => setCategoryName(e.target.value)}
                        />
                    </div>

                    <div className="row">
                        <label htmlFor="description">Description:</label>
                        <input type="text" className="form-control" value={description} name="description" id="description"
                            onChange={(e) => setDescription(e.target.value)}
                        />
                    </div>
                    <button className="btn btn-outline-primary mt-3" type="submit">Save</button>
                    <Link className="btn btn-outline-dark mt-3" to="/categories">Cancel</Link>
                </form>
            </div>
        </>)
    }