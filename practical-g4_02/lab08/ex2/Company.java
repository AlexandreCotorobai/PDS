import java.util.*;

class Company {

	public static User user;
	private List<Employee> emps = new ArrayList<>();
	private SocialSecurity ss = new SocialSecurity();
	private Insurance ins = new Insurance();
	private Parking parking = new Parking();
	private Card card = new Card();

	public void admitEmployee(Person person, double salary) {
		Employee e = new Employee(person, salary);
		emps.add(e);
		ss.regist(person);
		ins.regist(person);
		card.create(person);
		
		if (salary > averageSalary()){
			parking.allow(person);
		}
	}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			BankAccount ba = e.getBankAccount();
			ba.deposit(e.getSalary());
		}
	}

	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}

	public Double averageSalary() {
		double sum = 0;
		for (Employee e : emps) {
			sum += e.getSalary();
		}
		return sum / emps.size();
	}
}