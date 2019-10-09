package middleware;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.Supplierdao;
import main.Product;
import main.Supplier;
@Controller
public class Suppliercontroller {
	

	@Autowired
	Supplierdao supplierdao;
		@ModelAttribute("addsupplier")
		public Supplier getSupplier()
		{
			return new Supplier();
		}
		@RequestMapping("/supplierDetails")
		
		public String getProductDetails(Model model,HttpServletRequest request)
		
		{
			//java.util.List<Supplier> productlist=Supplierdao.getAllProducts();
	     	 //model.addAttribute("supplierlist", supplierlist);
			
			List<main.Supplier> supplierlist=supplierdao.getAllSuppliers();
			model.addAttribute("supplierlist",supplierlist);
			
			String id=request.getParameter("id");
			if(id!=null)
				
			{
				int wid=Integer.parseInt(id);
				Supplier w=supplierdao.find(wid);
		        model.addAttribute("currsupplier",w);   
				 return "Editsupplier";
			}
			 
			 return "supplierDetails";
		}
		 @RequestMapping(value="addsupplier",method=RequestMethod.POST)
	       	public String addsupplier(Supplier Supplier)
	       	{
	       		supplierdao.addSupplier(Supplier);
	       		return"redirect:supplierDetails";
	       	}
		 @RequestMapping(value="updateSupplier",method=RequestMethod.POST)
    		public String updateSupplier(Supplier Supplier)
    		{
    			int id=Supplier.getId();
    		   Supplier w=supplierdao.find(id);
    		   w.setId(Supplier.getId());
    		   w.setSupplierName(Supplier.getSupplierName());
    		   w.setSupplieraddress(Supplier.getSupplieraddress());
    		   supplierdao.updateSupplier(w);
    		   return "redirect:supplierDetails";
    		}
		 @RequestMapping("/deletesupplierDetails")
	     public String deleteproduct(HttpServletRequest request)
	     {
	    	 int id=Integer.parseInt(request.getParameter("id"));
	        Supplier pr=supplierdao.find(id);
	        supplierdao.deleteSupplier(pr);
	        return "redirect:supplierDetails";
	     }
		 
}
