package office.timesheet.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GROUP_ENT")
public class GroupsEntity {
	@Id
	@Column(name = "GROUP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "GROUP_NAME", unique = true, nullable = false)
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
