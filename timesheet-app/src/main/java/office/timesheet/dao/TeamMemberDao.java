package office.timesheet.dao;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import antlr.collections.List;
import office.timesheet.entity.Members;
import office.timesheet.ui.TimesheetDto;

public class TeamMemberDao {
	private TimesheetDto timesheetDto;
	private Members members;
	private SessionFactory sf;

	public ArrayList<TimesheetDto> membersInfo() {
		Session session = sf.getCurrentSession();
		ArrayList<TimesheetDto> ss = (ArrayList<TimesheetDto>) session.createQuery("select per from TimesheetDto per")
				.list();
		// TypedQuery query=(TypedQuery) session.createQuery("from TimesheetDto e");
		// ArrayList<TimesheetDto> list =(ArrayList<TimesheetDto>)
		// query.getResultList();
		return ss;
	}

	public ArrayList<Members> teamMembersInfo() {
		Session session = sf.getCurrentSession();
		ArrayList<Members> smembers = (ArrayList<Members>) session.createQuery("select per from Members per").list();
		return smembers;
	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public TimesheetDto getTimesheetDto() {
		return timesheetDto;
	}

	public void setTimesheetDto(TimesheetDto timesheetDto) {
		this.timesheetDto = timesheetDto;
	}

	public Members getMembers() {
		
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public String getEmail(String email) {
		Session session = sf.getCurrentSession();
		SQLQuery insertQuery = session.createSQLQuery("" + "INSERT INTO timesheetuserregistration(emailId)VALUES(?)");
		insertQuery.setParameter(0, email);
		//insertQuery.setParameter(0, "mrudu");
		insertQuery.executeUpdate();
		return email;

	}
}
