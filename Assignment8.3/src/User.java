import java.util.*;
public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		HashMap hm  = new HashMap();
		Book b1= new Book();
		Book b2= new Book("Harry Potter1",500);
		Book b3= new Book("Harry Potter3",50);
		Book b4= new Book("Harry Potter2",503);
		hm.put(b1,500);
		hm.put(b2,b2);
		hm.put(b3,502);
		hm.put(b4,500);
		
		System.out.println("-----------------");
		System.out.println("From HashMap .get Method");
		System.out.println("-----------------");
		System.out.println("Page Numbers:");
		System.out.println(hm.get(b1));
		System.out.println(hm.get(b2));
		System.out.println(hm.get(b3));
		System.out.println(hm.get(b4));
		
		System.out.println("-----------------");
		System.out.println("From Book Class");
		System.out.println("-----------------");
		b1.display();
		b2.display();
		b3.display();
		b4.display();
	
		Iterator itr = hm.entrySet().iterator();
		System.out.println("-----------------");
		System.out.println("Using EntrySet");
		System.out.println("-----------------");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	
			
	}
	

}

class Book{
	
	 String name;
	 int eid;
	public Book(){
	     this.name="Default";
	     this.eid=0;
	}
	
	public Book(String name,int eid){
	     this.name=name;
	     this.eid=eid;
	}
	
	public void display(){
		System.out.println("Name:"+name+"\t ID:"+eid+"\t");	
	}
	
	public String toString(){
		return "Name:"+name+"\t ID:"+eid+"\t";
	}
	
	@Override
	  public boolean equals(Object object) {
	    boolean result = false;
	    if (object == null || object.getClass() != getClass()) {
	      result = false;
	    } else {
	      Book b = (Book) object;
	      if (this.eid == b.eid
	          && this.name == b.name) {
	        result = true;
	      }
	    }
	    return result;
	  }

	  // just omitted null checks
	  @Override
	  public int hashCode() {
	    int hash = 3;
	    hash = 7 * name.hashCode();
	    return hash;
	  }

} 