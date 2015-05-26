
public class Emp {
	int id;
	String name;
	double salary;
	static int count;
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		count++;
		System.out.println("Param (Employee) Initalized");
	}

	public Emp() {
		super();
		count++;
	}
	
	public void displayDetail(){
		
		
		System.out.println("Name:"+name+" ID:"+id+" Salary:"+salary);
	}
	
public static void displayCount(){
		
		
		System.out.println("Number of Objects:"+count);
	}

}
