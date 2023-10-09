/*
 * Author: Adam Grennan
 * Student number: C21445412
*/

public class Customer{

	private String pps;
	private String fName;
	private String sName;
	private String date;
	private int ID;
	private static int counter=1001;
	private String password;
	private String adminPass = "BankFee";
	private CustomerAccount location;
	
	public Customer() {
		this.pps = "";
		this.fName = "";
		this.sName = "";
		this.date = "";
		this.ID = 0;
		this.password = "";
		this.location = null;
		this.adminPass = "BankFee";
	}
	
	public Customer(String pps,String fName,String sName,String date,int ID,String password) {
		this.pps = pps;
		this.fName = fName;
		this.sName = sName;
		this.date = date;
		this.password = password;
		this.ID = counter;
	    counter++;
	    this.location = null;
	 
	}
	
	public Customer(String pps,String fName,String sName,String date,int ID,String password,CustomerAccount loc) {
		this.pps = pps;
		this.fName = fName;
		this.sName = sName;
		this.date = date;
		this.password = password;
		this.ID = counter;
	    counter++;
	    this.location = loc;
	 
	}
	
	public String getPPS() {
		return this.pps;
	}
	
	public void setPPS(String pps) {
		this.pps = pps;
	}
	
	public String getfName() {
		return this.fName;
	}
	
	public void setfName(String f) {
		this.fName = f;
	}
	
	public String getSName() {
		return this.sName;
	}
	
	public void setSName(String s) {
		this.sName = s;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String d) {
		this.date = d;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void setID(int i) {
		this.ID = i;
	}
	
	public String getPassWord() {
		return this.password;
	}
	
	public void setPassword(String p) {
		this.password = p;
	}
	
	public CustomerAccount getLocation() {
		return this.location;
	}
	
	public void setLocation(CustomerAccount l) {
		this.location = l;
	}
	
public String toString(){
		
		return "\nCustomer ID: " + this.ID + "\n"
			   + " PPS number: " + this.pps + "\n"
			   + " Customer first name: " + this.fName + "\n"
			   + " Customer surname: " + this.sName  + "\n"
			   + " Date account created: " + this.date + "\n"
			   + " Password: " + this.password;
	}//displays employee details from list

public String getAdminPass() {
	return adminPass;
}

public void setAdminPass(String adminPass) {
	this.adminPass = adminPass;
}
}
