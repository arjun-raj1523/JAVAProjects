
public class Saving extends BankAccount{
	
	
	double balance_saving;
	public Saving(){
				
	}

	public Saving(int account_number, char account_type, String name,
					double balance) {
		
		super(account_number, account_type, name, balance);
	}
	
	public void balance(){
		
		balance=balance+(0.5*balance);
		System.out.println("Balance after ROI:"+balance);
	}
	

}
