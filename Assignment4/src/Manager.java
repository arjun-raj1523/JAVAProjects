
public class Manager extends Emp {
	
	 double allowance;
	 double total;

	public Manager(double allowance,int i,String n,double s) {
		super(i,n,s);
		this.allowance = allowance;
		this.total=0;
		System.out.println("Param (Manager) Initalized");
	}
	
	public Manager(){
		
		
	}
	public void displayDetails(){
		
		System.out.println("Name:"+name+" ID:"+id);
	}
	
	public   void calculateSalary(){
		
		total=salary+allowance;
		System.out.println("Total Salary(Manager):"+total);
		
	}

	
	
	

}
