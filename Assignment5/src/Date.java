
public class Date {
	int dd;
	int mm;
	int yy;
	public Date(int dd, int mm, int yy) {
		super();
		this.dd = dd;
		this.mm = mm;
		this.yy = yy;
		System.out.println("Param Initalized");
	}
	
	public Date(){
		
		System.out.println("Non-Param Initalized");
	}
	
	public void displayDate(){
		
		System.out.println("Date:"+dd+"/"+mm+"/"+yy);
		
	}

}
