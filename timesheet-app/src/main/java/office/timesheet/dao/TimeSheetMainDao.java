package office.timesheet.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import office.timesheet.entity.UsersEntity;

public class TimeSheetMainDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public UsersEntity getUsername(String userName) {

		Session session = sessionFactory.getCurrentSession();
		Query qry = session.getNamedQuery("usersEntity.getUsername");
		qry.setParameter("uname", userName);
		UsersEntity users = (UsersEntity) qry.uniqueResult();
		return users;
	}

	public int getUserID(String userName) {

		Session session = sessionFactory.getCurrentSession();
		Query qry = session.getNamedQuery("usersEntity.getUserID");
		qry.setParameter("uname", userName);
		int userEntityID = (int) qry.uniqueResult();
		return userEntityID;
	}
}
