
public class User {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e= new Employee(1,"Arjun");
		Account a1= new Account(2,"Arj");
		Account a2= new Account(1,"Arjun");
		System.out.println(e.equals(a1));
		System.out.println(a2.equals(e));
		System.out.println(e.toString());
		System.out.println(a1.toString());
	}

}
