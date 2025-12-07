package _05_Hibernate_OneToMany_Mapping._05_Hibernate_OneToMany_Mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        
    	Configuration con = new Configuration();
    	
    	con.configure("hibernate.cfg.xml");
    	
    	SessionFactory sf =  con.buildSessionFactory();
    	
    	Session s =  sf.openSession();
    /*	
    	Teacher t1 = new Teacher();
    	
    	t1.setTid(101);
    	t1.setTname("Vaibhav Sir");
    	t1.setTsubject("Java");
    	
    	Student s1 = new Student();
    	s1.setSid(1010);
    	s1.setSname("Rahul");
    	s1.setSclass("Final Year");
    	s1.setT(t1);
    	
    	Student s2= new Student();
    	s2.setSid(2020);
    	s2.setSname("Umesh");
    	s2.setSclass("Full stack");
    	s2.setT(t1);
    	
    	List<Student> l1 = new ArrayList<Student>();
    	
    	l1.add(s1);
    	l1.add(s2);
    	
    	t1.setL1(l1);
    	
    	// to save items
    	s.save(t1);
    	s.save(s1);
    	s.save(s2);
    	
    	*/
    	
    	// to fetch teacher data
    	Teacher t = (Teacher) s.get(Teacher.class, 101);
    	for(Student std : t.getL1())
    	{
    		System.out.println(std.getSname());
    	}
    	
    	// to fetch data through student
    	System.out.println("Teacher information : ");
    	Student stud1 = (Student) s.get(Student.class, 1010);
    	
    	System.out.println(stud1.getSname() + " : " +stud1.getT().getTname());
    	
    	s.beginTransaction().commit();
    }
}
