package office.timesheet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_GROUP_RELATION")
public class UserGroupsRelationEntity {

	@Id
	@Column(name = "RELATION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int relationId;

	@Column(name = "GROUP_ID")
	private String GroupId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private UsersEntity userEntity;

	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}

	public UsersEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UsersEntity userEntity) {
		this.userEntity = userEntity;
	}

}
