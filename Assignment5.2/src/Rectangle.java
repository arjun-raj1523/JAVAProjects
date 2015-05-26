
public class Rectangle extends Shape{
	double l,b;
	double area;
	public Rectangle(double l,double b){
		this.l=l;
		this.b=b;
	
	}
	public void calculateArea(){
		
		area=l*b;
		System.out.println("Area of Rectangle:"+area);
	}

}
