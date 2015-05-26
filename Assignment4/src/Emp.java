
public class Emp {
	
	int id;
	String name;
	double salary;
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		System.out.println("Param (Employee) Initalized");
	}

	public Emp() {
		super();
	}
	
	public void displayDetails(){
		
		System.out.println("Name:"+name+" ID:"+id);
	}
	
	public  void  calculateSalary(){
		
		System.out.println("Total Salary(Employee):"+salary);
		
		
	}

}
