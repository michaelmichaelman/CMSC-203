package Patient;

public class Procedure {
	
	private String name;
	private String date;
	private String practitioner;
	private double charges; 

    public Procedure() {
    	this.name = "Vasectomy";
    	this.date = "9/22/2023";
    	this.practitioner = "Dr. House";
    	this.charges = 430.77;
    }

    public Procedure(String name, String date) {
    	this.name = name;
    	this.date = date;
    	this.practitioner = "Dr. Pule";
    	this.charges = 430.77;
	}
    
    public Procedure(String name, String date, String practitioner, double charges) {
    	this.name = name;
    	this.date = date;
    	this.practitioner = practitioner;
    	this.charges = charges;
	}
    
    public String getName() {
    	return this.name;
    }
    
    public String getDate() {
    	return this.date;
    }
    
    public String getPractitioner() {
    	return this.practitioner;
    }
    
    public double getCharges() {
    	return this.charges;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setDate(String date) {
    	this.date = date;
    }
    
    public void setPractitioner(String practitioner) {
    	this.practitioner = practitioner;
    }
    
    public void setCharges(double charges) {
    	this.charges = charges;
    }
    
    public String toString() {
    	return "\n\n\t\t\tName: " + this.name + "\r\n\t\t\tDate: " + this.date + "\r\n\t\t\tPractitioner: " + this.practitioner + "\r\n\t\t\t" + this.charges;
    }
}
