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

public class BevShop implements BevShopInterface{
	ArrayList<Order> orders;
	
	private int numAlcohol;
	private int currentOrderIndex;
	
	public BevShop() {
		orders = new ArrayList<>();
	}

	
	public boolean validTime(int time) {
		return (time >= MIN_TIME) && (time <= MAX_TIME);
	}

	
	public boolean eligibleForMore() {
		if(numAlcohol < MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	
	public boolean validAge(int age) {
		return age > MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrderIndex = orders.indexOf(order);
		numAlcohol = 0;
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size);
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtien) {
		orders.get(currentOrderIndex).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}

	@Override
	public int findOrder(int orderNo) {
		for (int i= 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	@Override
	public double totalMonthlySale() {
		double sum = 0;
		for (int i = 0; i < orders.size(); i++) {
			sum += orders.get(i).calcOrderTotal();
		}
		return sum;
	}
	
	@Override
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	@Override
	public void sortOrders() {
		for(int i = 0; i<orders.size()-1; i++) {
			int minOrder = i;
			for (int j = i + 1; j < orders.size(); j++) {
				if(orders.get(j).getOrderNo() < orders.get(minOrder).getOrderNo()) {
					minOrder = j;
				}
			}
			Order swap = orders.get(minOrder);
			orders.set(minOrder, orders.get(i));
			orders.set(i, swap);
		}
		
	}

	public Order getCurrentOrder() {
		return orders.get(currentOrderIndex);
	}
	
	public int getNumOfAlcoholDrink() {
		return numAlcohol;
	}

	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	public boolean isMaxFruit(int i) {
		return i > MAX_FRUIT;
	}

	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public String toString() {
		String str = "BEV SHOP\nMINTHLY SALES:"+ totalMonthlySale() + "\n\n";
		for (int i = 0; i < orders.size(); i++) {
			str +="Order "+i+ "\n";
			str +=orders.get(i).toString();
		}
		return str;
	}

	@Override
	public boolean isValidTime(int time) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxNumOfFruits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEligibleForMore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidAge(int age) {
		// TODO Auto-generated method stub
		return false;
	}
}