package _06_Hibernate_ManyToMany_Mapping._06_Hibernate_ManyToMany_Mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
    	
    	Configuration con = new Configuration().configure("hibernate.cfg.xml");
    	
    	SessionFactory sf =  con.buildSessionFactory();
    	
    	Session s = sf.openSession();
    	
/*    	to save data
    	Authors a1 = new Authors();
    	a1.setAid(111);
    	a1.setAname("Willium Shakesphere");
    	
    	Authors a2 = new Authors();
    	a2.setAid(222);
    	a2.setAname("Jane Austen");
    	
    	
    	
    	Books b1 = new Books();
    	b1.setBid(1);
    	b1.setBname("Hamlet");
    	
    	
    	Books b2 = new Books();
    	b2.setBid(2);
    	b2.setBname("Romeo and Julet");
    	
    	List<Authors> li = new ArrayList<Authors>();
    	li.add(a1);
    	li.add(a2);
    	
    	b1.setList(li);
    	b2.setList(li);
    	
    	List<Books> book = new ArrayList<Books>();
    	book.add(b1);
    	book.add(b1);
    	
    	a1.setList(book);
    	a2.setList(book);
    	
    	
    	s.save(a1);
    	s.save(a2);
    	s.save(b1);
    	s.save(b2);
    	
    	
   */ 	
//    	to fetch data
    	Authors a1 = (Authors) s.get(Authors.class, 111);
    	
    	for(Books b : a1.getList())
    	{
    		System.out.println("Book : " + b.getBname() + " : Authors ");
    		
    		for(Authors a : b.getList())
    		{
    			System.out.println("---- Author : " + a.getAname());
    		}
    	}
    	
    	s.beginTransaction().commit();
    	
    }
}
