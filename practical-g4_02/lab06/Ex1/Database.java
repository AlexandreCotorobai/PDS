import java.util.*;


class Database {
    // Data elements
    private Vector<Employee> employees; // Stores the employees
    
    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        // Code to add employee
        if(employees.contains(employee)) {
            return false;
        }else{
            employees.add(employee);
            return true;
        }
    }

    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpNum() == emp_num) {
                employees.remove(i);
                break;
            }
        }
    }

    public Employee[] getAllEmployees() {
    // Code to retrieve collection
        Employee[] employeesArray = new Employee[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            employeesArray[i] = employees.get(i);
        }
        return employeesArray;
    }
}

