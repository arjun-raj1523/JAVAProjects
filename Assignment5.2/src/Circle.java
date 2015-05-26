
public class Circle extends Shape{
	double r;
	double area;
	public Circle(double r){
		this.r=r;
	
	}
	public void calculateArea(){
		
		area=2*3.14*r;
		System.out.println("Area of Circle:"+area);
	}

}
