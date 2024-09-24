
export default function EmployeesRow({id, name, title, onEmployeeSelected})
{
    const imageUrl = `images/employees/${id}.webp`

    const employeeClicked = () => {
        onEmployeeSelected(id)
    }
    
    return(
        <div className="employee-row" onClick={employeeClicked} style={{cursor: 'pointer'}}>
          <img id="employee-image" src={imageUrl} />
          <div className="employee-name">
            <h1>{name}</h1>
            <h6>{title}</h6>
          </div>
        </div>
    )
}