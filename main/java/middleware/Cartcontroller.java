   package middleware;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.Cartdao;
import main.Cart;

@Controller
public class Cartcontroller {
	
	@Autowired
	Cartdao cartdao;
	@RequestMapping(value="addtocart", method=RequestMethod.POST)
	   public String addtocart(Cart cart,HttpSession session)
	   {
		String username=(String)session.getAttribute("username");
		 
		    java.util.Date dt=new java.util.Date();
		   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
		    //String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+":"+t.get+":"+t.getProductid();
			cart.setCartid(cartid);
			cartdao.addCart(cart);
			return "redirect:Userhome";
	   }
	 @RequestMapping("/cartdetails")
	   public String viewCart(HttpSession session,Model model)
	   {
		 
		   String username=(String)session.getAttribute("username");
		   java.util.Date dt=new java.util.Date();
		   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
		   List<main.Cart> Cartlist=cartdao.getAllCarts(cartid);
				   float sum=0;
				   for(Cart c:Cartlist)
				   {
					   sum=sum+c.getPrice();
				   }
	           model.addAttribute("Cartlist",Cartlist);
		     model.addAttribute("carttotal",sum);
		   return "cartdetails";
	   }
	   @RequestMapping("/deletecartdetails")
	   public String deleteCart(HttpServletRequest request)
	   {
		   int id=Integer.parseInt(request.getParameter("id"));
		  Cart cart=cartdao.find(id);
		   cartdao.deletecart(cart);
		    return "redirect:cartdetails";
	   }
}
