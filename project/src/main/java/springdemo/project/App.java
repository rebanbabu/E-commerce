package springdemo.project;


import org.springframework.beans.BeansException;
/**
 * Hello world!
 *
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Cartdao;
import dao.Paymentdao;
import dao.Productdao;
import dao.Userdao;
import main.Cart;
import main.Payment;
import main.Product;
import main.User;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
	   public static void main( String[] args )
    {
    	 {
    		 try {
    	
    			 ApplicationContext ctx=new AnnotationConfigApplicationContext(Springconfiguration.class);
    	
    	
    	//Productdao a=(Productdao )ctx.getBean("Productdao");
    	Paymentdao f=(Paymentdao)ctx.getBean("Paymentdao");
       //Product p=a.find(2);
    	
    	/*Categorydao b=(Categorydao)ctx.getBean("Categorydao");*/
    	//Supplierdao c=(Supplierdao)ctx.getBean("Supplierdao");
    	// Userdao d=(Userdao)ctx.getBean("Userdao");
    	 //Cartdao e=(Cartdao)ctx.getBean("Cartdao");
    	// Userdao d=(Userdao)ctx.getBean("Userdao");
    	/*
    	/*a.addProduct(pr);
    	a.find(pr.getProductid());*/
    	/*Supplier b=(Supplier)ctx.getBean("Supplier");
    	System.out.println(Supplier.Product().getproductName());*/
    	//Productdao daoimpl=(Productdao)ctx.getBean("productdao");*/
    	//java.util.List<Product> list=a.getAllProducts();
    	/*for(Product p :list)
    	{
    		System.out.println(p.getProductName()+" "+p.getPrice()+" "+p.getProductid());
    	}*/
    		 
    	/*Product p=new Product();
    	 p.setProductName("tea");
    	p.setPrice(50);
    	p.setCategoryid(1);
    	p.setQuantity(1);
    	p.setSupplierid(1);
    	 
    	 
    	 if(a.addProduct(p))
    	 {
    	 	System.out.println("product added");
    	 }*/
    	 Payment y=new Payment();
    	 y.setPaymentmethod("cash");
    	 y.setCartid("1");
    	 if(f.addPayment(y))
    	 {
    	 	System.out.println("payment added");
    	 }
    	/*Category q=new Category();
    	
    	q.setCategoryName("electronics");
    	if(b.addCategory(q))
    	{
    		System.out.println("Category added");
    	}*/
    	/*Supplier w=new Supplier();
    	w.setSupplierName("reban");
    	w.setSupplieraddress("thanjavur");
    	if(c.addSupplier(w))
    	{
    		System.out.println("Supplier added");
    	}*/
    	/* User r=new User();
    	  r.setUserName("reban");
    	  r.setPassword("****");
    	  r.setShippingaddress("10/32,sengal kara street ,karanthai,thanjavur");
    	 if(d.addUser(r))
    	 {
    		 System.out.println("User added");
    	 }
    	 
    	 Cart t=new Cart();
    	 t.setEmail("trebanbabu27@gmail.com");
    	 t.setPrice(100);
    	 t.setProductid(1);
    	 if(e.addCart(t))
    	 {
    		 System.out.println("Cart added");
    	 }*/
    		 }
    	 catch (Throwable e) 
    		 {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	        
    	    }
    	 
    }
    }
    

