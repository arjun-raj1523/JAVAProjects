
public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s[]=new Shape[3];
		s[0]= new Circle(3);
		s[1]= new Rectangle(3,4);
		s[2]= new Triangle(3,4);
		
		for(int i=0;i<s.length;i++){
			s[i].calculateArea();
		}
		
		
		

	}

}
