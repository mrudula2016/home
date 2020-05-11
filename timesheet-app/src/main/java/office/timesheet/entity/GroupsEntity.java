package office.timesheet.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS")
@NamedQueries({
		@NamedQuery(name = "groupsEntity.getGroudEntityWithID", query = "SELECT groupid "
				+ "FROM GroupsEntity groupid where groupid.id= :id")})
public class GroupsEntity {
	@Id
	@Column(name = "GROUP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "GROUP_NAME", unique = true, nullable = true)
	private String groupName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "groupsEntity")
	private Set<UserGroupsRelationEntity> memberGroupRel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Set<UserGroupsRelationEntity> getMemberGroupRel() {
		return memberGroupRel;
	}

	public void setMemberGroupRel(Set<UserGroupsRelationEntity> memberGroupRel) {
		this.memberGroupRel = memberGroupRel;
	}

}
