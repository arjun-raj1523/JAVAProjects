import java.util.Scanner;


public class User {
	
	public static void findSqrRoot( int number) throws NegativeNumberException{
		
		if (number<0)
			throw new NegativeNumberException();
		else
		System.out.println("Square Root of "+number+" = "+Math.sqrt(number));
		
	}

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a Number:");
	    String s = in.nextLine();
	    int x = Integer.parseInt(s);
		try {
			findSqrRoot(x);
		}
		catch (NegativeNumberException ne) {
			System.out.println(ne+"\n");
			ne.printStackTrace();
		}

	}

}
