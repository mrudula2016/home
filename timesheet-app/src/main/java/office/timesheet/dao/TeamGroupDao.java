package office.timesheet.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import office.timesheet.entity.Groups;

public class TeamGroupDao {
	private SessionFactory sf;
	private Groups groups;

	public ArrayList<Groups> groupsData() {
		Session session = sf.getCurrentSession();
		ArrayList<Groups> gp = (ArrayList<Groups>) session.createQuery("select per from Groups per").list();
		return gp;

	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

}
