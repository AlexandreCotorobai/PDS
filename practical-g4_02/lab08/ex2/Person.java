
class Person {
	
private String name;

	public Person(String n) {
		name = n;
		// bankAccount = new BankAccountImpl("PeDeMeia", 0); // fica new BankProxy("PeDeMeia", 0);
	}

	public String getName() {
		return name;
	}
	
}