package office.timesheet.service;

import javax.transaction.Transactional;

import office.timesheet.dao.TimeSheetMainDao;
import office.timesheet.entity.UsersEntity;

public class TimesheetMainService {
	private TimeSheetMainDao timeSheetMainDao;
	
	
	@Transactional
	public UsersEntity getUserName(String userName) {
		UsersEntity userNameee=timeSheetMainDao.getUsername(userName);
		return userNameee;
	}
	@Transactional
	public int getUserID(String userName) {
		int userEntityID =timeSheetMainDao.getUserID(userName);
		return userEntityID;
	}

	public TimeSheetMainDao getTimeSheetMainDao() {
		return timeSheetMainDao;
	}

	public void setTimeSheetMainDao(TimeSheetMainDao timeSheetMainDao) {
		this.timeSheetMainDao = timeSheetMainDao;
	}
}
