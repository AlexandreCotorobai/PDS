public class DatabaseAdapter implements Adapter{
    private Database bd;

    public DatabaseAdapter(Database bd) {
        this.bd = bd;
    }

    @Override
    public boolean addAdp(Employee employee) {
        return bd.addEmployee(employee);
        // return bd.addEmployee(new Employee(employee.getName(), (int) employee.getEmpNum(), employee.getSalary()));
    }

    @Override
    public void deleteAdp(long emp_num) {
        bd.deleteEmployee(emp_num);
    }

    @Override
    public boolean isEmpregadoAdp(long emp_num) {
        Employee[] empregados = bd.getAllEmployees();
        for (int i = 0; i < empregados.length; i++) {
            if (empregados[i].getEmpNum() == emp_num) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void getAllAdp() {
        for (Employee e : bd.getAllEmployees()) {
            System.out.println("Employee number " + e.getEmpNum() + " is called " + e.getName() + " and earns " + e.getSalary() + " euros.");
        }
    }
}
