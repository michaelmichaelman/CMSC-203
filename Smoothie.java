package Project6;

/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: Assignment/Project 6: Bradley's Beverage Shop
 * Due: 05/03/2024
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Michael O'Connell
*/

public class Smoothie extends Beverage{
	
	private boolean addProtein;
	private int fruits;
	
	private final double FRUIT_UPCHARGE = 0.50;
	private final double PROTEIN_UPCHARGE = 1.50;

	public Smoothie(String name, Size size, int numFruits, boolean protein) {
		super(name, Type.SMOOTHIE, size);
		this.addProtein = protein;
		this.fruits= numFruits;
	}

	@Override
	public double calcPrice() {
		double price = super.getBASE_PRICE();
		if(super.getSize() == Size.MEDIUM)
			price += super.getSIZE_PRICE();
		else if(super.getSize() == Size.LARGE)
			price += (2 * super.getSIZE_PRICE());
		
		if(addProtein)
			price += PROTEIN_UPCHARGE;

		price += FRUIT_UPCHARGE * fruits;
		return price;
	}

	public double getBasePrice() {
		return super.getBASE_PRICE();
	}

	public String getBevName() {
		return this.getName();
	}

	public Size getSize() {
		return super.getSize();
	}

	public int getNumOfFruits() {
		return fruits;
	}

	public boolean getAddProtein() {
		return addProtein;
	}

	public boolean getAddProtien() {
		return addProtein;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Smoothie other = (Smoothie) obj;
		return addProtein == other.addProtein && fruits == other.fruits;
	}

	@Override
	public String toString() {
		return super.toString() + ", fruits=" + fruits + ", addProtein=" + addProtein + ", price=" + calcPrice();
	}
}