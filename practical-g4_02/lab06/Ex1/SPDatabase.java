public class SPDatabase {
    private Adapter registos;
    private Adapter bd;

    public SPDatabase(Adapter registos, Adapter bd) {
        this.registos = registos;
        this.bd = bd;
    }

    public void addEmpregado(Employee employee) {
        if (isEmpregado(employee.getEmpNum())) {
            System.out.println("Empregado já existe");
        } else {
            bd.addAdp(employee);
        }
    }

    public void removeEmpregado(int codigo) {

            if (bd.isEmpregadoAdp(codigo)) {
                bd.deleteAdp(codigo);
                return;
            }
            if (registos.isEmpregadoAdp(codigo)) {
                registos.deleteAdp(codigo);
                return;
            }
            System.out.println("Empregado não existe");
        }


    public boolean isEmpregado(long codigo) {
        return bd.isEmpregadoAdp(codigo) || registos.isEmpregadoAdp(codigo);
    }

    public void getAll() {
        bd.getAllAdp();
        registos.getAllAdp();
    }
}
