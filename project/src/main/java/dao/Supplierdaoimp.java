package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.Product;
import main.Supplier;
@Repository
@Transactional
public class Supplierdaoimp implements Supplierdao
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier w) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(w);
		return true;
	}

	public Supplier find(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Supplier w=session.get(Supplier.class, id);

		
		
		return w;
		
		
	}

	public Supplier updateSupplier(Supplier w) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(w);

		return w;
	}

	public boolean deleteSupplier(Supplier w) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(w);

		return true;
	}

	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Supplier w");
		List<Supplier> Supplierlist=query.list();
		return Supplierlist;
	}

}
