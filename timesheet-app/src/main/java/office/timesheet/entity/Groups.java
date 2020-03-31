package office.timesheet.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS")
public class Groups {
	@Id
	@Column(name = "GROUP_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true, nullable = false)
	private String groupname;
	private String access;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private java.util.List<Members> members;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}


	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public java.util.List<Members> getMembers() {
		return members;
	}

	public void setMembers(java.util.List<Members> members) {
		this.members = members;
	}

}
