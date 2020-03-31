package office.timesheet.ui;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import office.timesheet.entity.Groups;
import office.timesheet.service.TeamGroupService;

@ManagedBean(name = "groupManagedBean")
public class GroupManagedBean {
	@ManagedProperty(value = "#{teamgroupsServicemanagedbean}")
	private TeamGroupService teamGroupService;
	private ArrayList<Groups> groups;

	@PostConstruct
	public void init() {
		groupsData();
	}

	public TeamGroupService getTeamGroupService() {
		return teamGroupService;
	}

	public void setTeamGroupService(TeamGroupService teamGroupService) {
		this.teamGroupService = teamGroupService;
	}

	public ArrayList<Groups> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<Groups> groups) {
		this.groups = groups;
	}

	public void groupsData() {
		groups = teamGroupService.groupsData();

	}
}
