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

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Object> {
	private double time;
	private ArrayList<Beverage> beverages;
	private Customer customer;
	private int orderNum;
	private Day day;

	public Order(int time, Day day, Customer customer) {
		this.time = time;
		this.day = day;
		this.customer = customer;
		this.orderNum = generateOrderNumber();
		this.beverages = new ArrayList<>();
	}

	private int generateOrderNumber() {
		Random random = new Random();
		int randInt = random.nextInt((90_000 - 10_000) + 10_000);
		return randInt;
	}
	
	@Override
	public boolean isWeekend() {
		if(day==Day.SATURDAY || day==Day.SUNDAY) {
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee cafe = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(cafe);
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		Alcohol alco = new Alcohol(bevName, size, this.isWeekend());
		beverages.add(alco);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addPRotien) {
		Smoothie juice = new Smoothie(bevName, size, numOfFruits, addPRotien);
		beverages.add(juice);
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		for(Beverage beverage:beverages) {
			total +=beverage.calcPrice();
		}
		return total;
	}
	
	public void Customer(Customer customer) {
		this.customer = new Customer(customer);
	}
	
	public void setListOfBeverage(ArrayList<Beverage> bevo) {
		this.beverages = bevo;
	}

	
	public int findNumOfBeveType1(Type type) {
		int bevType = 0;
		for(Beverage beverage:beverages) {
			if(beverage.getBevType()==type) {
				bevType++;
			}
		}
		return bevType;
	}

	public int getTotalItems() {
		return beverages.size();
	}

	public int getOrderNo() {
		return this.orderNum;
	}
	
	@Override
	public Beverage getBeverage(int i) {
		return beverages.get(i);
	}

	public double getOrderTime() {
		return time;
	}

	public Day getOrderDay() {
		return day;
	}

	@Override
	public int compareTo(Object o) {
		if(((Order) o).getOrderNo() == this.getOrderNo()) {
			return 0;
		}
		else if(((Order) o).getOrderNo() < this.getOrderNo()) {
			return 1;
		}
		else {
			return -1;
		}
	}

	public Customer getCustomer() {
		return new Customer(customer);
		}

	@Override
	public String toString() {
		return super.toString()+ "Order [beverage=" + beverages + ", customer=" + customer + ", day=" + day + ", orderNum=" + orderNum
				+ ", time=" + time + ", orderTotal=" + calcOrderTotal() + "]";
	}

	@Override
	public int findNumOfBeveType(Type type) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNumOfFruits() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getSize() {
		// TODO Auto-generated method stub
		return null;
	}
}