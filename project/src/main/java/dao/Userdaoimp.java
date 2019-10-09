package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.User;

@Repository
@Transactional
public class Userdaoimp implements Userdao
{
	@Autowired 
	SessionFactory sessionFactory;
	public boolean addUser(User r) {
				
		
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(r);
		return true;
	}

	public boolean deleteUser(User r) {
		
		Session session=sessionFactory.getCurrentSession();
		session.delete(r);

		return true;	
	  	
	
	}

	public User find(String email) {

		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User r where r.email='"+email+"'");
		List<User> Userlist=query.list();
		
		
		return Userlist.get(0);
	}

	public User updateUser(User r) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(r);

		return r;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User r");
		List<User> Userlist=query.list();
		return Userlist;
	  	
	}
	

}
