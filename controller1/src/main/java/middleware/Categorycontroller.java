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

import dao.Categorydao;

import main.Category;

@Controller
public class Categorycontroller {
	 
	@Autowired
	Categorydao categorydao;
	
	@ModelAttribute("addcategory")
	public Category getCategory()
	{
		return new Category();
	}
	
	@RequestMapping("/categoryDetails")
	
	public String getProductDetails(Model model,HttpServletRequest request)
	
	{
		//java.util.List<Supplier> productlist=Supplierdao.getAllProducts();
     	 //model.addAttribute("supplierlist", supplierlist);
		
		List<Category> categorylist=categorydao.getAllCategorys();
		model.addAttribute("categorylist",categorylist);
		
		String id=request.getParameter("id");
		if(id!=null)
			
		{
			int qid=Integer.parseInt(id);
			Category q=categorydao.find(qid);
	        model.addAttribute("currcategory",q);   
			 return "Editcategory";
		}
		 
		 return "categoryDetails";
	}
	@RequestMapping(value="addcategory",method=RequestMethod.POST)
   	public String addcategory(@Valid @ModelAttribute("addcategory")Category Category,Errors ek,Model model,HttpServletRequest request)
   	{
		if(ek.hasErrors()) 
	   {
		   
			return "categoryDetails";
	   }
   		categorydao.addCategory(Category);
   		return"redirect:categoryDetails";
   	}
	@RequestMapping(value="updateCategory",method=RequestMethod.POST)
	public String updateSupplier(Category Category)
	{
		int categoryid=Category.getCategoryid();
	   Category q=categorydao.find(categoryid);
	   q.setCategoryid(Category.getCategoryid());
	   q.setCategoryName(Category.getCategoryName());
	   
	   categorydao.updateCategory(q);
	   return "redirect:categoryDetails";
	}

	@RequestMapping("/deletecategoryDetails")
    public String deleteproduct(HttpServletRequest request)
    {
   	 int id=Integer.parseInt(request.getParameter("id"));
       Category pr=categorydao.find(id);
       categorydao.deleteCategory(pr);
       return "redirect:categoryDetails";
    }
	 
}
