public class TeamMember extends EmpDecorator {
    
    public TeamMember(IEmployee emp) {
        super(emp);
    }

    @Override
    public void work() {
        super.work();
        System.out.print(" on a team");
    }

    public void collaborate() {
        System.out.println(super.getnome() + " colaborates");
    }
    
}
