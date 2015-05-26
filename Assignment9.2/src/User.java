import java.io.*;


public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		char y=' ';
		int x=0;
		FileOutputStream fout = new FileOutputStream("MyFile");
		FileOutputStream fout1 = new FileOutputStream("MyFile1");
		FileInputStream fin=new FileInputStream("MyFile");
		
		ObjectOutputStream obj = new ObjectOutputStream(fout);
		ObjectOutputStream obj2 = new ObjectOutputStream(fout1);
		ObjectInputStream obj1= new ObjectInputStream(fin);
		
			Account a= new Account("23/7/2014",21,"Arjun");
			obj.writeObject(a);
			System.out.println(obj1.readObject());
			obj1.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
