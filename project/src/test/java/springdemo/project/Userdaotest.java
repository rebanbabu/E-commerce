package springdemo.project;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Userdao;
import jdk.nashorn.internal.ir.annotations.Ignore;
import main.User;

public class Userdaotest {
	public static ApplicationContext context;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new AnnotationConfigApplicationContext(Springconfiguration.class);
	}

	@Test
	public void testaddUser() {
		Userdao dao=(Userdao)context.getBean("userdao");
		User r=new User(); 	
		r.setemail("trebanbabu14@gmail.com");
		r.setUserName("reban");
		r.setPassword("123");
		r.setConfirmpassword("123");
		r.setUser_role("ROLE_USER");
		dao.addUser(r);
	}

	/*@Ignore
	public void testDeleteUser() {
		Userdao dao=(Userdao)context.getBean("Userdao");
		User r=dao.find("trebanbabu14@gmail.com");
		assert(dao.deleteUser(r));
	}

	@Test
	public void testFind() {
		Userdao dao=(Userdao)context.getBean("Userdao");
		User r=dao.find("treban272gmail.com");
		dao.updateUser(r);
	
	}

	@Test
	public void testUpdateUser() {
		Userdao dao=(Userdao)context.getBean("Userdao");
		User r=dao.find("trebanbabu14@gmail.com");
		r.setUserName("sanjay");
		dao.updateUser(r);
	
	}

	@Test
	public void testGetAllUsers() {
		Userdao dao=(Userdao)context.getBean("Userdao");
		for(User r:dao.getAllUsers())
		{
			System.out.println(r.getUserName()+" "+r.getPassword());
		}
	}
*/
}
