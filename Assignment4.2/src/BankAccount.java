
public class BankAccount {
	
	int account_number;
	char account_type;
	String name;
	double balance;
	double rateOfintrest;
	
	
	public BankAccount(){
		
		
		
	}
	
	public BankAccount(int account_number, char account_type, String name,
			double balance) {
		super();
		this.account_number = account_number;
		this.account_type = account_type;
		this.name = name;
		this.balance = balance;
	}
	
	public void displayData(){
		
		System.out.println("Name:"+name+" Account Number:"+
							account_number+" Account Type:"+
							account_type);
	}
	
	public void balance(){
		
		System.out.println("Balance :"+balance);

	}
	

}
