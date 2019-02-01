package Controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import beans.RegistrationBean;
import dao.MyDao;

@Controller
@SessionAttributes("name")
public class RegistrationController {
   
	@RequestMapping("/")
	  public ModelAndView welcome()
	  {
		ModelAndView mv=new ModelAndView("Home");
		mv.addObject("msg", "Welcome To Matrimonial...");
		return mv;
	 }
	@RequestMapping("/Registration")
	  public ModelAndView userDetails()
	  {
		ModelAndView mv=new ModelAndView("Registration");
		mv.addObject("msg", " Please Insert Your Details");
		return mv;
	 }
	@RequestMapping("/Register")
	  public ModelAndView insertEmployee(@ModelAttribute RegistrationBean e)
	  {	
		MyDao m=new MyDao();
		   int x=m.insert(e);
		   ModelAndView mv=null;
		   if(x!=0)
			{
			  mv=new ModelAndView("Registration","msg","Data Inserted Successfully"); 
			}
			else {
				mv=new ModelAndView("Registration","msg","Data Not Inserted");
			}
		return mv;
	  }
	
	@RequestMapping("/login")
	  public ModelAndView viewDetails()
	  {
		ModelAndView mv=new ModelAndView("AdminLogin");
		mv.addObject("msg");
		return mv;
	}
	
	@RequestMapping("/View")
	  public ModelAndView view()
	  {
		ModelAndView mv=new ModelAndView("View");
		mv.addObject("msg");
		return mv;
	}
	
	
	@RequestMapping("/AdminCheck")
	  public ModelAndView login(@RequestParam String emailid,@RequestParam String password)
	  {	
		MyDao m=new MyDao();
		   int x=m.login(emailid,password);
		   ModelAndView mv=null;
		   if(x==1)
			{
			   String gender=m.getGender(emailid);
			   mv=new ModelAndView("View");
			   ArrayList<RegistrationBean>  list=m.viewDetails(gender);
				mv.addObject("LIST",list);	
				mv.addObject("uid",emailid);
			}
			else {
				mv=new ModelAndView("AdminLogin","msg","Incorrect EmailId And Password");
			}
		return mv;
	  }
}