package office.timesheet.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import office.timesheet.entity.GroupsEntity;
import office.timesheet.entity.UserGroupsRelationEntity;
import office.timesheet.entity.UsersEntity;
import office.timesheet.service.TeamsService;

@ManagedBean(name = "teamsManagedBean")
public class TeamsManagedBean {
	@ManagedProperty(value = "#{teamsService}")
	private TeamsService teamsService;

	private UsersEntity usersEntity = new UsersEntity();

	private ArrayList<GroupsEntity> groupsEntity;
	private GroupsEntity groupsEntity1 = new GroupsEntity();
	private ArrayList<UsersEntity> usersEntity1;
	private List<UsersEntity> filteredUsers;

	private int[] selectedGroupEntity = {2,3};

	@PostConstruct
	public void init() {
		fetchGroups();
		fetchMembers();
		//fetchGroupAssociatedData();
	}

	public TeamsService getTeamsService() {
		return teamsService;
	}

	public void setTeamsService(TeamsService teamsService) {
		this.teamsService = teamsService;
	}

	public ArrayList<GroupsEntity> getGroupsEntity() {
		return groupsEntity;
	}

	public void setGroupsEntity(ArrayList<GroupsEntity> groupsEntity) {
		this.groupsEntity = groupsEntity;
	}

	public void addGroup() {
		boolean status = teamsService.addGroup(groupsEntity1);
		if (status) {
			fetchGroups();
		}
	}

	public void addMember() {
		teamsService.addMember(usersEntity);
		fetchMembers();
	}

	public void removeGroup() {
		teamsService.removeGroup();
	}

	public void fetchGroups() {
		groupsEntity = teamsService.fetchGroups();

	}

	public void fetchMembers() {
		usersEntity1 = teamsService.fetchMembers();
	}

	public GroupsEntity getGroupsEntity1() {
		return groupsEntity1;
	}

	public void setGroupsEntity1(GroupsEntity groupsEntity1) {
		this.groupsEntity1 = groupsEntity1;
	}

	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}

	public ArrayList<UsersEntity> getUsersEntity1() {
		return usersEntity1;
	}

	public void setUsersEntity1(ArrayList<UsersEntity> usersEntity1) {
		this.usersEntity1 = usersEntity1;
	}

	public void onRowEdit(RowEditEvent event) {
		GroupsEntity gE = (GroupsEntity) event.getObject();
		teamsService.onRowEdit(gE);
		System.out.println(gE);
	}

	public void deleteAction(GroupsEntity ee) {
		// groupsEntity.remove(ee);

		teamsService.deleteAction(ee);
		fetchGroups();

	}

	public int[] getSelectedGroupEntity() {
		return selectedGroupEntity;
	}

	public void setSelectedGroupEntity(int[] selectedGroupEntity) {
		this.selectedGroupEntity = selectedGroupEntity;
	}

	public void onMemberEdit(RowEditEvent event) {
		UsersEntity gE = (UsersEntity) event.getObject();
		int k = gE.getUserId();
		for (int i = 0; i < gE.getSelectedGroupEntity().length; i++) {
			teamsService.updateGroup(k, gE.getSelectedGroupEntity()[i]);
		}
	}

	private int getInteger(String string) {
		try {
			return Integer.valueOf(string);
		} catch (NumberFormatException ex) {
			return 0;
		}
	}

	public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
		String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
		if (filterText == null || filterText.equals("")) {
			return true;
		}
		int filterInt = getInteger(filterText);

		UsersEntity car = (UsersEntity) value;
		return  car.getName().toLowerCase().contains(filterText)
				|| car.getEmail().toLowerCase().contains(filterText) || car.getHourlylRate() < filterInt;
	}

	public List<UsersEntity> getFilteredUsers() {
		return filteredUsers;
	}

	public void setFilteredUsers(List<UsersEntity> filteredUsers) {
		this.filteredUsers = filteredUsers;
	}
	public void fetchGroupAssociatedData() {
		ArrayList<UserGroupsRelationEntity> aa=new ArrayList<UserGroupsRelationEntity>();
		aa=teamsService.fetchGroupAssociatedData();
	}
}
