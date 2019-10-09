package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.Product;
@Repository
@Transactional
public class Productdaoimp implements Productdao {
	@Autowired
	SessionFactory sessionFactory;

public boolean addProduct(Product p) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(p);
		return true;
	}

	public Product find(int id) {
		// TODO Auto-generated method stub
		
		
		Session session=sessionFactory.getCurrentSession();
		Product p=session.get(Product.class, id);

		
		
		return p;
	}

	public Product updateProduct(Product p) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(p);

		return p;
	}

	public boolean deleteProduct(Product p) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(p);

		return true;
	}

	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product p");
		List<Product> productlist=query.list();
		return productlist;
	}
}