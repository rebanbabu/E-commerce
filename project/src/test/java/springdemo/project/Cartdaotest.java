package springdemo.project;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Cartdao;
import jdk.nashorn.internal.ir.annotations.Ignore;
import main.Cart;

public class Cartdaotest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext(Springconfiguration.class);
	}
	

	@Test
	public void testaddCart() {
		Cartdao dao=(Cartdao)context.getBean("cartdao");
		Cart t=new Cart(); 	
		t.setPrice(400);
		t.setEmail("trebanbabu14@gmail.com");
		t.setProductid(2);
		java.util.Date dt=new java.util.Date();
		String cartid=	dt.getDate()+":"+dt.getYear()+":"+dt.getMonth()+":"+t.getEmail()+":"+t.getProductid();
		t.setCartid(cartid);
	dao.addCart(t);
	}

	/*@Test
	public void testDeleteCart() {
		Cartdao dao=(Cartdao)context.getBean("Cartdao");
		Cart t=dao.find(6);
	
		assert(dao.deleteCart(t));
		
	}

	@Test
	public void testFind() {
		Cartdao dao=(Cartdao)context.getBean("Cartdao");
		Cart t=dao.find(6);
		dao.updateCart(t);
	}

	@Ignore
	public void testUpdateCart() {
		Cartdao dao=(Cartdao)context.getBean("Cartdao");
		Cart t=dao.find(6);
		t.setPrice(10);
		dao.updateCart(t);
	}

	@Test
	public void testGetAllCarts() {
		Cartdao dao=(Cartdao)context.getBean("Cartdao");
		for(Cart t:dao.getAllCarts())
		{
			
		}
	}
*/
}
