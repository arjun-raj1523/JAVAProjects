
public class Employee {
	int id;
	String name;
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public  boolean equals(Object o){
		if((((Account)o).account_id==id)&&(((Account)o).name==name))
		{	
			System.out.println("HashCode:"+o.hashCode());
		
			return true;
	
	}
		else
		return false;
	}
	@Override
	public String toString(){
		return "Employee";
		
	}
	@Override
	public int hashCode(){
		
		return 10;
		
		
	}

}
