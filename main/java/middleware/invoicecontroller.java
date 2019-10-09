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
import dao.Paymentdao;
import dao.Productdao;
import dao.Supplierdao;
import main.Cart;
import main.Payment;
@Controller
public class invoicecontroller {
	
	@Autowired
	Cartdao cartdao;
	@Autowired
	Productdao productdao;
	@Autowired
	Supplierdao supplierdao;
	@Autowired
	Paymentdao paymentdao;
	@RequestMapping("/invoice")
	public String getPayment(Model model,HttpSession session,HttpServletRequest request)
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
 java.util.List<Payment> productlist=paymentdao.getAllPayments(cartid);
 model.addAttribute("productlist", productlist);
String id=request.getParameter("id");
List<main.Payment> supplierlist=paymentdao.getAllPayments(cartid);
model.addAttribute("supplierlist",supplierlist);
return "invoice";
	}
}
