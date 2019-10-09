	package middleware;
	
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import javax.servlet.http.HttpSession;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpRequest;
	import org.springframework.security.core.context.SecurityContextHolder;

import dao.Cartdao;
import dao.Productdao;
	import main.Product;
	
	@Controller
public class Homecontroller {
		@Autowired
		Productdao productdao;
		@Autowired
		Cartdao cartdao;
		@RequestMapping("/")
		public String getIndex()
		{
			return "index ";
		}
		
		@RequestMapping("/login")
		public String getlogin()
		{
			return "login";
		}
		@RequestMapping("/adminhome")
		public String getAdminHome()
		{
			return "adminhome";
		}
		@RequestMapping("/Userhome")
		public String getUserHome(HttpSession session,Model model)
		{
			String username=SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username", username);
		java.util.List<Product> productlist=productdao.getAllProducts();
		model.addAttribute("productlist", productlist);
		model.addAttribute("username",username);
		java.util.Date dt=new java.util.Date();
		String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
		int size=cartdao.totalelements(cartid);
		model.addAttribute("cartsize",size);
			return "Userhome";
		}
		@RequestMapping("/logout")
		public String logout(HttpSession session,Model m)
		{
			m.addAttribute("logoutstatus", true);
			m.addAttribute("logoutmessage", "logged out successfully");
			session.invalidate();
			return "login";
		}
		
}
