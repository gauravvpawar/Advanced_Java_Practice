package _04_Hibernate_OneToOne_Mapping._04_Hibernate_OneToOne_Mapping;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
    	
    	Configuration con =  new Configuration().configure("hibernate.cfg.xml");
    	
    	SessionFactory sf =  con.buildSessionFactory();
    	
    	Session s = sf.openSession();
    	
  	/*
    	Doctor d1 = new Doctor();
    	d1.setDid(1111);
    	d1.setDname("Dr . Shukla");
    	d1.setDemail("shukla@gmail.com");
    	
    	Patient p1 = new Patient();
    	p1.setPid(001);
    	p1.setPname("Raghu");
    	p1.setPdisease("maleria");
    	p1.setD(d1);
    	
    	d1.setP(p1);
    	
    	s.save(d1);
    	s.save(p1);
  
    	
    	
    	
    	Doctor d2 = new Doctor();
    	d2.setDid(1212);
    	d2.setDname("Dr . Lohe");
    	d2.setDemail("lohe@gmail.com");
    	
    	Patient p2 = new Patient();
    	p2.setPid(010);
    	p2.setPname("Shyam");
    	p2.setPdisease("Johndis");
    	p2.setD(d2);
    	
    	d2.setP(p2);
    	
    	s.save(d2);
    	s.save(p2);
  */  	
    	// to fetch data
    	
    	Doctor doc = (Doctor) s.get(Doctor.class,1212);
    	System.out.println(doc);
    	System.out.println(doc.getP().getPname() + " : " + doc.getP().getPdisease() );
    	
    	// to get patient information
    	Patient p = (Patient) s.get(Patient.class, 001);
    	System.out.println(p);
    	System.out.println(p.getD().getDname());
    	
    	s.beginTransaction().commit();
    }
}
