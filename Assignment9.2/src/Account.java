import java.io.*;


public class Account implements Serializable {

	
	String doc;
	int number;
	String name;
	
	public Account(String doc, int number, String name) {
		super();
		this.doc = doc;
		this.number = number;
		this.name = name;
	}
	public String toString(){
		return "Name:"+name+"\tNumber:"+number+"\tDate of Creation:"+doc;
	}

	
	
}
