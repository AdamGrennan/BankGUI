/*
 * Author: Adam Grennan
 * Student number: C21445412
*/

public class CustomerAccount{

	private String aNumber;
	private double balance;
	private AccountTransaction statements;
	
	public CustomerAccount() {
		this.aNumber = "";
		this.balance = 0;;
	}
	
	public CustomerAccount(String a,double b) {
		this.aNumber = a;
		this.balance = b;
	}
	
	
	public String getANumber() {
		return this.aNumber;
	}
	
	public void setANumber(String a) {
	      this.aNumber = a;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance(double b) {
	      this.balance = b;
	}
	
	public AccountTransaction getStatements() {
		return this.statements;
	}

	public void setStatements(AccountTransaction statements) {
		this.statements = statements;
	}
	
public String toString(){
		
		return "\nAccount Number: " + this.aNumber + "\n"
			   + "Account Balance: " + this.balance + "\n";
			  
		    
	}


}

