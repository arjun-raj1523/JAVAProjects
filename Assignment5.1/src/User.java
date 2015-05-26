import java.util.ArrayList;


public class User {
	
	
	public static void main(String[] args){
		
		Animal a[]=new Animal[3];
		a[0]=new Cat();
		a[1]=new Dog();
		a[2]=new Lion();
		for(int i=0;i<a.length;i++){
			
			a[i].talk();
		}
		Animal.respirate();
		
		
	}

}
