import java.util.*;


public class User {
	
	public static  void main(String[] args){
		
		Set<Emp> hs= new HashSet<Emp>();
		TreeSet<Emp>  ts= new TreeSet();
		TreeSet<Emp>  ts1= new TreeSet(new Emp());
		
		Emp e1= new Emp();
		Emp e2= new Emp(3,"Arjun");
		Emp e3= new Emp(1,"Karan");
		Emp e4= new Emp(4,"Zara");
		Emp e5= new Emp(2,"BBB");
		Emp e6= new Emp(5,"CCC");
		
		hs.add(e1);
		hs.add(e2);
		hs.add(e3);
		
		ts.add(e1);
		ts.add(e2);
		ts.add(e3);
		ts.add(e4);
		ts.add(e5);
		ts.add(e6);
		
		ts1.add(e1);
		ts1.add(e2);
		ts1.add(e3);
		ts1.add(e4);
		ts1.add(e5);
		ts1.add(e6);
	
		System.out.println("-----------------------------");
		
		System.out.println("Using Comparator Interface");
		System.out.println("-----------------------------");
		for(Emp o:ts1){	
			o.display();
		}
		
		System.out.println("-----------------------------");
		
		System.out.println("From HashSet");
		System.out.println("-----------------------------");
		for(Emp o:hs){	
			o.display();
		}
		
		System.out.println("-----------------------------");
		Iterator itr= ts.iterator();
		System.out.println("Using Comparable Interface");
		System.out.println("-----------------------------");
		while(itr.hasNext()){	
			System.out.println(itr.next());
		}
		
		System.out.println("-----------------------------");
		System.out.println("From Employee class");
		System.out.println("-----------------------------");
		e1.display();
		e2.display();
		e3.display();
	
		
		
	}

}
