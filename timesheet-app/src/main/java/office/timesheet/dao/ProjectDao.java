package office.timesheet.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import office.timesheet.entity.GroupsEntity;
import office.timesheet.entity.ProjectAllocation;
import office.timesheet.entity.ProjectDetailsEntity;
import office.timesheet.entity.UsersEntity;

public class ProjectDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addProject(ProjectDetailsEntity projectDetails) {
		sessionFactory.getCurrentSession().save(projectDetails);
	}

	public ArrayList<ProjectDetailsEntity> fetchProject() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<ProjectDetailsEntity> projectdetails = (ArrayList<ProjectDetailsEntity>) session
				.createQuery("select per from ProjectDetailsEntity per").list();
		return projectdetails;

	}

	public void updateProject(ProjectDetailsEntity projectDetails) {
		sessionFactory.getCurrentSession().update(projectDetails);

	}

	public ArrayList<UsersEntity> fetchUsers() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<UsersEntity> projectdetails = (ArrayList<UsersEntity>) session
				.createQuery("select per from ProjectDetailsEntity per").list();
		return projectdetails;

	}

	public void addProjectAndUser(UsersEntity userName, ProjectDetailsEntity projectName,Date selectedStartDate,Date selectedEndDate) {

		ProjectAllocation employeEntity = new ProjectAllocation();
		employeEntity.setProjectDetailsEntity(projectName);
		employeEntity.setUserEntity(userName);
		employeEntity.setStartDate(selectedStartDate);
		employeEntity.setEndDate(selectedEndDate);
		sessionFactory.getCurrentSession().save(employeEntity);
	}
	
	public ArrayList<ProjectAllocation> fetchUserAndProject(ArrayList<Integer> projects) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("ProjectAllocation.fetchUserAndProject");
		query.setParameterList("projectIds", projects);
		ArrayList<ProjectAllocation> usersAndProjects = (ArrayList<ProjectAllocation>) query.list();
		return usersAndProjects;
	}
	public ArrayList<String> testMethod(String query) {
		Session session = sessionFactory.getCurrentSession();
		Query queryTest = session.getNamedQuery("usersEntity.testMethod");
		queryTest.setParameter("uname", "%"+query+"%");
		ArrayList<String> userPatterns = (ArrayList<String>) queryTest.list();
		return userPatterns;
	}
}
