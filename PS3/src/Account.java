import java.util.Date;

public class Account {

	// Variables
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	private double monthlyInterestRate;

	// constructors

	public Account() {
		this.id = 1122;
		this.balance = 20000;
		this.monthlyInterestRate = .0375;
		this.annualInterestRate = 0.45;
		Date date = new Date();
		this.dateCreated = date;
	}

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	// Getters and Setters
	public double getMonthlyInterestRate() {
		this.monthlyInterestRate = (annualInterestRate / 12);
		return this.monthlyInterestRate;
	}

	public void withdraw(double withdrawl) throws InsufficientFundsException {
		this.balance = this.balance - withdrawl;
		if (withdrawl > balance) {

			throw new InsufficientFundsException();
		}
	}

	public void deposit(double deposit) {
		this.balance = this.balance + deposit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void accountInfo() {
		System.out.println("balance: " + balance);
		System.out.println("Your monthly interest rate is 3.75" + monthlyInterestRate); ;
		System.out.println("No date on file " +dateCreated);
	}
}
