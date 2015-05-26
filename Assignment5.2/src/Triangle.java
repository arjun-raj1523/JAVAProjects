
public class Triangle extends Shape{
	double b,h;
	double area;
	public Triangle(double b,double h){
		this.b=b;
		this.h=h;
	
	}
	public void calculateArea(){
		
		area=0.5*b*h;
		System.out.println("Area of Triangle:"+area);
	}

}
