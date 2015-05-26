
public class Utility {
	
	public static void printall(Printable[] par){
		
		int i;
		System.out.println("Utility Class Initiated");
		for(i=0;i<par.length;i++){
			
			par[i].print();
		}
		
		
	}

}
