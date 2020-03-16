package office.timesheet.ui;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import office.timesheet.service.TimesheetService;

@ManagedBean(name = "Clockify")
public class TimesheetUi {
	@ManagedProperty(value = "#{tss}")
	private TimesheetService timesheetservice;
	private TimesheetDto timesheetDto = new TimesheetDto();

	public TimesheetDto getTimesheetDto() {
		return timesheetDto;
	}

	public void setTimesheetDto(TimesheetDto timesheetDto) {
		this.timesheetDto = timesheetDto;
	}

	public TimesheetService getTimesheetservice() {
		return timesheetservice;
	}

	public void setTimesheetservice(TimesheetService timesheetservice) {
		this.timesheetservice = timesheetservice;
	}

	public void addDataUi() throws IOException {
		Boolean result = timesheetservice.addDataService(timesheetDto);
		if (!result) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User name already exists ", null));
		}

	}

	public void fetchUi() throws IOException {
		Boolean result = timesheetservice.fetchDataService(timesheetDto.getName(), timesheetDto.getPassword());
		if (result) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/timesheet-app/success.jsf");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/timesheet-app/failure.jsf");
		}
	}

	public void getNameDataUi() {
		Boolean result = timesheetservice.getNameData(timesheetDto.getName());
	}
}
