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
import javax.persistence.Transient;

@Entity
@Table(name = "USERS")
@NamedQueries({ @NamedQuery(name = "usersEntity.fetchUserDetails", query = "SELECT user "
		+ "FROM UsersEntity user where user.name= :uname")})
public class UsersEntity {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "HOURLY_RATE")
	private int hourlylRate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "userEntity")
	private Set<UserGroupsRelationEntity> memberGroupRel;
	
	@Transient
	private int[] selectedGroupEntity;
	
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
			System.out.println(ue.getGroupsEntity().getGroupName());
			
			if (userAccessList == null) {
				userAccessList = ue.getGroupsEntity().getGroupName();
			} else {
				userAccessList= userAccessList+","+ue.getGroupsEntity().getGroupName();
			}
		}
		
		
		return userAccessList;
	}

	public void setUserAccessList(String userAccessList) {
		this.userAccessList = userAccessList;
	}

	public int[] getSelectedGroupEntity() {
		int i=0;
		selectedGroupEntity = new int[memberGroupRel.size()]; 
		for (UserGroupsRelationEntity ue : memberGroupRel) {
			selectedGroupEntity[i] = ue.getGroupsEntity().getId();
			i++;
		}
		return selectedGroupEntity;
	}

	public void setSelectedGroupEntity(int[] selectedGroupEntity) {
		this.selectedGroupEntity = selectedGroupEntity;
	}
	

}
