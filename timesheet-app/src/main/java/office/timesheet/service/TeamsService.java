package office.timesheet.service;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.transaction.Transactional;

import org.primefaces.event.RowEditEvent;

import office.timesheet.dao.TeamsDao;
import office.timesheet.entity.GroupsEntity;
import office.timesheet.entity.UserGroupsRelationEntity;
import office.timesheet.entity.UsersEntity;

public class TeamsService {
	private TeamsDao teamsDao;
	

	public TeamsDao getTeamsDao() {
		return teamsDao;
	}

	public void setTeamsDao(TeamsDao teamsDao) {
		this.teamsDao = teamsDao;
	}

	@Transactional
	public boolean addGroup(GroupsEntity groupsEntity1) {
		boolean status = teamsDao.addGroup(groupsEntity1);
		return status;

	}

	@Transactional
	public void addMember(UsersEntity usersEntity) {

		teamsDao.addMember(usersEntity);

	}

	@Transactional
	public void removeGroup() {
		teamsDao.removeGroup();
	}

	@Transactional
	public void updateGroup(int userId, int groupId) {
		teamsDao.updateGroup(userId, groupId);

	}

	@Transactional
	public ArrayList<GroupsEntity> fetchGroups() {
		ArrayList<GroupsEntity> gp = teamsDao.fetchGroups();
		return gp;

	}

	@Transactional
	public ArrayList<UsersEntity> fetchMembers() {
		ArrayList<UsersEntity> membersInfo = teamsDao.fetchMembers();
		return membersInfo;

	}

	@Transactional
	public void onRowEdit(GroupsEntity groupsEntity) {
		teamsDao.onRowEdit(groupsEntity);
	}

	@Transactional
	public void deleteAction(GroupsEntity ee) {
		teamsDao.deleteAction(ee);
	}

	@Transactional
	public GroupsEntity getGroudEntityWithID(int i) {
		return teamsDao.getGroudEntityWithID(i);
	}

	@Transactional
	public void groupID(UserGroupsRelationEntity ugre) {
		teamsDao.groupID(ugre);
	}
	
	//@Transactional
//	public ArrayList<GroupsEntity> getGroupID(int[] selectedGroupEntity)
//	{
//		ArrayList<GroupsEntity> group=teamsDao.getGroupID(selectedGroupEntity);
//		return group;
//	}
}
