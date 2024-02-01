import java.util.Date;

public class Main {
    public static void main(String[] args) {

        IEmployee emp = new Employee("John");
        emp.start(new Date());
        emp.work();
        emp.terminate(new Date());
        System.out.println();

        IEmployee teamM = new TeamMember(emp);
        teamM.work();
        System.out.println();

        IEmployee teamLeader = new TeamLeader(emp);
        IEmployee teamMember = new TeamMember(teamLeader);
        IEmployee manager = new Manager(teamMember);
        teamLeader.work();
        System.out.println();

        ((Manager)manager).manage();
        ((TeamLeader)teamLeader).plan();
        ((TeamMember)teamMember).collaborate();

    }
}
