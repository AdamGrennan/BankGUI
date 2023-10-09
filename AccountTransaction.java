/*
 * Author: Adam Grennan
 * Student number: C21445412
*/

public class AccountTransaction {
private String date;
private String type;
double amount;
CustomerAccount num;

public AccountTransaction() {
	this.date= "";
	this.type = "";
	this.amount = 0;
	this.num = null;
}

public AccountTransaction(CustomerAccount num,String date,String type,double amount) {
	this.date= date;
	this.type = type;
	this.amount = amount;
	this.num = num;
}



public String getDate() {
	return this.date;
}
public void setDate(String date) {
	this.date = date;
}
public String getType() {
	return this.type;
}
public void setType(String type) {
	this.type = type;
}

public Double getAmount() {
	return this.amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}

public CustomerAccount getNum() {
	return this.num;
}
public void setNum(CustomerAccount num) {
	this.num = num;
}
public String toString(){
	
	return "\n" + this.num 
		   + "Transaction Type: " + this.type + "\n"
		   + "Amount: " + this.amount + "\n"
		   + "Date: " + this.date;
}//displays employee details from list

}
