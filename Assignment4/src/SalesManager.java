
public class SalesManager extends Manager {
	
	 double commission;
	 double total1;

	public SalesManager(double commission,float a,int i,String n,double s) {
		super(a,i,n,s);
		this.commission = commission;
		System.out.println("Param (SalesManager) Initalized");
	}
	
	public SalesManager(){
		
		
	}
	public void displayDetails(){
		
		System.out.println("Name:"+name+" ID:"+id);
	}
	
	public   void calculateSalary(){
		
		total1=salary+allowance+commission;
		System.out.println("Total Salary(Sales Manager):"+total1);
		
	}

	
	
	

}
