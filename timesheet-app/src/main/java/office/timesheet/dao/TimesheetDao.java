package office.timesheet.dao;

import org.hibernate.SessionFactory;

import office.timesheet.ui.TimesheetDto;

public class TimesheetDao {
	private SessionFactory sf;

public void addDataDao(TimesheetDto timesheetDao)
{
	timesheetDao.setName(timesheetDao.getName());
	timesheetDao.setEmailId(timesheetDao.getEmailId());
	timesheetDao.setPassword(timesheetDao.getPassword());
}

public SessionFactory getSf() {
	return sf;
}

public void setSf(SessionFactory sf) {
	this.sf = sf;
}
}
