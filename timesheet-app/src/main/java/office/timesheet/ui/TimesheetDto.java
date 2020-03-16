package office.timesheet.ui;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "timesheet")
@NamedQueries({ @NamedQuery(name = "timesht.fetchUserDetails", query = "SELECT timeshtDto "
		+ "FROM TimesheetDto timeshtDto where timeshtDto.name= :uname")
		// timesht.fetchUserDetails it a name we can give any thing
		// timeshtDto it is a reference we can give anyhting
		// using + we can concate the query or else we can pass a whole string not a
		// problem
		// name is the cloloumn name in the table and uname is the data we are getting
		// from ui and we are passing it to Doa
		// ("uname", entryname) in doa class have to delcare like this in order to tell
		// both are same
})

public class TimesheetDto {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true ,nullable = false)
	private String name;
	private String emailId;
	private String password;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
