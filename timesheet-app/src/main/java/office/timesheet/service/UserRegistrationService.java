package office.timesheet.service;

import javax.transaction.Transactional;

import office.timesheet.dao.UserRegistrationDao;
import office.timesheet.entity.UsersEntity;

public class UserRegistrationService {
	private UserRegistrationDao userRegistrationDao;

	public UserRegistrationDao getuserRegistrationDao() {
		return userRegistrationDao;
	}

	public void setuserRegistrationDao(UserRegistrationDao userRegistrationDao) {
		this.userRegistrationDao = userRegistrationDao;
	}

	@Transactional
	public boolean userRegistrationDetails(UsersEntity usersEntity) {
		Boolean Result = userRegistrationDao.userRegistrationDetails(usersEntity);
		return Result;
	}

	@Transactional
	public boolean fetchDataService(String name, String password) {
		UsersEntity usersEntity = userRegistrationDao.fetchUserDetails(name);
		if (usersEntity != null && usersEntity.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public boolean checkUserExistence(String name) {
		UsersEntity usersEntity = userRegistrationDao.fetchUserDetails(name);
		if (usersEntity != null) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public boolean getNameData(String name) {
		UsersEntity u = userRegistrationDao.fetchUserDetails(name);
		if (u != null) {
			return true;
		} else {
			return false;
		}
	}
}
