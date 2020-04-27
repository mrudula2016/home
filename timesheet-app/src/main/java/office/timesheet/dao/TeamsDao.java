package office.timesheet.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import office.timesheet.entity.GroupsEntity;
import office.timesheet.entity.UserGroupsRelationEntity;
import office.timesheet.entity.UsersEntity;

public class TeamsDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

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
		System.out.println("done");
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

	public ArrayList<UserGroupsRelationEntity> fetchGroupAssociatedData() {
		Session session = sessionFactory.getCurrentSession();
		ArrayList<UserGroupsRelationEntity> membersInfo = (ArrayList<UserGroupsRelationEntity>) session
				.createQuery("select pir from UserGroupsRelationEntity pir").list();
		for(UserGroupsRelationEntity u:membersInfo)
		{
//			System.out.println(u.getGroupsEntity().getGroupName());
//			System.out.println(u.getUserEntity().getName());
			if(u.getUserEntity().getMemberGroupRel()==u.getGroupsEntity().getMemberGroupRel());
			{
			System.out.println("yes");
			}
		}
		return null;

	}

}
