package office.timesheet.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import office.timesheet.entity.UsersEntity;


public class UserRegistrationDao {
	private SessionFactory sessionFactory;

	public boolean userRegistrationDetails(UsersEntity userEntity) {
		UsersEntity ut = fetchUserDetails(userEntity.getName());

		if (ut != null) {
			System.out.println("same name");
			return false;

		} else {
			sessionFactory.getCurrentSession().save(userEntity);
			return true;
		}
	}


	public UsersEntity fetchUserDetails(String entryname) {
		Session session = sessionFactory.getCurrentSession();
		Query qry = session.getNamedQuery("usersEntity.fetchUserDetails");
		qry.setParameter("uname", entryname);
		UsersEntity users = (UsersEntity) qry.uniqueResult();
		return users;

	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
