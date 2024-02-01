public class TeamLeader extends EmpDecorator{
    
    public TeamLeader(IEmployee emp) {
        super(emp);
    }

    @Override
    public void work() {
        super.work();
        System.out.print(" is leading");
    }

    public void plan() {
        System.out.println(super.getnome() + " plans");
    }
}
