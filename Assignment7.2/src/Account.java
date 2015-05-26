
public class Account {
	
	int account_number;
	String name;
	double balance;
	
	public Account(){
		
		
		
	}
	
	public Account(int account_number, String name,
			double balance) {
		super();
		this.account_number = account_number;
		this.name = name;
		this.balance = balance;
	}
	
	public void displayData(){
		
		System.out.println("Name:"+name+" Account Number:"+
							account_number+" Balance:"+balance);
	}
	
	public void withdraw(double amt){
		try{
		if(amt<=balance){
			balance=balance-amt;
		} else
			throw new InsufficientBalanceException();
			} catch (InsufficientBalanceException ie) {
				// TODO Auto-generated catch block
				System.out.println(ie+"\n");
				ie.printStackTrace();
			}
		
	}
	
	

}
