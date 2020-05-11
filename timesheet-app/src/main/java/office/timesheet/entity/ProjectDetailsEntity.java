package office.timesheet.entity;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PROJECT_DETAILS")
@NamedQueries({
		@NamedQuery(name = "ProjectDetailsEntity.fetchProject", query = "SELECT project FROM ProjectDetailsEntity project") })
public class ProjectDetailsEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PROJECT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", unique = false, nullable = false, updatable = false)
	private UsersEntity userEntity;

	@Column(name = "PROJECT_NAME", unique = true, nullable = true)
	private String projectName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectDetailsEntity")
	private Set<ProjectAllocation> employeeEntity;

	@Column(name = "START_DATE", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date startDate;

	@Column(name = "END_DATE", nullable = true)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "M-")
	private Date endDate;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public UsersEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UsersEntity userEntity) {
		this.userEntity = userEntity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<ProjectAllocation> getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(Set<ProjectAllocation> employeeEntity) {
		this.employeeEntity = employeeEntity;
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

}
