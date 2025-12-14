package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;


@Controller
public class UserController 
{
	@Autowired
	UserService us;
	
	@RequestMapping("/")
	public String page()
	{
		return "index";
	}

	
	@RequestMapping("/reg")
	public String reg()
	{
		return "RegistrationForm";
	}
	
	// Register user
	@RequestMapping("/saveData")
	public String saveData(@ModelAttribute User u1 , @RequestParam("fname") MultipartFile fname) throws IllegalStateException, IOException
	{
		System.out.println(u1);
		System.out.println(fname.getOriginalFilename());
		
		String path = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Advanced_Java_Practice\\_08_Spring_Boot_with_JPA\\_02_File_Uploading_in_Spring\\src\\main\\resources\\static\\images";
		
		File f = new File(path);
		
		String fn = fname.getOriginalFilename();
		
		fname.transferTo(new File(f , fn));
		
		// set uid
		u1.setUid(UUID.randomUUID().toString());
		
		// setting file name
		u1.setFilename(fn);
		
		System.out.println(u1);
		
		us.registerUser(u1);
		
		return "Contact";
	}
	
	// to display all data
	@RequestMapping("/display")
	public String show(Model m)
	{
		List<User>li =  us.getAllUser();
		
		m.addAttribute("temp",li);
		
		
		return "Display";
		
	}
	
	//to delete user
	@RequestMapping("/delete/{uid}")
	public String delete(@PathVariable String uid)
	{
		us.deleteUser(uid);
		
		return "redirect:/display";
	}
	
	
	//to edit user
		@RequestMapping("/edit/{uid}")
		public String editForm(@PathVariable String uid , Model m)
		{
			
			User u = us.fetchSingleUser(uid);
			
			
			m.addAttribute("User" , u);
			
			return "EditForm";
		}
		
		
		// updateData
		@RequestMapping("/updateData")
		public String updateData(@ModelAttribute User u , @RequestParam("fname") MultipartFile fname) throws IllegalStateException, IOException
		{
			System.out.println(u);
			
			User user = us.fetchSingleUser(u.getUid());
			
			if(u.getUname() != null)
			{
				user.setUname(u.getUname());
			}
			
			if(u.getUpassword() != null)
			{
				user.setUpassword(u.getUpassword());
			}
			
			if(u.getUcnfPassword() != null)
			{
				user.setUcnfPassword(u.getUcnfPassword());
			}
			
			if(u.getGender() != null)
			{
				user.setGender(u.getGender());
			}
			
			if(u.getCountry() != null)
			{
				user.setCountry(u.getCountry());
			}
			
			if(u.getPhoneNumber() != null)
			{
				user.setPhoneNumber(u.getPhoneNumber());
			}
			
			
			System.out.println("updating");
			if(fname != null)
			{

				String path = "C:\\Users\\ASUS\\OneDrive\\Desktop\\Advanced_Java_Practice\\_08_Spring_Boot_with_JPA\\_02_File_Uploading_in_Spring\\src\\main\\resources\\static\\images";
				
				File f = new File(path);
				
				String fn = fname.getOriginalFilename();
				
				fname.transferTo(new File(f , fn));
				
				user.setFilename(fn);
				
			}
			
			us.registerUser(user);
			
			return "redirect:/display";
		}
		
	
}
