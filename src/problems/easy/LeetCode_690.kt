package problems.easy

class LeetCode_690 {

    class Employee {
        var id: Int = 0
        var importance: Int = 0
        var subordinates: List<Int> = listOf()
    }

    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val employeesContainer = HashMap<Int, Employee>()
        employees.forEach { employeesContainer[it!!.id] = it }
        return collectImportance(employeesContainer[id]!!, employeesContainer)
    }

    private fun collectImportance(employee: Employee, container: HashMap<Int, Employee>): Int {
        var result = employee.importance
        employee.subordinates.forEach { result += collectImportance(container[it]!!, container) }
        return result
    }
}