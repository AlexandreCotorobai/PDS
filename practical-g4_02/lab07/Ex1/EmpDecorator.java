import java.util.Date;

public abstract class EmpDecorator implements IEmployee{
    protected IEmployee emp;

    public EmpDecorator(IEmployee emp) {
        this.emp = emp;
    }

    @Override
    public String getnome() {
        return emp.getnome();
    }

    @Override
    public void start(Date date) {
        emp.start(date);
    }

    @Override
    public void terminate(Date date) {
        emp.terminate(date);
    }

    @Override
    public void work() {
        emp.work();
    }
}
