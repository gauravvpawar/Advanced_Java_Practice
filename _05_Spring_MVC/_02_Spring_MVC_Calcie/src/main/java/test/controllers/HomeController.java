package test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.Model.Num;


@Controller
public class HomeController
{
	@RequestMapping("/check")
	public void check()
	{
		System.out.println("check the map for servlet");
	}
	
	@RequestMapping("/num")
	public String num()
	{
		return "Number";
	}
	
	@RequestMapping("/AddPerform")
	public void add(@ModelAttribute Num n)
	{
		System.out.println(n);
		System.out.println(n.getFirstNum() + n.getSecondNum());
	}
	
	//by the request parameter
	@RequestMapping("/Addition")
	public String addCheck()
	{
		return "Addition";
	}
	
	@RequestMapping("/SubPerform")
	public void sub(@ModelAttribute Num n)
	{
		System.out.println(n);
		System.out.println(n.getFirstNum() - n.getSecondNum());
	}
	
	//by the request parameter
	@RequestMapping("/Substraction")
	public String subCheck()
	{
		return "Substraction";
	}
	
	@RequestMapping("/MulPerform")
	public void mul(@ModelAttribute Num n)
	{
		System.out.println(n);
		System.out.println(n.getFirstNum() * n.getSecondNum());
	}
	
	//by the request parameter
	@RequestMapping("/Multiplication")
	public String mulCheck()
	{
		return "Multiplication";
	}
	
	@RequestMapping("/DivPerform")
	public void div(@ModelAttribute Num n)
	{
		System.out.println(n);
		System.out.println(n.getFirstNum() / n.getSecondNum());
	}
	
	//by the request parameter
	@RequestMapping("/Division")
	public String divCheck()
	{
		return "Division";
	}
}
