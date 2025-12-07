package _02_Embedabble_info._02_Embedabble_info;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Student s1 = new Student();
        
        s1.setSid(111);
        s1.setSname("Kaif");
        s1.setSemail("kaif@gmail.com");
    	
        Address a1 = new Address();
        a1.setArea("Karve Nagar");
        a1.setCity("Pune");
        a1.setPincode(411021);
        
        s1.setA(a1);
       
        Configuration con = new Configuration();
    	
    	con.configure("hibernate.cfg.xml");
    	
    	SessionFactory sf = con.buildSessionFactory();
    	
    	Session s =  sf.openSession();
    	Transaction t =  s.beginTransaction();
    	
    	
    	s.save(s1);
    	
    	t.commit();
        
        
        
        
        
    }
}
