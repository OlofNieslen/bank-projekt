
public class BankAccount {

	private Customer c;
	private int accountNbr;
	static private int currentNumber = 1001;
	private double balance = 0;

	public BankAccount(String holderName, long holderId) {
		c = new Customer(holderName, holderId);
		accountNbr = currentNumber;
		currentNumber++;
	}

	public BankAccount(Customer holder) {
		c = holder;

		accountNbr = currentNumber;
		currentNumber++;
	}

	public Customer getHolder() {
		return c;
	}

	public int getAccountNumber() {
		return accountNbr;
	}

	public double getAmount() {
		return balance;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}

	public String toString() {
		return ("konto " + accountNbr + " (" + c.toString() + "): " + balance);
	}
}
