import Tables.*;
import java.time.LocalDate;

public class TimeTraking {
	protected short timeTrakingId;
	protected Employee employee;
	protected Projects project;
	protected short workedHours;
	protected ProjectOwners pOwner;
	protected Tasks task;
	protected LocalDate dateStart;
	protected LocalDate dateEnd;
	protected Customer customer;
	protected String comments;
	protected RecordStatus record;
	
	TimeTraking(short timeTrakingId, Employee employee, Projects project, short workedHours, ProjectOwners pOwner,Tasks task, LocalDate dateStart, LocalDate dateEnd, Customer customer, String comments, RecordStatus record) {
		this.timeTrakingId = timeTrakingId;
		this.employee = employee;
		this.project = project;
		this.workedHours = workedHours;
		this.pOwner = pOwner;
		this.task = task;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.customer = customer;
		this.comments = comments;
		this.record = record;
	}
	
	
	short getTimeTrakingId() {
		return timeTrakingId;
	}
	
	Employee getEmployee() {
		return employee;
	}
	
	Projects getProject() {
		return project;
	}
	
	short getWorkingHours() {
		return workedHours;
	}
	
	ProjectOwners getProjectOwner() {
		return pOwner; 
	}
	
	Tasks getTask() {
		return task;
	}
	
	LocalDate getStartDate() {
		return dateStart;
	}
	
	LocalDate getEndDate() {
		return dateEnd;
	}
	
	Customer getCustomer() {
		return customer;
	}
	
	String getComments() {
		return comments;
	}
	
	RecordStatus getRecordStatus() {
		return record;
	}
	
}
