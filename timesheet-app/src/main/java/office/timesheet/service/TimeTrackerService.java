package office.timesheet.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import office.timesheet.dao.TimeTrackerDao;
import office.timesheet.entity.ProjectDetailsEntity;
import office.timesheet.entity.TimeTrackerEntity;

public class TimeTrackerService {
private TimeTrackerDao timeTrackerDao;

public TimeTrackerDao getTimeTrackerDao() {
	return timeTrackerDao;
}

public void setTimeTrackerDao(TimeTrackerDao timeTrackerDao) {
	this.timeTrackerDao = timeTrackerDao;
}
	@Transactional
	public ArrayList<ProjectDetailsEntity> fetchProject() {
		
		ArrayList<ProjectDetailsEntity> projectsList=timeTrackerDao.fetchProject();
		return projectsList;
		
	}
	
	@Transactional
public void timeTrackerDetails(TimeTrackerEntity timeTrackerDetails) {
	
	timeTrackerDao.timeTrackerDetails(timeTrackerDetails);
	
		
	}

}
