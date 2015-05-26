import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import sj.hibernate.javacalendar.Employee;

public class AddEmployee
{
	public static void main(String[] args)
	{
		Session session = null;
		SessionFactory factory;
		AnnotationConfiguration ac=	new AnnotationConfiguration();
       System.out.println(ac);
		ac.configure()
        .buildSessionFactory();
		try
		{
			System.out.println("in try");
		//	String[] arg=new String[3];
			//factory=new Configuration().configure().buildSessionFactory();
			
		factory=	new AnnotationConfiguration()
            .configure()
            .buildSessionFactory();
		System.out.println("factory obtained");
			session=factory.openSession();
               System.out.println("session obtained");
			Transaction tr=session.beginTransaction();
			
			//args[0]="1";
			//args[2]="20000";
			//args[1]="aaa";
			int id=Integer.parseInt(args[0]);
			int sl=Integer.parseInt(args[2]);

		Employee emp=new Employee(id,args[1],sl);
			session.save(emp);
			tr.commit();
			System.out.println("Record Added");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
}