package Patient;

public class PatientDriverApp {
	
	public static void main(String[] args) {
		Patient patient = new Patient();
		Procedure p1 = new Procedure();
		Procedure p2 = new Procedure("Colonoscopy", "12/25/23");
		Procedure p3 = new Procedure("Rhinoplasty", "1/32/23", "Hugh Jass", 123.54);
	
		displayPatient(patient);
		displayProcedure(p1);
		displayProcedure(p2);
		displayProcedure(p3);
		double totalCharges = calculateTotalCharges(p1, p2, p3);
		System.out.println("Total charges: " + totalCharges);
		System.out.println("\r\n");
		System.out.println("Student Name: Micahel O'Connell");
		System.out.println("MMC #: Not Sure");
		System.out.println("Due Date: 10/6/2023");
		
	}
	
	public static void displayPatient(Patient patient) {
		System.out.println(patient.toString());
	}
	
	public static void displayProcedure(Procedure procedure) {
		System.out.println(procedure.toString());
	}
	
	public static double calculateTotalCharges(Procedure p1, Procedure p2, Procedure p3) {
		return p1.getCharges() + p2.getCharges() + p3.getCharges();
	}
}
