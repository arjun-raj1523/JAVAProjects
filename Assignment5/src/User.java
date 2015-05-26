
public class User {

	public static void main(String[] args) {
		
		Date d= new Date();
		Date d1=new Date(10,7,2014);
		Date d2= new Date(11,7,2014);
		swap(d1, d2);
		d1.displayDate();
		d2.displayDate();
		swap1(d1, d2);
		d1.displayDate();
		d2.displayDate();
		
	}
	
	public static void swap(Date d1, Date d2){
		
		Date temp;
		temp=d1;
		d1=d2;
		d2=temp;
		System.out.println("Output of SWAP");
		d1.displayDate();
		d2.displayDate();
				
	}
	
	
	public static void swap1(Date d1,Date d2){
		Date temp = new Date();
		temp.dd=d1.dd;
		temp.mm=d1.mm;
		temp.yy=d1.yy;
		d1.dd=d2.dd;
		d1.mm=d2.mm;
		d1.yy=d2.yy;
		d2.dd=temp.dd;
		d2.mm=temp.mm;
		d2.yy=temp.yy;
		System.out.println("Output of SWAP1");
		d1.displayDate();
		d2.displayDate();
	}
	

}
