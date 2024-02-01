public class RegistoAdapter implements Adapter {
    private Registos registos;

    public RegistoAdapter(Registos registos) {
        this.registos = registos;
    }

    @Override
    public boolean addAdp(Employee employee) {
        if (this.isEmpregadoAdp(employee.getEmpNum())) {
            return false;
        }else{
            registos.insere(new Empregado(employee.getName(), "", (int) employee.getEmpNum(), employee.getSalary()));
            return true;
        }
    }

    @Override
    public void deleteAdp(long emp_num) {
        registos.remove((int) emp_num);
    }

    @Override
    public boolean isEmpregadoAdp(long emp_num) {
        return registos.isEmpregado((int) emp_num);
    }

    @Override
    public void getAllAdp() {
        for (Empregado e : registos.listaDeEmpregados()) {
            System.out.println("Empregado number " + e.codigo() + " is called " + e.nome() + " " + e.apelido() + " and earns " + e.salario() + " euros.");
        }
    }
}
