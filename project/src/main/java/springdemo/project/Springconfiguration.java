package springdemo.project;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dao.Cartdao;
import dao.Cartdaoimp;
import dao.Categorydao;
import dao.Categorydaoimp;
import dao.Paymentdao;
import dao.Paymentdaoimp;
import dao.Productdao;
import dao.Productdaoimp;
import dao.Supplierdao;
import dao.Supplierdaoimp;
import dao.Userdao;
import dao.Userdaoimp;
import main.Cart;
import main.Category;
import main.Payment;
import main.Product;
import main.Supplier;
import main.User;

@Configuration
@EnableTransactionManagement
public class Springconfiguration
{
	
	@Bean( "datasource")
	 public DataSource getH2DataSource()
     {
     	System.out.println("Starting of the method getH2DataSource");
     	DriverManagerDataSource dataSource = new DriverManagerDataSource();
     	dataSource.setDriverClassName("org.h2.Driver");
     	dataSource.setUrl(" jdbc:h2:tcp://localhost/~/test");
     	dataSource.setUsername("sa");
     	dataSource.setPassword("");
     	System.out.println("Data source creation");
     	return dataSource;
     } 
	@Bean(name="SessionFactory")
	public SessionFactory getSessionFactory()
     {  
		
	     	System.out.println("------Hibernate Properties----");
	     	Properties prop = new Properties();
	     	prop.setProperty("hibernate.hbm2ddl.auto", "update");
	     	prop.put("hibernate.show_sql", "true");
	     	prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	     	System.out.println("-----Hibernate properties created----");
	     	
	     	System.out.println("----Local session factory builder object creation----");
	     	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
	     	sessionBuilder.addProperties(prop);
	     	System.out.println("-----Factory builder object created----");
	     	sessionBuilder.addAnnotatedClass(Product.class);
	     	sessionBuilder.addAnnotatedClass(Category.class);
			sessionBuilder.addAnnotatedClass(Supplier.class);
            
			sessionBuilder.addAnnotatedClass(User.class);
			sessionBuilder.addAnnotatedClass(Cart.class);
			sessionBuilder.addAnnotatedClass(Payment.class);
			
	     	System.out.println("Session factory object creation");
	     	SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
	     	System.out.println("Session factory object created");
	     	return sessionFactory;
     }
	@Bean("txManager")
	     	public HibernateTransactionManager getTransactionManager()
	  	  {
	  		  HibernateTransactionManager manager=new HibernateTransactionManager(getSessionFactory());
	  	    return manager;
	  	  }
	     	@Bean ("productdao")
	     	public Productdao getProductdao()
	  	  {
	  		  Productdaoimp a=new Productdaoimp();
	  		  return a;
	  	  }
	     	@Bean ("categorydao")
	     	public Categorydao getCategorydao()
		  	  {
		  		  Categorydaoimp b=new Categorydaoimp();
		  		  return b;
		  	  }
	     	@Bean ("supplierdao")
	     	public Supplierdao getSupplierdaoimp()
	     	{
	     		
	     	Supplierdaoimp c=new Supplierdaoimp();
	     	return c;
	     }
	     	@Bean ("userdao")
	     	public Userdao getUserdaoimp()
	     	{
	     		
	     	Userdaoimp d=new Userdaoimp();
	     	return d;
	     }
	     	@Bean ("cartdao")
	     	public Cartdao getCartdaoimp()
	     	{
	     		
	     	Cartdaoimp e=new Cartdaoimp();
	     	return e;
	     }
	     	@Bean ("paymentdao")
	     	public Paymentdao getpaymentdaoimp()
	     	{
	     		Paymentdaoimp f=new Paymentdaoimp();
	     		return f;
	     	}
	     	
}
