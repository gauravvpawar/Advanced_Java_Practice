package _01_Hibernate_Implemetation_Demo._01_Hibernate_Implemetation_Demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
      
    	Staff s1 = new Staff();
    	
    	s1.setSid(202);
    	s1.setSname("Shivam");
    	s1.setSemail("shivam@gmail.com");

    	
    	Configuration con = new Configuration();
    	
    	con.configure("hibernate.cfg.xml");
    	
    	SessionFactory sf = con.buildSessionFactory();
    	
    	Session s =  sf.openSession();
    	Transaction t =  s.beginTransaction();
    	
//    	s.save(s1);
    	
    	// to fetch data
    	
    	Staff s2 = (Staff) s.get(Staff.class, 101);
    	
    	System.out.println(s2);
    	
    	// to fetch all data
    	
    	List<Staff> ls  =  s.createQuery("From Staff").list();
    	
    	System.out.println(ls);
    	
    	
    	// delete record
    	Staff shivam = (Staff) s.get(Staff.class, 202);
    	s.delete(shivam);
    	
    	System.out.println("Shivam data deleted");
    	
    	
    	
    	t.commit();
    	
    }
}
