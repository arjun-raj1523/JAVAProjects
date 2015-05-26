
public class User {

	
	public static void main(String[] args) {
		int i;
		Emp e[]= new Emp[4];
		e[0]= new Emp();
		e[1]= new Emp(1,"abc",100);
		e[2]= new Emp(2,"xyz",100);
		e[3]= new Emp(3,"lmo",100);
		for(i=0;i<e.length;i++){
			e[i].displayDetail();	
		}
		
		Emp.displayCount();
		
		

	}

	

}
