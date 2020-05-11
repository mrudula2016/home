package office.timesheet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLES_DETAILS")
public class UserRolesEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	private int userRoleId;
	private String authority;
	private UsersEntity usersEntity;


	@Column(name = "USER_ID")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Column(name = "AUTHORITY")
	public String getAuthority() {
		return authority;
	}

	@Id
	@Column(name = "USER_ROLE_ID")
	public int getUserRoleId() {
		return userRoleId;
	}

	@OneToOne(mappedBy = "userRole")
	@PrimaryKeyJoinColumn
	public UsersEntity getUsersEntity() {
		return usersEntity;
	}

	public void setUsersEntity(UsersEntity usersEntity) {
		this.usersEntity = usersEntity;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
