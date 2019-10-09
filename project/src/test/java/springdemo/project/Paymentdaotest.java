package springdemo.project;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Paymentdao;
import dao.Paymentdao;
import dao.Paymentdao;
import dao.Paymentdao;
import jdk.nashorn.internal.ir.annotations.Ignore;
import dao.Paymentdao;
import main.Payment;
import main.Payment;
import main.Payment;
import main.Payment;
import main.Payment;

public class Paymentdaotest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext(Springconfiguration.class);
	}

	@Test
	public void testaddPayment() {
		Paymentdao dao=(Paymentdao)context.getBean("paymentdao");
		Payment y=new Payment();
		y.setPaymentmethod("card");
		y.setCartid("1");
	}

	/*@Ignore
	public void testfind() {
		Paymentdao dao=(Paymentdao)context.getBean("Paymentdao");
		Payment y=dao.find(39);
		
		System.out.println(y.getPaymentmethod());
	}

	@Ignore
	public void testupdatePayment() {
		Paymentdao dao=(Paymentdao)context.getBean("Paymentdao");
		Payment y=dao.find(39);
	   y.setPaymentmethod("card");
	   dao.updatePayment(y);
	   System.out.println(y.getPaymentmethod());
	}

	@Ignore
	public void testdeletePayment() {
		Paymentdao dao=(Paymentdao)context.getBean("Paymentdao");
		Payment y=dao.find(10);
		assert(dao.deletePayment(y));
	}

	@Test
	public void testGetAllPayments() {
		Paymentdao dao=(Paymentdao)context.getBean("Paymentdao");
		for(Payment y:dao.getAllPayments())
		{
			System.out.println(y.getPaymentmethod()+" "+y.getCartid());
		}
	}
*/
}
