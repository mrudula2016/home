package office.timesheet.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import office.timesheet.dao.TeamGroupDao;
import office.timesheet.entity.Groups;

public class TeamGroupService {
	private Groups groups;
	private TeamGroupDao teamGroupDao;

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	public TeamGroupDao getTeamGroupDao() {
		return teamGroupDao;
	}

	public void setTeamGroupDao(TeamGroupDao teamGroupDao) {
		this.teamGroupDao = teamGroupDao;
	}

	@Transactional
	public ArrayList<Groups> groupsData() {
		ArrayList<Groups> gp = teamGroupDao.groupsData();
		return gp;

	}

}
