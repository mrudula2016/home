package office.timesheet.ui;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import office.timesheet.service.TimesheetService;
@ManagedBean(name="Clockify")
public class TimesheetUi {
	@ManagedProperty(value = "#{tss}")
	private TimesheetService timesheetservice;
	private TimesheetDto timesheetDto=new TimesheetDto();
	private List<TimesheetDto> dto;

	public List<TimesheetDto> getDto() {
		return dto;
	}

	public void setDto(List<TimesheetDto> dto) {
		this.dto = dto;
	}

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
	
	public void addDataUi() {
		timesheetservice.addDataService(timesheetDto);
	}
}
