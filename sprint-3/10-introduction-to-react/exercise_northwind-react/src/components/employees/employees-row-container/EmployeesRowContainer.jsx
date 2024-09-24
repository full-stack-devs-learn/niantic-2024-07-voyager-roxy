import EmployeesRow from "../employees-row/EmployeesRow"
import { employees } from '../../../data'
import { useState } from "react"


export default function EmployeesRowContainer() {
    const [selectedEmployee, setSelectedEmployee] = useState(null);

    const employeeSelected = (id) => {
        const employee = employees.find(person => person.employeeId === id)
        setSelectedEmployee(employee)
        console.log(employee)
    }

    return (
        <main className="container mt-4 employees-container" id="employees-container">
            {selectedEmployee && (
                <div className="employee-row">
                    <img id="employee-image" src={`images/employees/${selectedEmployee.employeeId}.webp`} style={{ width: "200px", height: "auto" }} />
                    <div className="employee-name">
                        <h1>{`${selectedEmployee.firstName} ${selectedEmployee.lastName}`}</h1>
                        <h6>Title: {selectedEmployee.title}</h6>
                        <h6>Salary: ${selectedEmployee.salary}</h6>
                        <h6>Notes: {selectedEmployee.notes}</h6>
                    </div>
                </div>
            )}
            <div>
                {
                    employees.map((employee) => (
                        <EmployeesRow key={employee.employeeId}
                            id={employee.employeeId}
                            name={`${employee.firstName} ${employee.lastName}`}
                            title={employee.title}
                            onEmployeeSelected={employeeSelected}></EmployeesRow>
                    ))
                }
            </div>
        </main>
    );
}