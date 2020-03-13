package office.timesheet.service;

import javax.transaction.Transactional;

import office.timesheet.dao.TimesheetDao;
import office.timesheet.ui.TimesheetDto;

public class TimesheetService {
	private TimesheetDao timesheetDao;
	private TimesheetDto dto;

	public TimesheetDao getTimesheetDao() {
		return timesheetDao;
	}

	public void setTimesheetDao(TimesheetDao timesheetDao) {
		this.timesheetDao = timesheetDao;
	}

	@Transactional
	public void addDataService(TimesheetDto dtoService) {
		timesheetDao.addDataDao(dtoService);
	}

	@Transactional
	public boolean fetchDataService(String name, String password) {
		TimesheetDto tDto = timesheetDao.fetchDataDao(name, password);
		if (tDto.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
}
