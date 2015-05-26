
public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount b1= new Saving(1,'S',"arjun",20000);
		BankAccount b2= new Current(1,'C',"arjun",20000);
		
		b1.displayData();
		b1.balance();
		b2.displayData();
		b2.balance();
		
	}

}
