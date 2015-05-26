
public class Account {
	int account_id;
	String name;
	public Account(int id, String name) {
		super();
		this.account_id = id;
		this.name = name;
	}
	@Override
	public  boolean equals(Object e){
		if((((Employee)e).id==account_id)&&(((Employee)e).name==name))
		{	
			System.out.println("HashCode:"+e.hashCode());
			return true;
		}
		else
		{
			
			return false;
		}
	}
	@Override
	public String toString(){
		return "Account";
		
		
	}
	@Override
	public int hashCode(){
		return 10;
		
		
	}
}
