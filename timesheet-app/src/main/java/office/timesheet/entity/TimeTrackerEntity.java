package office.timesheet.entity;

import java.util.Date;

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
@Table(name = "TIMETRACKER")
public class TimeTrackerEntity {

	@Id
	@Column(name = "TIMETRACKER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int timeTrackerId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJ_ALLC_ID", nullable = false)
	private ProjectAllocation projectAllocation;
	
	@Column(name = "WORK_DATE")
	private Date workDate;
	
	@Column(name = "WORKINGHOURS")
	private int workingHours;
	
	@Column(name = "STATUS")
	private char status;

	public int getTimeTrackerId() {
		return timeTrackerId;
	}

	public void setTimeTrackerId(int timeTrackerId) {
		this.timeTrackerId = timeTrackerId;
	}

	public ProjectAllocation getProjectAllocation() {
		return projectAllocation;
	}

	public void setProjectAllocation(ProjectAllocation projectAllocation) {
		this.projectAllocation = projectAllocation;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
}
