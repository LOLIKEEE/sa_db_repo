import java.time.LocalDate;

import Tables.*;

public class MainClass {
	public static void main(String[] args) {
		Customer customer = new Customer((short)0, "GSD Software & Technology", "0722222222");
		Employee employee = new Employee((short)0, "Nicolae", (short)26, "0754827541");
		ProjectOwners pOwner = new ProjectOwners((short)0, "Darius");
		Projects project = new Projects((short)0, "Software Academy Training");
		RecordStatus recordStatus = new RecordStatus((short)0, "paid");
		Tasks task = new Tasks((short)0, "Study");
		
		LocalDate startDate = LocalDate.of(2022, 5, 2);
		LocalDate endDate = LocalDate.of(2022, 5, 4);
		
		TimeTraking firstRecord = new TimeTraking((short)0, employee, project, (short)8, pOwner, task ,startDate, endDate, customer, "some comments", recordStatus);
		
		System.out.println("ID: " + firstRecord.getTimeTrakingId() + "\nEMPLOYEE NAME: " + firstRecord.getEmployee().getEmployeeName() + "\nPROJECT: " + firstRecord.getProject().getProjectName() + "\nWORKED HOURS: " + firstRecord.getWorkingHours() + "\nPROJECT OWNER: " + firstRecord.getProjectOwner().getProjectOwnerName() + "\nTASK: " + firstRecord.getTask().getTaskName() + "\nSTART DATE: " + firstRecord.getStartDate() + "\nEND DATE: " + firstRecord.getEndDate() + "\nCUSTOMER: " + firstRecord.getCustomer().getCustomerName() + "\nCOMMENTS: " + firstRecord.getComments() + "\nSTATUS: " + firstRecord.getRecordStatus().getRecordStatusDescription() + "\n");
	}
}
