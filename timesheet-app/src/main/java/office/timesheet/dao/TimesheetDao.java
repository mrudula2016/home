package office.timesheet.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import office.timesheet.ui.TimesheetDto;

public class TimesheetDao {
	private SessionFactory sf;
	private TimesheetDto timesheetDto;

	public void addDataDao(TimesheetDto timesheetDao) {
		// timesheetDao.setId(timesheetDao.getId());
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

	public TimesheetDto fetchDataDao(String entryname, String password) {
		Session session = sf.getCurrentSession();
		Query qry = session.getNamedQuery("timesht.fetchUserDetails");
		qry.setParameter("uname", entryname);
		TimesheetDto tDto = (TimesheetDto) qry.uniqueResult();
		System.out.println(tDto.getPassword());
		System.out.println(tDto.getName());
		return tDto;
	}
}
