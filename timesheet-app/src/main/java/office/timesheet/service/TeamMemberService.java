package office.timesheet.service;

import java.util.ArrayList;
import java.util.Set;

import javax.transaction.Transactional;

import com.mysql.fabric.xmlrpc.base.Member;

import office.timesheet.dao.TeamMemberDao;
import office.timesheet.entity.Members;
import office.timesheet.ui.TimesheetDto;

public class TeamMemberService {
	private TeamMemberDao teamMemberDao;
	private Member member;

	public TeamMemberDao getTeamMemberDao() {
		return teamMemberDao;
	}

	public void setTeamMemberDao(TeamMemberDao teamMemberDao) {
		this.teamMemberDao = teamMemberDao;
	}

	@Transactional
	public ArrayList<TimesheetDto> membersInfo() {
		ArrayList<TimesheetDto> ss = teamMemberDao.membersInfo();
		return ss;
	}
	@Transactional
	public ArrayList<Members> teamMembersInfo() {
		ArrayList<Members> ssmembers=teamMemberDao.teamMembersInfo();
		return ssmembers;
	}
	@Transactional
	public String getEmail(String email)
	{
		return teamMemberDao.getEmail(email);
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
