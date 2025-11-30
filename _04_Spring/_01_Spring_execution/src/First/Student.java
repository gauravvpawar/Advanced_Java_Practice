package First;

public class Student
{
	private String name;
	private int age;
	private String email;
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	
	public void show()
	{
		System.out.println("Name :" + name);
		System.out.println("age : " + age);
		System.out.println("email : " + email);

	}
}
