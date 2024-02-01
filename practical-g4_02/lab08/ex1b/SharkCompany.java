import java.util.*;

public class SharkCompany {
	public static void main(String[] args) {
		Person[] persons = {
				new Person("Maria Silva"),
				new Person("Manuel Pereira"),
				new Person("Aurora Machado"),
				new Person("Augusto Lima")
		};

		Company shark = new Company();
		Company.user = User.OWNER;

		shark.admitEmployee(persons[0], 1000);
		shark.admitEmployee(persons[1], 900);
		shark.admitEmployee(persons[2], 1200);
		shark.admitEmployee(persons[3], 1100);

		List<Employee> sharkEmps = shark.employees();

		for (Employee e : sharkEmps)
			// "talking to strangers", but this is not a normal case
			System.out.println(e.getSalary());
		
		for (Employee e : sharkEmps)
			System.out.println(e.totalBalance());

		shark.paySalaries(1);
		
		for (Employee e : sharkEmps)
			System.out.println(e.totalBalance());
	
	}
}