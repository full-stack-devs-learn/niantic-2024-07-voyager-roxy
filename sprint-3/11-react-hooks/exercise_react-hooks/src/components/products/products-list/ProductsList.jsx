import './ProductsList.css'

export default function ProductsList({categoryId})
{
    // call the products api - getProductsByCategoryId
    return (
        <>
        {(categoryId == 0) 
        ? <div className="container mt-4">No Category Selected</div>
        : <h3 className="container mt-4">
                Products for category: {categoryId}
          </h3>
        }
        </>
    )
}