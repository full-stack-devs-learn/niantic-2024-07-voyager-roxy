import EmployeesRowContainer from "../employees-row-container/EmployeesRowContainer"

export default function EmployeesPage() {
    return (
        <>
            <header className="container mt-4">
                <h1>Employees</h1>
            </header>
            <EmployeesRowContainer></EmployeesRowContainer>
        </>
    )
}