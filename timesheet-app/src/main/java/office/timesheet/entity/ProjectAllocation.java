package office.timesheet.entity;

import java.util.Date;
import java.util.Set;

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
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT_ALLOCATION")
@NamedQueries({
		@NamedQuery(name = "ProjectAllocation.fetchUserAndProject", query = "SELECT project FROM ProjectAllocation project where project.projectDetailsEntity.id in (:projectIds)") })
public class ProjectAllocation {
	@Id
	@Column(name = "PROJ_ALLC_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectAllocationId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJECT_ID", nullable = false)
	private ProjectDetailsEntity projectDetailsEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", nullable = false)
	private UsersEntity userEntity;

	@Column(name = "START_DATE", nullable = true)
	private Date startDate;

	@Column(name = "END_DATE", nullable = true)
	private Date endDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectAllocation")
	private Set<TimeTrackerEntity> timeTrackerEntity;

	public int getProjectAllocationId() {
		return projectAllocationId;
	}

	public void setProjectAllocationId(int projectAllocationId) {
		this.projectAllocationId = projectAllocationId;
	}

	public ProjectDetailsEntity getProjectDetailsEntity() {
		return projectDetailsEntity;
	}

	public void setProjectDetailsEntity(ProjectDetailsEntity projectDetailsEntity) {
		this.projectDetailsEntity = projectDetailsEntity;
	}

	public UsersEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UsersEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<TimeTrackerEntity> getTimeTrackerEntity() {
		return timeTrackerEntity;
	}

	public void setTimeTrackerEntity(Set<TimeTrackerEntity> timeTrackerEntity) {
		this.timeTrackerEntity = timeTrackerEntity;
	}

}