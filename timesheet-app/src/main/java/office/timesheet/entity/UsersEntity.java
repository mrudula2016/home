package office.timesheet.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "USERS")
@NamedQueries({
		@NamedQuery(name = "usersEntity.fetchUserDetails", query = "SELECT user "
				+ "FROM UsersEntity user where user.name= :uname"),
		@NamedQuery(name = "usersEntity.fetchUserIdName", query = "SELECT user FROM UsersEntity user"),
		@NamedQuery(name = "usersEntity.getUsername", query = "SELECT user "
				+ "FROM UsersEntity user where user.name= :uname"),
		@NamedQuery(name = "usersEntity.getUserID", query = "SELECT user.userId "
				+ "FROM UsersEntity user where user.name= :uname"),
		@NamedQuery(name = "usersEntity.testMethod", query = "SELECT user.name "
				+ "FROM UsersEntity user where user.name like :uname ") })
public class UsersEntity {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "USER_NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED")
	private Boolean enabled;

	@Column(name = "HOURLY_RATE")
	private int hourlylRate;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", unique = true, nullable = false, updatable = false)
	private UserRolesEntity userRole;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userEntity")
	private Set<UserGroupsRelationEntity> memberGroupRel;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
	private Set<ProjectAllocation> employeeEntity;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
	private Set<ProjectDetailsEntity> projectDetailsEntity;

//	@Transient
//	private int[] selectedGroupEntity;
//
	@Transient
	private String userAccessList;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserGroupsRelationEntity> getMemberGroupRel() {
		return memberGroupRel;
	}

	public void setMemberGroupRel(Set<UserGroupsRelationEntity> memberGroupRel) {
		this.memberGroupRel = memberGroupRel;
	}

	public int getHourlylRate() {
		return hourlylRate;
	}

	public void setHourlylRate(int hourlylRate) {
		this.hourlylRate = hourlylRate;
	}

	public String getUserAccessList() {
			for (UserGroupsRelationEntity ue : memberGroupRel) {
				if (userAccessList == null) {
					userAccessList = ue.getGroupsEntity().getGroupName();
				} else {
					userAccessList = userAccessList + "," + ue.getGroupsEntity().getGroupName();
				}
			}
		
		return userAccessList;
	}

	public void setUserAccessList(String userAccessList) {
		this.userAccessList = userAccessList;
	}

//	public int[] getSelectedGroupEntity() {
//		int i = 0;
//		selectedGroupEntity = new int[memberGroupRel.size()];
//		for (UserGroupsRelationEntity ue : memberGroupRel) {
//			selectedGroupEntity[i] = ue.getGroupsEntity().getId();
//			i++;
//		}
//		return selectedGroupEntity;
//	}
//
//	public void setSelectedGroupEntity(int[] selectedGroupEntity) {
//		this.selectedGroupEntity = selectedGroupEntity;
//	}

	public Set<ProjectAllocation> getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(Set<ProjectAllocation> employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public UserRolesEntity getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRolesEntity userRole) {
		this.userRole = userRole;
	}

	public Set<ProjectDetailsEntity> getProjectDetailsEntity() {
		return projectDetailsEntity;
	}

	public void setProjectDetailsEntity(Set<ProjectDetailsEntity> projectDetailsEntity) {
		this.projectDetailsEntity = projectDetailsEntity;
	}

}
