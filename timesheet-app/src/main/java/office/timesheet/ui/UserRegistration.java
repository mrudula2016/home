package office.timesheet.ui;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import office.timesheet.entity.UsersEntity;
import office.timesheet.service.UserRegistrationService;

@ManagedBean(name = "userregistration")
public class UserRegistration {

	@ManagedProperty(value = "#{userRegistrationService}")
	private UserRegistrationService userRegistrationService;

	private String userNameError = "No value Here";
	private UsersEntity usersEntity = new UsersEntity();

	public void setErrorMsg(boolean userExists) {
		if (userExists) {
			userNameError = "User name already exists";
		} else {
			userNameError = "";
		}
	}

	public void checkUser() {
		
		boolean dbResult = userRegistrationService.checkUserExistence(usersEntity.getName());
		setErrorMsg(dbResult);
	}

	public void userRegistrationDetails() throws IOException {
		Boolean result = userRegistrationService.userRegistrationDetails(usersEntity);
		if (!result) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User name already exists ", null));
		}

	}

	public void fetchUi() throws IOException {
		Boolean result = userRegistrationService.fetchDataService(usersEntity.getName(), usersEntity.getPassword());
		if (result) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/timesheet-app/success.jsf");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/timesheet-app/failure.jsf");
		}
	}

	public void getNameDataUi() {
		Boolean result = userRegistrationService.getNameData(usersEntity.getName());
	}

	public String getUserNameError() {
		return userNameError;
	}

	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}


	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}

	public UserRegistrationService getUserRegistrationService() {
		return userRegistrationService;
	}

	public void setUserRegistrationService(UserRegistrationService userRegistrationService) {
		this.userRegistrationService = userRegistrationService;
	}

}
