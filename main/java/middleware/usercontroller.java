package middleware;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.Userdao;
import main.Product;
import main.Supplier;
import main.User;
@Controller
public class usercontroller {
	@Autowired
Userdao userdao;
	@ModelAttribute("adduser")
	public User getUser()
	{
		return new User();
		
	}
	@RequestMapping("/signup")
public String getProductDetails(Model model,HttpServletRequest request)

{


	
	List<main.User> Userlist=userdao.getAllUsers();
	model.addAttribute("Userlist",Userlist);
	
	String email=request.getParameter("email");
	if(email!=null)
		
	{
		
	
		User r=userdao.find(email);
        model.addAttribute("curruser",r);   
		 return "signup";
	}
	 
	 return "signup";
}
@RequestMapping(value="adduser",method=RequestMethod.POST)
	public String adduser(@Valid @ModelAttribute("adduser")User r,Errors es,Model model,HttpServletRequest request)
	{ 
	if(es.hasErrors()) 
	   {
		   
			return "signup";
	   }
		r.setUser_role("ROLE_USER");
		userdao.addUser(r);
		return"redirect:login";
	}
@RequestMapping(value="updateuser",method=RequestMethod.POST)
public String updateUser(User User)
{
	String email=User.getemail();
   User r=userdao.find(email);
   r.setemail(User.getemail());
   r.setPassword(User.getPassword());
   r.setUser_role(User.getUser_role());
   r.setConfirmpassword(User.getConfirmpassword());
   r.setUserName(User.getUserName());
   userdao.updateUser(r);
   return "redirect:signup";
}

}
