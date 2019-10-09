package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.Cart;
import main.Product;

@Repository
@Transactional
public class Cartdaoimp implements Cartdao 
{
	@Autowired 
	SessionFactory sessionFactory;

	public boolean addCart(Cart t) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(t);
		return true;
	}

	
	public Cart find(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Cart t=session.get(Cart.class, id);
        return t;
	}

		

	public Cart updateCart(Cart t)
	{
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(t);
        return t;
	}

	public List<Cart> getAllCarts(String t) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select t from Cart t where t.cartid='"+t+"'");
		List<Cart> Cartlist=query.list();
		return Cartlist;
	}

	
	public int totalelements(String cartid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select t from Cart t where t.cartid='"+cartid+"'");
		int size=query.list().size();
		return size;
	}

	

	public boolean deletecart(Cart t) {
	
			Session session=sessionFactory.getCurrentSession();
			session.delete(t);
			return true;
		}

	
	}


	/*public Cart finditem(String cart) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select t from Cart t where t.cartid='"+cart+"'");
	List<Cart> Cartlist=query.list();
	return (Cart)Cartlist.get(0);
	}*/

	

	
