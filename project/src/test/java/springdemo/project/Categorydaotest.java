package springdemo.project;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Categorydao;
import jdk.nashorn.internal.ir.annotations.Ignore;
import main.Category;

public class Categorydaotest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		context=new AnnotationConfigApplicationContext(Springconfiguration.class);
	}
	@Test
	public void testaddCategory() {
		Categorydao dao=(Categorydao)context.getBean("Categorydao");
		Category q=new Category(); 	
		
		q.setCategoryName("tea");
		dao.addCategory(q);
	}
	/*@Test
	public void testFind() {
		Categorydao dao=(Categorydao)context.getBean("Categorydao");
		Category q=dao.find(1);
		dao.updateCategory(q);
		System.out.println(q.getCategoryName());
	}

	@Ignore
	public void testupdateCategory() {
		Categorydao dao=(Categorydao)context.getBean("Categorydao");
		Category q=dao.find(2);
		q.setCategoryName("idy");
		dao.updateCategory(q);
		System.out.println("cat name "+q.getCategoryName());
	}

	@Test
	public void testDeleteCategory() {
		Categorydao dao=(Categorydao)context.getBean("Categorydao");
		Category q=dao.find(2);
		assert(dao.deleteCategory(q));
		
	}

	@Test
	public void testGetAllCategorys() {
		Categorydao dao=(Categorydao)context.getBean("Categorydao");
		for(Category q:dao.getAllCategorys())
		{
			System.out.println(q.getCategoryName());
		}

	}
	*/
}
