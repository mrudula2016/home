package office.timesheet.ui;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import office.timesheet.entity.UsersEntity;
import office.timesheet.service.TimesheetMainService;
import office.timesheet.service.UserRegistrationService;

@ManagedBean(name="timesheetMainManagedBean")
@SessionScoped
public class TimesheetMainManagedBean {
	
	@ManagedProperty(value = "#{timesheetMainService}")
	private TimesheetMainService timesheetMainService;
	
	String userName;
	UsersEntity userEntity;
	
	@PostConstruct
	public void init() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		userName = auth.getName(); // get logged in username
		userEntity =timesheetMainService.getUserName(userName);
		if(userEntity!=null) {
			System.out.println(userEntity.getName());
		}
		
		//userEntityID();
	}
	public int userEntityID() {
		int userEntityID =timesheetMainService.getUserID(userName);
		return userEntityID;
	}
	
	
	public TimesheetMainService getTimesheetMainService() {
		return timesheetMainService;
	}

	public void setTimesheetMainService(TimesheetMainService timesheetMainService) {
		this.timesheetMainService = timesheetMainService;
	}
}
