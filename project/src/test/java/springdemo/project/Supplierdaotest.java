package springdemo.project;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Supplierdao;
import jdk.nashorn.internal.ir.annotations.Ignore;
import main.Supplier;

public class Supplierdaotest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext(Springconfiguration.class);
	}

	@Test
	public void testaddSupplier()
	{
		Supplierdao dao=(Supplierdao)context.getBean("supplierdao");
		Supplier w=new Supplier(); 	
		w.setSupplieraddress("chennai");
		w.setSupplierName("tea");
		dao.addSupplier(w);
	}

/*	@Test
	public void testfind() {
		Supplierdao dao=(Supplierdao)context.getBean("Supplierdao");
		Supplier w=dao.find(3);
		dao.updateSupplier(w);
		System.out.println(w.getSupplierName());
	}

	@Test
	public void testUpdateSupplier() {
		Supplierdao dao=(Supplierdao)context.getBean("Supplierdao");
		Supplier w=dao.find(3);
		w.setSupplierName("coldtea");
		dao.updateSupplier(w);
		System.out.println(w.getSupplierName());
	}

	@Ignore
	public void testDeleteSupplier() {
		Supplierdao dao=(Supplierdao)context.getBean("Supplierdao");
		Supplier w=dao.find(3);
		assert(dao.deleteSupplier(w));
	}

	@Test
	public void testgetAllSuppliers() {
		Supplierdao dao=(Supplierdao)context.getBean("Supplierdao");
		for(Supplier w:dao.getAllSuppliers())
		{
			System.out.println(w.getSupplierName()+" "+w.getSupplieraddress());
		}
	}
*/
}
