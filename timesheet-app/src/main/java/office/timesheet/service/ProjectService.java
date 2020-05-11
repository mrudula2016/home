package office.timesheet.service;

import java.util.ArrayList;
import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;

import office.timesheet.dao.ProjectDao;
import office.timesheet.dao.UserRegistrationDao;
import office.timesheet.entity.GroupsEntity;
import office.timesheet.entity.ProjectAllocation;
import office.timesheet.entity.ProjectDetailsEntity;
import office.timesheet.entity.UsersEntity;

public class ProjectService {

	private ProjectDao projectDao;
	private UserRegistrationDao userRegistrationDao;

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Transactional
	public ArrayList<ProjectDetailsEntity> addProject(ProjectDetailsEntity projectDetails) {
		projectDao.addProject(projectDetails);
		return null;
	}

	@Transactional
	public ArrayList<ProjectDetailsEntity> fetchProject() {
		ArrayList<ProjectDetailsEntity> pd = projectDao.fetchProject();
		return pd;

	}

	@Transactional
	public void updateProject(ProjectDetailsEntity projectDetails) {
		projectDao.updateProject(projectDetails);
	}

	public UserRegistrationDao getUserRegistrationDao() {
		return userRegistrationDao;
	}

	public void setUserRegistrationDao(UserRegistrationDao userRegistrationDao) {
		this.userRegistrationDao = userRegistrationDao;
	}

	@Transactional
	public ArrayList<UsersEntity> getUserIdName() {
		ArrayList<UsersEntity> userNameID = userRegistrationDao.fetchUserIdName();
		return userNameID;
	}

	@Transactional
	public void addProjectAndUser(UsersEntity userName, ProjectDetailsEntity projectName, Date selectedStartDate,
			Date selectedEndDate) {
		projectDao.addProjectAndUser(userName, projectName, selectedStartDate, selectedEndDate);

	}

	@Transactional
	public ArrayList<ProjectAllocation> fetchUserAndProject(ArrayList<Integer> projects) {
		ArrayList<ProjectAllocation> usersAndProjects = projectDao.fetchUserAndProject(projects);
		return usersAndProjects;
	}

	@Transactional
	public ArrayList<String> testMethod(String query) {
		return projectDao.testMethod(query);
	}

}
