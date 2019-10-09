package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.Category;
import main.Product;

@Repository
@Transactional

public class Categorydaoimp implements Categorydao
 {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category q) {
		Session session=sessionFactory.getCurrentSession();
		session.save(q);
		return true;
		
	}

	public Category find(int id) {
		Session session=sessionFactory.getCurrentSession();
		Category q=session.get(Category.class, id);

		
		
		return q;
	}


		

	public  Category updateCategory(Category q) 
	{
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(q);

		return q;
	}

	public boolean deleteCategory(Category q) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(q);

		return true;
	}

	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category q");
		List<Category> categorylist=query.list();
		return categorylist;
	}

	
}