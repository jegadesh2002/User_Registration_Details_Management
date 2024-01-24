package com.example.UserRegistreationform;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	@Autowired
	private UserService service;
	@RequestMapping("/")
	public String index(Model model)
	{
		List<User> listUserdetails=service.listAll();
		model.addAttribute("listUserdetails", listUserdetails);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showAddregForm(Model model)
	{
		User user=new User();
		List<String> cityList=Arrays.asList("Chennai","Coimbatore","Tirupur","Erode","Salem");
		model.addAttribute("u", user);
		model.addAttribute("cityList", cityList);
		return "addUser";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveRegister(@ModelAttribute("u") User user)
	{
		service.save(user);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editRegistration(@PathVariable(name="id") int id) 
	{
		List<String> cityList=Arrays.asList("Chennai","Coimbatore","Tirupur","Erode","Salem");
		
		ModelAndView mav=new ModelAndView("editUser");
		User user=service.get(id);
		mav.addObject("user",user);
		mav.addObject("cityList", cityList);
		return mav;
	}
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable(name="id") int id)
	{
		service.delete(id);
		return "redirect:/";
	}
}
