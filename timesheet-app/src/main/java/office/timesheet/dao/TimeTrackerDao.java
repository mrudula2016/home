package office.timesheet.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import office.timesheet.entity.ProjectDetailsEntity;
import office.timesheet.entity.TimeTrackerEntity;

public class TimeTrackerDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public ArrayList<ProjectDetailsEntity> fetchProject() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("ProjectDetailsEntity.fetchProject");
		ArrayList<ProjectDetailsEntity> usersAndProjects = (ArrayList<ProjectDetailsEntity>) query.list();
		return usersAndProjects;

	}
public void timeTrackerDetails(TimeTrackerEntity timeTrackerDetails) {
	sessionFactory.getCurrentSession().save(timeTrackerDetails);
	}
}
