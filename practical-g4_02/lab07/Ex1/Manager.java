public class Manager extends EmpDecorator{
    
    public Manager(IEmployee emp) {
        super(emp);
    }

    @Override
    public void work() {
        super.work();
        System.out.print(" is managing");
    }

    public void manage() {
        System.out.println(super.getnome() +  " manages");
    }
}
