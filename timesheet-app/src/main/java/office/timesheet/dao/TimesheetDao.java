package office.timesheet.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import office.timesheet.ui.TimesheetDto;

public class TimesheetDao {
	private SessionFactory sf;
	public boolean addDataDao(TimesheetDto timesheetDto) {
		TimesheetDto tsd =fetchDataDao(timesheetDto.getName());
		
		if (tsd !=null) {
			System.out.println("same name");
			return false;

		} else {
			sf.getCurrentSession().save(timesheetDto);
			return true;
		}
	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public TimesheetDto fetchDataDao(String entryname) {
		Session session = sf.getCurrentSession();
		Query qry = session.getNamedQuery("timesht.fetchUserDetails");
		qry.setParameter("uname", entryname);
		TimesheetDto tDto = (TimesheetDto) qry.uniqueResult();
		if (tDto != null) {
			System.out.println(tDto.getPassword());
			System.out.println(tDto.getName());
		}
		return tDto;
	}
}
