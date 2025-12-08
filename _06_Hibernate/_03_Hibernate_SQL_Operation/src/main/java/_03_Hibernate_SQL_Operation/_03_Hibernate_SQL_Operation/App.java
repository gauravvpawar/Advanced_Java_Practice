package _03_Hibernate_SQL_Operation._03_Hibernate_SQL_Operation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
      
    	Configuration con = new Configuration().configure("hibernate.cfg.xml") ;
    	
    	SessionFactory sf =  con.buildSessionFactory();
    	
    	Session s =  sf.openSession();
    	
    	
//    	Employee e1 = new Employee();
//    	e1.setEid(111);
//    	e1.setEname("Gaurav");
//    	e1.setEemail("gaurav@gmail.com");
//    	e1.setEaddress("Swargate");
    	
 //   	s.save(e1);
    	
//    	Employee e2 = new Employee();
//    	e2.setEid(222);
//    	e2.setEname("Kaif");
//    	e2.setEemail("kaif@gmail.com");
//    	e2.setEaddress("Karve Nagar");
//    	
//    	s.save(e2);
    	
//      	Employee e3 = new Employee();
//      	e3.setEid(333);
//      	e3.setEname("Umesh");
//      	e3.setEemail("umesh@gmail.com");
//      	e3.setEaddress("Shaniwar wada");
//    	
//    	s.save(e3);
    	
    	
//    	to get all data
    	List<Employee> l1 = s.createQuery("from Employee").list();
    	System.out.println("All Data From entity : ");
    	System.out.println(l1);
    	
    	// to get perticular data
    	Employee e1 = (Employee) s.get(Employee.class,111);
    	System.out.println(e1);
    	
    	// to fetch the data by the column wise
    	List<Employee> l2  =  s.createQuery("from Employee where eaddress ='Swargate' ").list();
    	System.out.println(l2);
    	
    	// delete data by name wise
    	
    	Query q1 =  s.createQuery("delete from Employee where ename = 'Umesh' ");
    	q1.executeUpdate();
    	System.out.println("Data deleted successfully");
    	
//    	// to fetch data
//    	List<Employee> l3 =  s.createQuery("from Employee").list();
//    	System.out.println(l3);
    	
    	s.beginTransaction().commit();
    	
    }
}
