package test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.model.User;

@Controller
public class HomeController 
{
	@RequestMapping("/check")
	public void check()
	{
		System.out.println("Just check the console");
	}
	
	
	@RequestMapping("/rf")
	public String reg()
	{
		return "Register";
	}
	
	@RequestMapping("/regData")
	public void regData(@RequestParam("name") String name , @RequestParam("password") String password )
	{
		System.out.println("Name : " + name);
		System.out.println("Password : " + password);
	}
	
	// for the user registration
	@RequestMapping("/ur")
	public String userRegister()
	{
		return "UserRegistration";
	}
	
	@RequestMapping("/userSaveData")
	public String userData(@ModelAttribute  User u1)
	{
		System.out.println("Registration Successfull");
		System.out.println(u1);
		return "Registration Successfull";
	}
	
}
