class Employee {

	private double salary;
	private Person person;

	public Employee(Person people, double s) {
		salary = s;
		person = people;
	}

	public double getSalary() {
		return salary;
	}

	public Person getPerson() {
		return person;
	}

	public BankAccount getBankAccount() {
		return person.getBankAccount();
	}

	public double totalBalance() {
		return getBankAccount().balance();
	}

	private BankAccount getBankAccount() {
		return person.getBankAccount();
	}

	public void deposit(double amount) {
		getBankAccount().deposit(amount);
	}
}