package office.timesheet.ui;

import java.util.ArrayList;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import office.timesheet.entity.Members;
import office.timesheet.service.TeamMemberService;
import office.timesheet.service.TimesheetService;

@ManagedBean(name = "memberManagedBean")
public class MemberManagedBean {

	@ManagedProperty(value = "#{teamMemberServicemanagedbean}")
	private TeamMemberService teamMemberService;
	private ArrayList<TimesheetDto> timesheetDtoResult;
	private ArrayList<Members> members;
	private Members membersForEmail = new Members();
	public String emailFromDoa;

	@ManagedProperty(value = "#{tss}")
	private TimesheetService timesheetservice;

	private TimesheetDto timesheetDto = new TimesheetDto();

	public Members getMembersForEmail() {
		return membersForEmail;
	}

	public void setMembersForEmail(Members membersForEmail) {
		this.membersForEmail = membersForEmail;
	}

	@PostConstruct
	public void init() {
		teamMembersInfo();
	}

	public TeamMemberService getTeamMemberService() {
		return teamMemberService;
	}

	public void setTeamMemberService(TeamMemberService teamMemberService) {
		this.teamMemberService = teamMemberService;
	}

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void membersInfo() {
		timesheetDtoResult = teamMemberService.membersInfo();
		for (TimesheetDto s : timesheetDtoResult) {
			System.out.println(s.getName());
		}
	}

	public ArrayList<TimesheetDto> getTimesheetDtoResult() {
		return timesheetDtoResult;
	}

	public void setTimesheetDtoResult(ArrayList<TimesheetDto> timesheetDtoResult) {
		this.timesheetDtoResult = timesheetDtoResult;
	}

	public void teamMembersInfo() {

		members = teamMemberService.teamMembersInfo();
	}

	public ArrayList<Members> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Members> members) {
		this.members = members;
	}
	@PostConstruct
	public void getEmail() {
		
		emailFromDoa=teamMemberService.getEmail(membersForEmail.getEmail());
		// timesheetservice.addDataService(timesheetDto);
		Members m=new Members();
		m.setEmail(emailFromDoa);
		members.add(m);
		System.out.println("done");
	}

	public TimesheetService getTimesheetservice() {
		return timesheetservice;
	}

	public void setTimesheetservice(TimesheetService timesheetservice) {
		this.timesheetservice = timesheetservice;
	}

	public TimesheetDto getTimesheetDto() {
		return timesheetDto;
	}

	public void setTimesheetDto(TimesheetDto timesheetDto) {
		this.timesheetDto = timesheetDto;
	}

}
