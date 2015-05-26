
public class Current extends BankAccount {
	
	
	double balance_current;
	
	public Current(){
		
		
	}

	public Current(int account_number, char account_type, String name,
					double balance) {
		
		super(account_number, account_type, name, balance);
		this.rateOfintrest = rateOfintrest;
	}
	
	public void balance(){
		
		balance=balance+(0.6*balance);
		System.out.println("Balance after ROI:"+balance);
	}
	

}
