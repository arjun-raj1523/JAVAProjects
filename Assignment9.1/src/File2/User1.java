package File2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class User1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			char y=' ';
			int x=0;
			FileInputStream fis = new FileInputStream("File1");
			FileOutputStream fos= new FileOutputStream("File2");
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			
		while(x != -1){
			
				x=br.read();
				if(x!=-1)
				y=(char)x;
				fos.write(y);
				System.out.print(y);
			
		}
		fis.close();
		fos.close();
		br.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	

	}

}
