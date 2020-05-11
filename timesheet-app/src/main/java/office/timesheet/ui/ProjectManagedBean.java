package office.timesheet.ui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import office.timesheet.entity.ProjectAllocation;
import office.timesheet.entity.ProjectDetailsEntity;
import office.timesheet.entity.UsersEntity;
import office.timesheet.service.ProjectService;

@ManagedBean(name = "projectManagedBean")
public class ProjectManagedBean {

	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;

	private ProjectDetailsEntity projectDetailsEntity = new ProjectDetailsEntity();
	private ArrayList<ProjectDetailsEntity> projectDetailsEntityList;

	private ArrayList<ProjectDetailsEntity> projectDetailsSeclection;
	private ArrayList<UsersEntity> usersEntityList;
	private ArrayList<ProjectAllocation> usersAndProjectsSeclections;

	private String selectedUser;
	private Date selectedStartDate;
	private Date selectedEndDate;

	@ManagedProperty(value = "#{timesheetMainManagedBean}")
	private TimesheetMainManagedBean timesheetMainManagedBean;

	@PostConstruct
	public void init() {
		fetchProject();
		fetchUsers();

	}

	public List<String> allUsersComparision(String query) {
//		String convertedQuery=query.toLowerCase();
//		List<String> results = new ArrayList<>();
//		for (UsersEntity uu : usersEntityList) {
//			String convertedName=uu.getName().toLowerCase();
//			if (convertedName != null && convertedName.contains(convertedQuery)) {
//				results.add(uu.getName());
//			}
		List<String> results = new ArrayList<>();
		for (UsersEntity uu : usersEntityList) {
			if (uu.getName() != null && uu.getName().contains(query)) {
				results.add(uu.getName());
			}
		}
		return results;
	}

	public void fetchUserAndProject() {
		ArrayList<Integer> selectedIds = new ArrayList<Integer>();
		for (ProjectDetailsEntity pa : projectDetailsSeclection) {
			selectedIds.add(pa.getId());
		}
		if (!selectedIds.isEmpty()) {
			usersAndProjectsSeclections = projectService.fetchUserAndProject(selectedIds);
		}
	}

	public void addProject() {

		if (projectDetailsEntity.getStartDate().before(projectDetailsEntity.getEndDate())) {
			projectDetailsEntity.setUserEntity(timesheetMainManagedBean.userEntity);
			projectService.addProject(projectDetailsEntity);
			fetchProject();

		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Invalid Date selection Start date is Greater Than End Date", null));
		}
	}

	public void fetchProject() {
		projectDetailsEntityList = projectService.fetchProject();
	}

	public void addProjectAndUser() {
		// selectedEndDate<selectedStartDate;
		if (selectedStartDate.before(selectedEndDate)) {
			for (ProjectDetailsEntity projectDetailsEntity : projectDetailsSeclection) {
				for (UsersEntity user : usersEntityList) {
					if (user.getName().equals(selectedUser)) {
						projectService.addProjectAndUser(user, projectDetailsEntity, selectedStartDate,
								selectedEndDate);
						break;
					}
				}

			}
			fetchUserAndProject();
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Date selection ", null));
		}
	}

	public void onRowEdit(RowEditEvent event) {
		ProjectDetailsEntity projectDetailsEntity = (ProjectDetailsEntity) event.getObject();
		projectService.updateProject(projectDetailsEntity);

	}

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	}

	public void click() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.update("form:display");
		requestContext.execute("PF('dlg').show()");
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public ProjectDetailsEntity getProjectDetailsEntity() {
		return projectDetailsEntity;
	}

	public void setProjectDetailsEntity(ProjectDetailsEntity projectDetailsEntity) {
		this.projectDetailsEntity = projectDetailsEntity;
	}

	public ArrayList<ProjectDetailsEntity> getProjectDetailsEntityList() {
		return projectDetailsEntityList;
	}

	public void setProjectDetailsEntityList(ArrayList<ProjectDetailsEntity> projectDetailsEntityList) {
		this.projectDetailsEntityList = projectDetailsEntityList;
	}

	public ArrayList<ProjectDetailsEntity> getProjectDetailsSeclection() {
		return projectDetailsSeclection;
	}

	public void setProjectDetailsSeclection(ArrayList<ProjectDetailsEntity> projectDetailsSeclection) {
		this.projectDetailsSeclection = projectDetailsSeclection;
	}

	public void fetchUsers() {
		usersEntityList = projectService.getUserIdName();

	}

	public ArrayList<UsersEntity> getUsersEntityList() {
		return usersEntityList;
	}

	public void setUsersEntityList(ArrayList<UsersEntity> usersEntityList) {
		this.usersEntityList = usersEntityList;
	}

	public String getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(String selectedUser) {
		this.selectedUser = selectedUser;
	}

	public ArrayList<ProjectAllocation> getUsersAndProjectsSeclections() {
		return usersAndProjectsSeclections;
	}

	public void setUsersAndProjectsSeclections(ArrayList<ProjectAllocation> usersAndProjectsSeclections) {
		this.usersAndProjectsSeclections = usersAndProjectsSeclections;
	}

	public Date getSelectedStartDate() {
		return selectedStartDate;
	}

	public void setSelectedStartDate(Date selectedStartDate) {
		this.selectedStartDate = selectedStartDate;
	}

	public Date getSelectedEndDate() {
		return selectedEndDate;
	}

	public void setSelectedEndDate(Date selectedEndDate) {
		this.selectedEndDate = selectedEndDate;
	}

	public TimesheetMainManagedBean getTimesheetMainManagedBean() {
		return timesheetMainManagedBean;
	}

	public void setTimesheetMainManagedBean(TimesheetMainManagedBean timesheetMainManagedBean) {
		this.timesheetMainManagedBean = timesheetMainManagedBean;
	}
	
	public ArrayList<String> testMethod(String query) {
		return projectService.testMethod(query);
	}

}