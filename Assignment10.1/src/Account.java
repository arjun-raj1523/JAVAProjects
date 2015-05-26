
public class Account implements Runnable{
	
	 double balance;
	 double withdraw;
	 Thread t1,t2;
	public Account(){
		
		balance=5000;
		t1=new Thread(this,"t1");
		t2=new Thread(this,"t2");
		t1.start();
		t2.start();
		
		
	}
	public void run(){
		
		if(Thread.currentThread().getName().equals("t1")){
		synchronized(this)	{
			System.out.println("Thread 1");
			withdraw(3000);
		}
		}
		else{
			synchronized(this)	{
			System.out.println("Thread 2");
			withdraw(3000);
			}
		}
		try{
			
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		}
		
	
	
	 synchronized public void withdraw(double amt){
		if(amt<=balance)
			{	balance=balance-amt;
				System.out.println("Your balance after Withdraw Action:"+balance);
				System.out.println("------");
			}
		else
		{
			System.out.println("Insufficient balance \nYour Balance is:"+balance);
		System.out.println("------");
		}
	}
		

}
