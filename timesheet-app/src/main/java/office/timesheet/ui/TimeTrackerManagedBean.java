package office.timesheet.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import office.timesheet.dto.TimesheetLabelDTO;
import office.timesheet.entity.ProjectDetailsEntity;
import office.timesheet.entity.TimeTrackerEntity;
import office.timesheet.service.TimeTrackerService;

@ManagedBean(name = "timeTrackerManagedBean")
public class TimeTrackerManagedBean {

	@ManagedProperty(value = "#{timeTrackerService}")
	private TimeTrackerService timeTrackerService;

	private ProjectDetailsEntity projectDetailsEntity = new ProjectDetailsEntity();
	private ArrayList<String> selectedProjects;
	private ArrayList<ProjectDetailsEntity> projectsList;
	private Date selectedDate;
	private TimeTrackerEntity timeTrackerEntity = new TimeTrackerEntity();
	private TimesheetLabelDTO timesheetLabelDTO = new TimesheetLabelDTO();

	@ManagedProperty(value = "#{timesheetMainManagedBean}")
	private TimesheetMainManagedBean timesheetMainManagedBean;

	@PostConstruct
	public void init() {
		fetchProject();
	}

	public void fetchProject() {
		projectsList = timeTrackerService.fetchProject();
	}

	public void project() {
		ArrayList<String> selectedProject = selectedProjects;
	}

	public void timeTrackerDetails() {
		timeTrackerService.timeTrackerDetails(timeTrackerEntity);
	}

	public ProjectDetailsEntity getProjectDetailsEntity() {
		return projectDetailsEntity;
	}

	public void setProjectDetailsEntity(ProjectDetailsEntity projectDetailsEntity) {
		this.projectDetailsEntity = projectDetailsEntity;
	}

	public ArrayList<String> getSelectedProjects() {
		return selectedProjects;
	}

	public void setSelectedProjects(ArrayList<String> selectedProjects) {
		this.selectedProjects = selectedProjects;
	}

	public TimeTrackerEntity getTimeTrackerEntity() {
		return timeTrackerEntity;
	}

	public void setTimeTrackerEntity(TimeTrackerEntity timeTrackerEntity) {
		this.timeTrackerEntity = timeTrackerEntity;
	}

	public TimeTrackerService getTimeTrackerService() {
		return timeTrackerService;
	}

	public void setTimeTrackerService(TimeTrackerService timeTrackerService) {
		this.timeTrackerService = timeTrackerService;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public ArrayList<ProjectDetailsEntity> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(ArrayList<ProjectDetailsEntity> projectsList) {
		this.projectsList = projectsList;
	}

	public TimesheetMainManagedBean getTimesheetMainManagedBean() {
		return timesheetMainManagedBean;
	}

	public void setTimesheetMainManagedBean(TimesheetMainManagedBean timesheetMainManagedBean) {
		this.timesheetMainManagedBean = timesheetMainManagedBean;
	}

	public TimesheetLabelDTO getTimesheetLabelDTO() {
		return timesheetLabelDTO;
	}

	public void setTimesheetLabelDTO(TimesheetLabelDTO timesheetLabelDTO) {
		this.timesheetLabelDTO = timesheetLabelDTO;
	}

	public void populateWeekLebels(SelectEvent ae) {

		Date date = (Date) ae.getObject();
		int weekNo = convertDateToWeekNumber(date);
		System.out.println(weekNo);
		String dayName = convertDateToDayName(date);
		System.out.println(dayName);
		findingDayWeekForLabel(date);

	}

	public int convertDateToWeekNumber(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int weekNumber = cal.get(Calendar.DAY_OF_WEEK);
		return weekNumber;
	}

	public String convertDateToDayName(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("EEEE");
		String dayName = format.format(date);
		return dayName;
	}

	public String convertDateToMonthDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MMM");
		String dayName = format.format(date);
		return dayName;
	}

	public void findingDayWeekForLabel(Date date) {
		int weekNo = convertDateToWeekNumber(date);
		dateLabelForwardLoop(weekNo,date);
		System.out.println("----");
		dateLabelBackwardLoop(weekNo, date);
	}

	public void dateLabelForwardLoop(int weekNumber,Date date) {
		for (int i = 7; i > weekNumber; --i) {
			System.out.println(i);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, i - weekNumber);
			Date decementDate = cal.getTime();
			String s = convertDateToDayName(decementDate);
			System.out.println(s);
			if (s != null && s.equalsIgnoreCase("Monday")) {
				timesheetLabelDTO.setMonday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Tuesday")) {
				timesheetLabelDTO.setTuesday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Wednesday")) {
				timesheetLabelDTO.setWednesday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Thursday")) {
				timesheetLabelDTO.setThursday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Friday")) {
				timesheetLabelDTO.setFriday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Saturday")) {
				timesheetLabelDTO.setSaturday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Sunday")) {
				timesheetLabelDTO.setSunday(convertDateToMonthDate(decementDate));
			}

		}
	}

	public void dateLabelBackwardLoop(int weekNumber, Date date) {
		for (int i = weekNumber; i >= 1; i--) {
			System.out.println(i);

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, i - weekNumber);
			Date decementDate = cal.getTime();
			String s = convertDateToDayName(decementDate);
			System.out.println(s);
			if (s != null && s.equalsIgnoreCase("Monday")) {
				timesheetLabelDTO.setMonday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Tuesday")) {
				timesheetLabelDTO.setTuesday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Wednesday")) {
				timesheetLabelDTO.setWednesday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Thursday")) {
				timesheetLabelDTO.setThursday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Friday")) {
				timesheetLabelDTO.setFriday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Saturday")) {
				timesheetLabelDTO.setSaturday(convertDateToMonthDate(decementDate));
			} else if (s != null && s.equalsIgnoreCase("Sunday")) {
				timesheetLabelDTO.setSunday(convertDateToMonthDate(decementDate));
			}

		}
	}

}
