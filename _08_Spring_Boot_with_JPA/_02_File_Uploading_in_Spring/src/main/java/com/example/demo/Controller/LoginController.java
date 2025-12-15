package com.example.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;

@Controller
public class LoginController 
{
	@Autowired
	UserService us;
	
	@RequestMapping("/login")
	public String log()
	{
		
		return "Login";
	}
	
	
	@RequestMapping("/logData")
	public String login(@RequestParam("email") String email , @RequestParam("password") String password , HttpSession hs)
	{
		User u =  us.fetchUser(email, password);
		
		if(u != null)
		{
			
			hs.setAttribute("email", u.getUemail());
			
			return "redirect:/dashboard";
			
		}
		
		return null;
	}
	
	// for dashboard
	@RequestMapping("/dashboard")
	public String dash(HttpSession hs)
	{
		if(hs.getAttribute("email") != null)
		{
			return "Dashboard";			
		}
		
		return "redirect:/login";
	}
	
	// for logout
	@RequestMapping("/logout")
	public String logout(HttpSession hs)
	{
		hs.invalidate();
		
		return "redirect:/reg";
	}
	
	
}
