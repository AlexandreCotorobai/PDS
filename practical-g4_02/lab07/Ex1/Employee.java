import java.util.Date;

public class Employee implements IEmployee{
    String nome;
    Date startDate;
    Date endDate;
    // boolean isWorking;

    Employee(String nome) {
        this.nome = nome;
    }

    public String getnome() {
        return nome;
    }


    @Override
    public void start(Date date) {
        this.startDate = date;
    }

    @Override
    public void terminate(Date date) {
        this.endDate = date;
    }

    @Override
    public void work() {
        System.out.print(nome + " is working");
    }
}
