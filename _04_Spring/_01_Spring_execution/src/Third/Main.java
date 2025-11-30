package Third;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import First.Student;

public class Main 
{
	public static void main(String args[])
	{
		// Context assign
		
		ApplicationContext a1 = new ClassPathXmlApplicationContext("/Second/applicationContext.xml");
		
		Student s1 = (Student)a1.getBean("t1");
		
		s1.show();
		
	}
}
