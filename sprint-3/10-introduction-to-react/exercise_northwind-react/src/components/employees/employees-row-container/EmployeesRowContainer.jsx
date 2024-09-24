import EmployeesRow from "../employees-row/EmployeesRow"
import { employees } from '../../../data'


export default function EmployeesRowContainer()
{
    return(
        <main className="container mt-4 employees-container" id="employees-container">
            {
                employees.map((employee) => (
                    <EmployeesRow key={employee.employeeId}
                    id={employee.employeeId}
                    name={`${employee.firstName} ${employee.lastName}`}
                    title={employee.title}></EmployeesRow>
                ))
            }
        </main>
    )
}