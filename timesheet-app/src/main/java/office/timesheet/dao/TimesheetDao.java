package office.timesheet.dao;

import org.hibernate.SessionFactory;

import office.timesheet.ui.TimesheetDto;

public class TimesheetDao {
	private SessionFactory sf;

	public void addDataDao(TimesheetDto timesheetDao) {
		timesheetDao.setId(timesheetDao.getId());
		timesheetDao.setName(timesheetDao.getName());
		timesheetDao.setEmailId(timesheetDao.getEmailId());
		timesheetDao.setPassword(timesheetDao.getPassword());
		sf.getCurrentSession().save(timesheetDao);
	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
}
