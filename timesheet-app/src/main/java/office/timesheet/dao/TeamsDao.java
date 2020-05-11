package office.timesheet.dao;

import java.util.ArrayList;
import java.util.Arrays;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import antlr.collections.List;
import office.timesheet.entity.GroupsEntity;
import office.timesheet.entity.ProjectAllocation;
import office.timesheet.entity.UserGroupsRelationEntity;
import office.timesheet.entity.UsersEntity;

public class TeamsDao {
	private SessionFactory sessionFactory;

	public ArrayList<GroupsEntity> fetchGroups() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<GroupsEntity> groupInfo = (ArrayList<GroupsEntity>) session
				.createQuery("select per from GroupsEntity per").list();
		return groupInfo;

	}

	public boolean addGroup(GroupsEntity groupsEntity1) {
		try {
			sessionFactory.getCurrentSession().save(groupsEntity1);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void addMember(UsersEntity usersEntity) {
		sessionFactory.getCurrentSession().save(usersEntity);
	}

	public void removeGroup() {

	}

	public void updateGroup(int userId, int groupId) {

		UsersEntity usersEntity = (UsersEntity) sessionFactory.getCurrentSession().get(UsersEntity.class, userId);
		GroupsEntity groupsEntity = (GroupsEntity) sessionFactory.getCurrentSession().get(GroupsEntity.class, groupId);
		UserGroupsRelationEntity userGroupsRelationEntity = new UserGroupsRelationEntity();
		userGroupsRelationEntity.setGroupsEntity(groupsEntity);
		userGroupsRelationEntity.setUserEntity(usersEntity);
		sessionFactory.getCurrentSession().save(userGroupsRelationEntity);

	}

	public ArrayList<UsersEntity> fetchMembers() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<UsersEntity> membersInfo = (ArrayList<UsersEntity>) session
				.createQuery("select pur from UsersEntity pur").list();

		return membersInfo;

	}

	public void onRowEdit(GroupsEntity groupsEntity) {
		sessionFactory.getCurrentSession().update(groupsEntity);

	}

	public void deleteAction(GroupsEntity ee) {
		sessionFactory.getCurrentSession().delete(ee);
	}

	public GroupsEntity getGroudEntityWithID(int i) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("groupsEntity.getGroudEntityWithID");
		query.setParameter("id", i);
		GroupsEntity groupdEntity = (GroupsEntity) query.uniqueResult();
		return groupdEntity;

	}

	public void groupID(UserGroupsRelationEntity ugre) {
		sessionFactory.getCurrentSession().save(ugre);
	}

//	public ArrayList<GroupsEntity> getGroupID(int[] selectedGroupEntity) {
//
//		ArrayList<Integer> list2 = new ArrayList<Integer>();
//		for (int i = 0; i < selectedGroupEntity.length; i++) {
//			list2.add(selectedGroupEntity[i]);
//		}
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.getNamedQuery("groupsEntity.getGroupID");
//		 query.setParameter("groupsIDs", list2);
//		ArrayList<GroupsEntity> groups = (ArrayList<GroupsEntity>) query.list();
//	 return groups;
//	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
