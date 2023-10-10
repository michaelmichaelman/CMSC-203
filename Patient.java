/*
 * Class: CMSC203 
 * Instructor: Dr. Gary Thai
 * Description: Patient Class is the class that gives and gets all the information for the patient,
 * such as their name and address. The Procedure Class gets and gives the information for the procedure
 * that the patient gets, and other information like the charges of the procedure.
 * Finally, the PatientDriverApp Class sets up three instances of the patient class, and then prints
 * some info about them, as well as calculating the total charges for the 3 patients.
 * Due: 10/6/2023
 * Platform/compiler: Eclipse Java
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael O'Connell
*/


package Patient;

public class Patient {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String emergencyContactFirstName;
	private String emergencyContactLastName;
	private String emergencyContactPhoneNumber;

    public Patient() {
    	this.firstName = "John";
    	this.middleName = "Tim";
    	this.lastName = "Doe";
    	this.streetAddress = "12254 Court Boulevard";
    	this.city = "Toronto";
    	this.state = "Maryland";
    	this.zipCode = "21703";
    	this.phoneNumber = "555-666-7777";
    	this.emergencyContactFirstName = "Jane";
    	this.emergencyContactLastName = "Dorothy";
    	this.emergencyContactPhoneNumber = "606-319-9954";
    }

    public Patient(String firstName, String middleName, String lastName) {
    	this.firstName = firstName;
    	this.middleName = middleName;
    	this.lastName = lastName;
    	this.streetAddress = "12254 Court Boulevard";
    	this.city = "Toronto";
    	this.state = "Maryland";
    	this.zipCode = "21703";
    	this.phoneNumber = "555-666-7777";
    	this.emergencyContactFirstName = "Jane";
    	this.emergencyContactLastName = "Dorothy";
    	this.emergencyContactPhoneNumber = "606-319-9954";
	}
    
    public Patient(String firstName, String middleName, String lastName, String streetAddress, String city, String state, String zipCode, String phoneNumber, String emergencyContactFirstName, String emergencyContactLastName, String emergencyContactPhoneNumber) {
    	this.firstName = firstName;
    	this.middleName = middleName;
    	this.lastName = lastName;
    	this.streetAddress = streetAddress;
    	this.city = city;
    	this.state = state;
    	this.zipCode = zipCode;
    	this.phoneNumber = phoneNumber;
    	this.emergencyContactFirstName = emergencyContactFirstName;
    	this.emergencyContactLastName = emergencyContactLastName;
    	this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
	}
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public String getMiddleName() {
    	return this.middleName;
    }
    
    public String getLastName() {
    	return this.firstName;
    }
    
    public String getStreetAddress() {
    	return this.streetAddress;
    }
    
    public String getCity() {
    	return this.city;
    }
    
    public String getState() {
    	return this.state;
    }
    
    public String getZipCode() {
    	return this.zipCode;
    }

    public String getPhoneNumber() {
    	return this.phoneNumber;
    }
    
    public String getEmergencyContactFirstName() {
    	return this.emergencyContactFirstName;
    }

    public String getEmergencyContactLastName() {
    	return this.emergencyContactLastName;
    }

    public String getEmergencyContactPhoneNumber() {
    	return this.emergencyContactPhoneNumber;
    }

    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public void setMiddleName(String middleName) {
    	this.middleName = middleName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public void setStreetAddress(String streetAddress) {
    	this.streetAddress = streetAddress;
    }
    
    public void setCity(String city) {
    	this.city = city;
    }
    
    public void setState(String state) {
    	this.state = state;
    }
    
    public void setZipCode(String zipCode) {
    	this.zipCode = zipCode;
    }
    
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber = phoneNumber;
    }

    public void setEmergencyContactFirstName(String emergencyContactFirstName) {
    	this.emergencyContactFirstName = emergencyContactFirstName;
    }

    public void setEmergencyContactLastName(String emergencyContactLastName) {
    	this.emergencyContactLastName = emergencyContactLastName;
    }

    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
    	this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    public String buildFullName() {
    	return this.firstName + " " + this.middleName + " " + this.lastName;
    }
    
    public String buildAddress() {
    	return this.streetAddress + " " + this.city + " " + this.state + " " + this.zipCode;
    }
    
    public String buildEmergencyContact() {
    	return this.emergencyContactFirstName + " " + this.emergencyContactLastName + " " + this.emergencyContactPhoneNumber;
    }
    
    public String toString() {
    	return "Patient info:\n" + "\tName: " + buildFullName() + "\r\n\tAddress: " + buildAddress() + "\r\n\tEmergency Contact: " + buildEmergencyContact();
    }
}
