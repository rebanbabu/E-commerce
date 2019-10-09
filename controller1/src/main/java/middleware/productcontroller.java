package middleware;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import dao.Productdao;
import dao.Supplierdao;

import main.Product;

@Controller
public class productcontroller 
{
	@Autowired
	Productdao productdao;
	@Autowired
	Supplierdao supplierdao;
	@ModelAttribute("addproduct")
	public Product getProduct()
	{
		return new Product();
	}
	@RequestMapping("/ProductDetails")
	public String getProductDetails(Model model,HttpServletRequest request)
	
	{
		java.util.List<Product> productlist=productdao.getAllProducts();
     	 model.addAttribute("productlist", productlist);
		String id=request.getParameter("id");
		List<main.Supplier> supplierlist=supplierdao.getAllSuppliers();
		model.addAttribute("supplierlist",supplierlist);
		
       
		if(id!=null)
			
		{
			int pid=Integer.parseInt(id);
			Product p=productdao.find(pid);
	        model.addAttribute("currproduct",p);   
			 return "Editproduct";
		}
		 
		 return "ProductDetails";
	}
           @RequestMapping(value="addproduct",method=RequestMethod.POST)
       	public String addProduct(@Valid @ModelAttribute("addproduct")Product product, Errors er,Model model,HttpServletRequest request)
       	{
        	   System.out.println(er.hasErrors());
       		
        	   if(er.hasErrors()) 
        	   {
        		   java.util.List<Product> productlist=productdao.getAllProducts();
        	     	 model.addAttribute("productlist", productlist);
        			String id=request.getParameter("id");
        			List<main.Supplier> supplierlist=supplierdao.getAllSuppliers();
        			model.addAttribute("supplierlist",supplierlist);
        			return "ProductDetails";
        	   }
       				
       		try 
       		{
       			MultipartFile image=(MultipartFile)product.getImage();
    			byte[] bt=new byte[(int)image.getSize()];
    			productdao.addProduct(product);
    			try
    			{
    				InputStream i=image.getInputStream();
    				i.read(bt);
    				FileOutputStream f=new FileOutputStream("F:\\e-cart\\controller1\\src\\main\\webapp\\resources\\images\\"+product.getProductid()+".jpg");
    				f.write(bt);
    				f.flush();
    			}
    			catch(Exception e)
    			{
    			      System.out.println(e);
    			}
    			System.out.println(bt);
    		}
    		catch(Exception e)
    		{
    			System.out.println(e);
    		}
    			return "redirect:ProductDetails";
       		}
           
       		@RequestMapping(value="updateproduct",method=RequestMethod.POST)
       		public String updateProduct(Product product)
       		{
       			int productid=product.getProductid();
       		   Product p=productdao.find(productid);
       		   
       		   p.setCategoryid(product.getCategoryid());
       		   p.setSupplierid(product.getSupplierid());
       		   p.setPrice(product.getPrice());
       		   p.setDescription(product.getDescription());
       	   p.setQuantity(product.getQuantity());
       	   p.setProductName(product.getProductName());
       	
       		   productdao.updateProduct(p);
       					
       			try 
       			{
       				MultipartFile image=(MultipartFile)product.getImage();
    			byte[] bt=new byte[(int)image.getSize()];
    			try
    			{
    				InputStream i=image.getInputStream();
    				i.read(bt);
    				FileOutputStream f=new FileOutputStream("F:\\e-cart\\controller1\\src\\main\\webapp\\resources\\images\\"+product.getProductid()+".jpg");
    				f.write(bt);
    				f.flush();
    			}
    			catch(Exception e)
    			{
    			      System.out.println(e);
    			}
    		System.out.println(bt);
    		}
    		catch(Exception e)
    		{
    			System.out.println(e);
    		}
    		return "redirect:ProductDetails";	
    	}

     @RequestMapping("/deleteproduct")
     public String deleteproduct(HttpServletRequest request)
     {
    	 int productid=Integer.parseInt(request.getParameter("id"));
        Product pr=productdao.find(productid);
        productdao.deleteProduct(pr);
        return "redirect:ProductDetails";
     }
    }
	

