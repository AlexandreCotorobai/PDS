import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("------Alinea a)------");

        // cria diferentes empregrados e bases de dados
        Employee e1 = new Employee("Joao", 1, 1000);
        Employee e2 = new Employee("Maria", 2, 2000);
        
        Empregado e3 = new Empregado("Joao", "Rua", 3, 1000);
        Empregado e4 = new Empregado("Maria", "Rua", 4, 2000);

        Database bd = new Database();
        Registos registos = new Registos();

        // coloca os empregrados nas bases de dados
        bd.addEmployee(e1);
        bd.addEmployee(e2);

        registos.insere(e4);

        bd.deleteEmployee(2);
        

        // remover um empregado do registo se
        if(registos.isEmpregado(3)) {
            System.out.println("Empregado 3 existe nos registos");

        } else {
            System.out.println("Empregado 3 não existe nos registos, adicionando..");
            registos.insere(e3);
        }

        // listar todos os empregados
        List<Empregado> empregados = registos.listaDeEmpregados();

        for (int i = 0; i < empregados.size(); i++) {
            System.out.println("REGISTRO: " + empregados.get(i).nome() + " " + empregados.get(i).apelido() + " - " + empregados.get(i).codigo() + "(" + empregados.get(i).salario() + "$)");
        }

        Employee[] empregados2 = bd.getAllEmployees();

        for (int i = 0; i < empregados2.length; i++) {
            System.out.println("BD: " + empregados2[i].getName() + " - " + empregados2[i].getEmpNum() + "(" + empregados2[i].getSalary() + "$)");
        }

        System.out.println("\n------Alinea b)------");

        Adapter bdAdapter = new DatabaseAdapter(bd);
        Adapter registAdapter = new RegistoAdapter(registos);

        SPDatabase spdatabase = new SPDatabase(bdAdapter, registAdapter);


        spdatabase.addEmpregado(new Employee("Joaozinho", 10, 1000));
        spdatabase.addEmpregado(new Employee("MariaBELA", 11, 2000));
        spdatabase.addEmpregado(new Employee("MARIBELA", 12, 1000));

        if (spdatabase.isEmpregado(10)) {
            System.out.println("Empregado 10 existe");
        } else {
            System.out.println("Empregado 10 não existe");
        }

        if (spdatabase.isEmpregado(999999)) {
            System.out.println("Empregado 99999 existe");
        } else {
            System.out.println("Empregado 99999 não existe");
        }

        spdatabase.removeEmpregado(10);

        spdatabase.getAll();



    }    
}
