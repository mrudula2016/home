package office.timesheet.service;

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
	
	public void addDataService(TimesheetDto dtoService )
	{
		
	}

}
