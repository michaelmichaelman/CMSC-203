package Project5;

/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: This class just has two methods: One that calculates the Holiday Bonus for each store, and 
 * one that calculates the total of Holiday Bonuses.
 * Due: 04/19/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Michael O'Connell
*/


public class HolidayBonus {
	
	
	
	/** Calculates the holiday bonus for multiple categories
	 * @param data The 2d array to work with
	 * @return An array with bonuses for the categories
	 */
	public static double[] calculateHolidayBonus(double[][] data) {
		double[] bonus = new double[data.length]; // Create bonus array to hold the bonuses for every category
		final double HIGH = 5000.0;
		final double LOW = 1000.0;
		final double OTHER = 2000.0;
		// Loop through every row
		for (int i = 0; i < data.length; i++) {
			// Loop through every column
			for (int k = 0; k < data[i].length; k++) {
				// Check if the current column in the data with row i is the highest in its column
				if (data[i][k] > 0) {
					if (data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k))
						// If it is, add a high bonus to the current row i
						bonus[i] += HIGH;
					// If not, check if it's the lowest in its column
					else if (data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k))
						// If it is, add a low bonus to the current row i
						bonus[i] += LOW;
					else
					// If it's neither the highest or the lowest, then give it the other bonus
						bonus[i] += OTHER;
					}
			}
			
		}
		
		// Return the bonus array with the calculated bonuses
		return bonus;
	}
	
	/** Calculates the total of all bonuses for every category
	 * 
	 * @param data The 2d array to be queried
	 * @param high The bonus for the category with the highest sales
	 * @param low The bonus for the category with the lowest sales
	 * @param other The bonus for all other categories
	 * @return The total of all bonuses for all categories
	 */
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] bonus = new double[data.length]; // Create bonus array to hold the bonuses for every category
		double sum = 0;
		final double HIGH = 5000.0;
		final double LOW = 1000.0;
		final double OTHER = 2000.0;
		
		// Loop through every row
		for (int i = 0; i < data.length; i++) {
			// Loop through every column
			for (int k = 0; k < data[i].length; k++)
				// Check if the data is above 0 before calculating the bonus
				if (data[i][k] > 0) {
					// Check if the current column in the data with row i is the highest in its column
					if (data[i][k] == TwoDimRaggedArrayUtility.getHighestInColumn(data, k))
						// If it is, add a high bonus to the current row i
						bonus[i] += HIGH;
					// If not, check if it's the lowest in its column
					else if (data[i][k] == TwoDimRaggedArrayUtility.getLowestInColumn(data, k))
						// If it is, add a low bonus to the current row i
						bonus[i] += LOW;
					else
						// If it's neither the highest or the lowest, then give it the other bonus
						bonus[i] += OTHER;
				}
			
		}
		
		// Loop through the bonus array
		for (int i = 0; i < bonus.length; i++)
			// Add every value in the bonus to the sum
			sum += bonus[i];
		
		// Return the sum of the array
		return sum;
	}
}