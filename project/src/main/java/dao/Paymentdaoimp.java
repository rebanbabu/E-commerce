package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.Category;
import main.Payment;
import main.Payment;
@Repository
@Transactional
public class Paymentdaoimp implements Paymentdao {
	@Autowired
	SessionFactory sessionFactory;
	public boolean addPayment(Payment y) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(y);
		return true;
	}

	public Payment find(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Payment y=session.get(Payment.class, id);

		
		
		return y;
		
		
		
	}

	public Payment updatePayment(Payment y) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(y);

		return y;
	}

	public boolean deletePayment(Payment y) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.delete(y);

		return true;
	}

	public List<Payment> getAllPayments(String cartid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Payment y where y.cartid='"+cartid+"'");
		List<Payment> Paymentlist=query.list();
		return Paymentlist;
		
	}

}
