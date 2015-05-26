
public class User {

	public static void main(String[] args) {
		
		Emp e1= new Emp(12907,"Arjun",20000);
		Emp e2=new Manager(2000,12907,"Arjun",200);
		Emp e3=new SalesManager(200,2000,12907,"Arjun",20000);
		e1.calculateSalary();
		e2.calculateSalary();
		e3.calculateSalary();

	}

}
