import java.util.Comparator;


public class Emp implements Comparable,Comparator {
	
	int eid;
	String name;
	
	public Emp(){
		this.eid=0;
		this.name="Default";
		
	}
	
	public Emp(int eid,String name){
		this.eid=eid;
		this.name=name;
	}
	
	public void display(){
		
		System.out.println("Employee ID:"+eid+"\t Name:"+name);
	}
	
	public String toString(){
		return "Employee ID:"+eid+"\t Name:"+name;
		
		
	}
	
	@Override
	public int compareTo(Object o) {
		Emp o1= (Emp) o; 
		return this.eid-o1.eid;
	}

	@Override
    public int compare(Object o1, Object o2) {
		Emp e1= (Emp) o1;
		Emp e2= (Emp) o2;
		return e1.name.compareTo(e2.name);
    }


}