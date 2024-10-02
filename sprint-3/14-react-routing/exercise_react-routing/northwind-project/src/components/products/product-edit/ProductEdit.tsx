import { useEffect, useState } from "react"
import { useNavigate, useParams, Link } from "react-router-dom"
import productService from "../../../services/product-service"

export default function ProductEdit()
{
    const params = useParams()
    const id = params.productId ?? 0

    const [productName, setProductName] = useState('')
    const [unitPrice, setUnitPrice] = useState(0)
    const [supplierId, setSupplierId] = useState(0)
    const [categoryId, setCategoryId] = useState(0)
    const [quantityPerUnit, setQuantityPerUnit] = useState('')
    const [unitsInStock, setUnitsInStock] = useState(0)
    const [unitsOnOrder, setUnitsOnOrder] = useState(0)
    const [reorderLevel, setReorderLevel] = useState(0)

    const navigate = useNavigate()

    useEffect(() => {
        const fetchProduct = async () => {
            const response = await productService.getProductById(+id)
            setProductName(response.productName)
            setUnitPrice((response.unitPrice))
            setQuantityPerUnit(response.quantityPerUnit)
            setUnitsInStock(response.unitsInStock)
            setUnitsOnOrder(response.unitsOnOrder)
            setReorderLevel(response.reorderLevel)
            setCategoryId(response.categoryId)
            setSupplierId(response.supplierId)
        }

        fetchProduct();
    }, [id]);

    async function editProductHandler(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault()

        const editedProduct: any =
        {
            productName: productName,
            unitPrice: unitPrice,
            productId: +id,
            quantityPerUnit: quantityPerUnit,
            unitsInStock: unitsInStock,
            unitsOnOrder: unitsOnOrder,
            reorderLevel: reorderLevel,
            supplierId: supplierId,
            categoryId: categoryId
        }

        await productService.editCategory(editedProduct)

        navigate(`/products/${id}`)
    }

    return (<>
        <div className="container">
            <h2>Edit Product</h2>
            <form method="post" onSubmit={editProductHandler}>
                <div className="row">
                    <label htmlFor="product-name">Product Name:</label>
                    <input type="text" className="form-control" value={productName} name="product-name" id="product-name"
                        onChange={(e) => setProductName(e.target.value)}
                    />
                </div>

                <div className="row">
                    <label htmlFor="category-id">Category Id:</label>
                    <input type="text" className="form-control" value={categoryId} name="category-id" id="category-id"
                        onChange={(e) => setCategoryId(+e.target.value)}
                    />
                </div>

                <div className="row">
                    <label htmlFor="supplier-id">Supplier Id:</label>
                    <input type="text" className="form-control" value={supplierId} name="supplier-id" id="supplier-id"
                        onChange={(e) => setSupplierId(+e.target.value)}
                    />
                </div>

                <div className="row">
                    <label htmlFor="unit-price">Unit Price:</label>
                    <input type="text" className="form-control" value={unitPrice} name="unit-price" id="unit-price"
                        onChange={(e) => setUnitPrice(+e.target.value)}
                    />
                </div>

                <div className="row">
                    <label htmlFor="quantity-per-unit">Quantity Per Unit:</label>
                    <input type="text" className="form-control" value={quantityPerUnit} name="quantity-per-unit" id="quantity-per-unit"
                        onChange={(e) => setQuantityPerUnit(e.target.value)}
                    />
                </div>

                <div className="row">
                    <label htmlFor="units-in-stock">Units In Stock:</label>
                    <input type="text" className="form-control" value={unitsInStock} name="units-in-stock" id="units-in-stock"
                        onChange={(e) => setUnitsInStock(+e.target.value)}
                    />
                </div>

                <div className="row">
                    <label htmlFor="units-on-order">Units On Order:</label>
                    <input type="text" className="form-control" value={unitsOnOrder} name="units-on-order" id="units-on-order"
                        onChange={(e) => setUnitsOnOrder(+e.target.value)}
                    />
                </div>

                <div className="row">
                    <label htmlFor="reorder-level">Reorder Level:</label>
                    <input type="text" className="form-control" value={reorderLevel} name="reorder-level" id="reorder-level"
                        onChange={(e) => setReorderLevel(+e.target.value)}
                    />
                </div>

                <button className="btn btn-outline-primary mt-3" type="submit">Save</button>
                <Link className="btn btn-outline-dark mt-3" to="/products">Cancel</Link>
            </form>
        </div>
    </>)
}