import java.util.Scanner;


public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		
		Account a= new Account(1,"arjun",2000);
		System.out.println("Enter Amount to Withdraw:");
		String in=s.next();
		double amt=Double.parseDouble(in);
		a.withdraw(amt);
		a.displayData();

	}

}
