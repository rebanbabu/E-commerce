package springdemo.project;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Productdao;
import jdk.nashorn.internal.ir.annotations.Ignore;
import main.Product;

public class ProductDAOTest {
public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext(Springconfiguration.class);
	}

	@Test
	public void testaddProduct() {
		Productdao dao=(Productdao)context.getBean("productdao");
		Product p=new Product(); 	
		p.setPrice(1000);
		p.setProductName("coffee");
		p.setCategoryid(1);
		p.setSupplierid(1);
		p.setQuantity(1);
		p.setDescription("sweet");
	
		dao.addProduct(p);
	}
	
/*
	@Test
	public void testFind() {
		Productdao dao=(Productdao)context.getBean("Productdao");
		Product p=dao.find(10);
		
		System.out.println(p.getProductName());
	}
	@Ignore
	public void testupdateProduct() {
		Productdao dao=(Productdao)context.getBean("Productdao");
		Product p=dao.find(10);
	   p.setPrice(300);
	   dao.updateProduct(p);
		System.out.println(p.getProductName());
	}



	@Test
	public void testDeleteProduct() {
		Productdao dao=(Productdao)context.getBean("Productdao");
		Product p=dao.find(10);
		assert(dao.deleteProduct(p));
		
	}

	@Test
	public void testGetAllProducts() {
		Productdao dao=(Productdao)context.getBean("Productdao");
		for(Product p:dao.getAllProducts())
		{
			System.out.println(p.getProductName()+" "+p.getPrice());
		}
	}
*/
}
