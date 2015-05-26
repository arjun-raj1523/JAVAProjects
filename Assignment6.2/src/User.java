
public class User {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Date d1= new Date();
			Date d2= new Date(1,2,1993);
			d1=d2;
			System.gc();
			System.out.println("Works");
	}

}
