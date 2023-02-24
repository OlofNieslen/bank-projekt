import java.util.ArrayList;
import java.util.Scanner;

public class BanklApplication {
	private static Scanner scan = new Scanner(System.in);
	private static boolean run = true;
	private static Bank b = new Bank();
	private static String name;
	private static long idNr;
	private static int accountNr;
	private static int accountNr2;
	private static double balance;
	private static int newNr = 1001;

	public static void main(String[] args) {

		scan.useDelimiter(System.lineSeparator());

		while (run) {
			switch (Menu()) {
			case 1:
				System.out.print("id: ");
				ArrayList<BankAccount> idList = b.findAccountsForHolder(inputLong());
				if (idList == null) {
					System.out.println("konto saknas");
					break;
				}
				for (int i = 0; i < idList.size(); i++) {
					System.out.println(idList.get(i));
				}
				break;
			case 2:
				System.out.print("namn: ");
				ArrayList<Customer> nameList = b.findByPartofName(inputString());
				if (nameList.size() == 0) {
					System.out.println("konto saknas");
				}
				for (int i = 0; i < nameList.size(); i++) {
					System.out.println(nameList.get(i));
				}
				break;
			case 3:
				System.out.print("konto: ");
				accountNr = inputInt();
				System.out.print("belopp: ");
				balance = inputDouble();
				if (b.findByNumber(accountNr) == null) {
					System.out.println("konto saknas");
					break;
				}
				b.findByNumber(accountNr).deposit(balance);
				System.out.println(b.findByNumber(accountNr));
				break;
			case 4:
				System.out.print("konto: ");
				accountNr = inputInt();
				System.out.print("belopp: ");
				balance = inputDouble();
				if (b.findByNumber(accountNr) == null) {
					System.out.println("konto saknas");
					break;
				}
				if (b.findByNumber(accountNr).getAmount() >= balance) {
					b.findByNumber(accountNr).withdraw(balance);
					System.out.println(b.findByNumber(accountNr));
				} else {
					System.out.println(
							"utaget misslyckades, endast " + b.findByNumber(accountNr).getAmount() + " på kontot!");
				}
				break;
			case 5:
				System.out.print("från konto: ");
				accountNr = inputInt();
				System.out.print("till konto: ");
				accountNr2 = inputInt();
				System.out.print("belopp: ");
				balance = inputDouble();
				if (b.findByNumber(accountNr) == null || b.findByNumber(accountNr2) == null) {
					System.out.println("konto saknas");
					break;
				} else if (b.findByNumber(accountNr).getAmount() >= balance) {
					b.findByNumber(accountNr).withdraw(balance);
					b.findByNumber(accountNr2).deposit(balance);

					System.out.println(b.findByNumber(accountNr));
					System.out.println(b.findByNumber(accountNr2));
				} else {
					System.out.println(
							"överföringen misslyckades, endast " + b.findByNumber(accountNr).getAmount() + " på kontot!");
				}
				break;
			case 6:

				System.out.print("namn: ");
				name = inputString();
				System.out.print("id: ");
				idNr = inputLong();
				b.addAccount(name, idNr);
				System.out.println("konto skapat: " + newNr);
				newNr++;
				break;
			case 7:
				System.out.print("konto: ");
				accountNr = inputInt();
				if (b.removeAccount(accountNr)) {
					System.out.println("konto nummer " + accountNr + " togs bort");
				} else {
					System.out.println("felaktight kontonummer!");
				}
				break;
			case 8:
				for (int i = 0; i < b.getAllAccounts().size(); i++) {
					System.out.println(b.getAllAccounts().get(i));
				}
				break;
			case 9:
				run = false;
				break;
			}
		}

	}

	public static int Menu() {

		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("1. Hitta konto utifrån innehavare");
		System.out.println("2. Sök kontoinnehavare utifrån (del av) namn");
		System.out.println("3. Sätt in");
		System.out.println("4. Ta ut");
		System.out.println("5. Överföring");
		System.out.println("6. Skapa konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut konton");
		System.out.println("9. Avsluta");
		System.out.print("val: ");

		return (inputInt());
	}

	public static long inputLong() {
		while (true) {
			if (scan.hasNextLong()) {
				return scan.nextLong();
			} else {
				System.out.println("skriv giltigt nummer");
				scan.next();
			}
		}
	}

	public static int inputInt() {
		while (true) {
			if (scan.hasNextInt()) {
				return scan.nextInt();
			} else {
				System.out.println("skriv giltigt nummer");
				scan.next();
			}
		}

	}

	public static String inputString() {
		while (true) {
			if (scan.hasNext()) {
				return scan.next();
			} else {
				System.out.println("skriv giltig input");
				scan.next();
			}
		}
	}

	public static double inputDouble() {
		while (true) {
			if (scan.hasNextDouble()) {
				return scan.nextDouble();
			} else {
				System.out.println("skriv giltigt nummer");
				scan.next();
			}
		}
	}
}
