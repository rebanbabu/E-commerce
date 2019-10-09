package middleware;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.Cartdao;
import dao.Paymentdao;
import main.Cart;
import main.Payment;
import main.Product;

@Controller
public class Paymentcontroller {
@Autowired
Paymentdao paymentdao;
@Autowired
Cartdao cartdao;

@ModelAttribute("addpayment")
public Payment getPayments()
{
	return new Payment();
}
@RequestMapping(value="add",method=RequestMethod.POST)
public String getPayment(Payment payment,HttpSession session)
{
	String username=(String)session.getAttribute("username");
	 
    java.util.Date dt=new java.util.Date();
   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
   payment.setCartid(cartid);
 paymentdao.addPayment(payment);
	return "redirect:payment";
}

@RequestMapping("/payment")
public String getPayment(Model model,HttpServletRequest request,HttpSession session)
{
	
	String username=(String)session.getAttribute("username");
	 
    java.util.Date dt=new java.util.Date();
   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
	java.util.List<Payment> productlist=paymentdao.getAllPayments(cartid);
	 model.addAttribute("productlist", productlist);
	String id=request.getParameter("id");
	List<main.Payment> supplierlist=paymentdao.getAllPayments(cartid);
	model.addAttribute("supplierlist",supplierlist);
	return "payment";
}
@RequestMapping(value="addpayment",method=RequestMethod.POST)
public String addPayment(@Valid @ModelAttribute("addpayment")Payment payment,Errors ek,HttpSession session)
	{
	String username=(String)session.getAttribute("username");
	 
    java.util.Date dt=new java.util.Date();
   String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+username+"/";
   payment.setCartid(cartid);
 paymentdao.addPayment(payment);
	if(ek.hasErrors()) 
	   {
			return "payment";
	   }
	return "redirect:invoice";
	
	}
}
