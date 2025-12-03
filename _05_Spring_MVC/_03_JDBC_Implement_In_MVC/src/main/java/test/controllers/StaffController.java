package test.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.Dao.StaffDao;
import test.Model.Staff;

@Controller
public class StaffController 
{
	@Autowired
	StaffDao s;
	
	@RequestMapping("/check")
	public void one()
	{
		System.out.println("Request Mapping working successfully");
	}
	
	@RequestMapping("/reg")
	public String reg()
	{
		return "StaffRegistrationForm";
	}

	
	@RequestMapping("staffData")
	public String staffData(@ModelAttribute Staff s1)
	{
		System.out.println(s1);
		
		s.add(s1);
		System.out.println("Saved data Successfully");
		return "redirect:/";
	}
	
	@RequestMapping("/display")
	public String show(Model m)
	{
		List<Staff> l1 =  s.fetchAllData();
		m.addAttribute("temp" , l1);
		return "Display";
	}
	
//	to delete data from table
	@RequestMapping("/deleteData/{id}")
	public String delete(@PathVariable int id)
	{
		s.deleteData(id);
		System.out.println("Data Deleted Successfully");
		// when you want to hit URL inside the URL the have to use redirect
		return "redirect:/display";
	}
	
	// to show edit form
	@RequestMapping("/editData/{id}")
	public String edit(@PathVariable int id , Model m)
	{
		List<Staff> l1 =  s.fetchData(id);
		m.addAttribute("temp" , l1);
		return "UpdateForm";
	}
	
	// to update data
	@RequestMapping("/updateData")
	public String updateData(@ModelAttribute Staff s1)
	{
		s.updateData(s1);
		System.out.println("Data Updated Successfully");
		return "redirect:/display";
	}
	
	// user login page
	@RequestMapping("login")
	public String log()
	{
		return "Login";
	}
	
	@RequestMapping("/loginData")
	public String login(@RequestParam("semail") String email , @RequestParam("spassword") String password , HttpSession hs)
	{
		System.out.println(email);
		System.out.println(password);
		
		List<Staff> l1 = s.checkLog(email,password);
		
		if(l1.isEmpty())
		{
			System.out.println("data not matched");
			return "redirect:/";
		}
		
		hs.setAttribute("email", email);
		System.out.println("User login successfully");
		
		return "redirect:/dash";
	}
	
	@RequestMapping("/dash")
	public String dash(HttpSession hs)
	{
		String email = (String)hs.getAttribute("email");
		
		if(email == null)
		{
			return "redirect:/";
		}
		
		return "DashBoard";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession hs)
	{
		hs.invalidate();
		return "redirect:/";
	}
	
}
