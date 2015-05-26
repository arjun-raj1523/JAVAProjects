import java.util.*;


public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Emp> ar= new ArrayList<Emp>();
		Emp e1= new Emp();
		Emp e2= new Emp(1,"Arjun");
		Emp e3= new Emp(2,"karj");
		Emp e4= new Emp(3,"Jun");
		 
		ar.add(e1);
		 ar.add(e2);
		 ar.add(e3);
		 ar.add(e4);
		 System.out.println("--------------");
		 System.out.println("Before Sorting");
		 System.out.println("--------------");
		
		 Iterator itr= ar.iterator();
		 while(itr.hasNext()){
			 System.out.println(itr.next());
		 }
		 
		 System.out.println("--------------");
		 System.out.println("After Sorting");
		 System.out.println("--------------");
		 
		 Collections.sort(ar);
		 
		 Iterator itr1= ar.iterator();
		 while(itr1.hasNext()){
			 System.out.println(itr1.next());
		 }
		

	}

}
