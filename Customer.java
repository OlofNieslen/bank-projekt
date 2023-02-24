
public class Customer {

	private int customerNr;
	static private int currentNr = 101;
	private String name;
	private long idNr;

	public Customer(String name, long idNr) {
		this.name = name;
		this.idNr = idNr;
		customerNr = currentNr;
		currentNr++;
	}

	public String getName() {
		return name;
	}

	public long getIdNr() {
		return idNr;
	}

	public int getCustomerNr() {
		return customerNr;
	}

	public String toString() {
		return (name + ", id " + idNr + ", kundnr " + customerNr);
	}
}
