import java.io.*;
public class User {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try{
		char y = ' ';
		BufferedInputStream bis= new BufferedInputStream(System.in);
        FileOutputStream fos= new FileOutputStream("File1");
        while(y!='`'){
        	y=(char)bis.read();
        	if(y!='`')
        	fos.write(y);
        	else
        		break;
        }
        
        fos.close();
		}catch(Exception e){
			e.printStackTrace();
	}
	
		
		
		
	}

}
