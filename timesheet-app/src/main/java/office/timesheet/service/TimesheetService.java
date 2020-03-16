package office.timesheet.service;

import javax.transaction.Transactional;

import office.timesheet.dao.TimesheetDao;
import office.timesheet.ui.TimesheetDto;

public class TimesheetService {
	private TimesheetDao timesheetDao;
	
	public TimesheetDao getTimesheetDao() {
		return timesheetDao;
	}

	public void setTimesheetDao(TimesheetDao timesheetDao) {
		this.timesheetDao = timesheetDao;
	}

	@Transactional
	public boolean addDataService(TimesheetDto dtoService) {
		Boolean Result=	timesheetDao.addDataDao(dtoService);
		return Result;
	}

	@Transactional
	public boolean fetchDataService(String name, String password) {
		TimesheetDto tDto = timesheetDao.fetchDataDao(name);
		if (tDto !=null && tDto.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean getNameData(String name)
	{
		TimesheetDto tDto = timesheetDao.fetchDataDao(name);
		if (tDto !=null) {
			return true;
		} else {
			return false;
		}
	}
}
