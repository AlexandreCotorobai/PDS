class Employee {

	private double salary;
	private BankAccount bankAccount;
	private Person person;

	public Employee(Person people, double s) {
		salary = s;
		bankAccount = new BankProxy("PeDeMeia", 0);
		person = people;
	}

	public double getSalary() {
		return salary;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public Person getPerson() {
		return person;
	}

	public double totalBalance() {
		return bankAccount.balance();
	}
}