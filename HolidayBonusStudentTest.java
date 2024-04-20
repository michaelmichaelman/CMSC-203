package Project5;


import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {
			{4.1,42.1, 6.61},
			{300,43.4,775.4}, 
			{61,2524.5,79,8},
			{200,56,63}
	};
	
	private double[][] dataSetSTUDENT2 = {
			{12, 25, 884, 54},
			{297, 66, 34, 6},
			{34, 33, 885, 4},
			{2, 723, 32, 4}
	};
	
	private double[][] dataSetSTUDENT3 = {
			{66, 99, 17, 5, 9},
			{80, 19, 23, 32},
			{88, 41, 83, 40},
			{17, 10, 21, 63}
	};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(1236.97, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT), .001);
		assertEquals(6457.0, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT2), .001);
		assertEquals(798.0, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT3), .001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		double average = TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT);
		double average2 = TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT2);
		double average3 = TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT3);
		DecimalFormat df = new DecimalFormat("#.##");
		assertEquals("599.77", df.format(average));
		assertEquals("209.81", df.format(average2));
		assertEquals("41.88", df.format(average3));
		
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(63.67, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 0), .001);
		assertEquals(1506.0, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2, 0), .001);
		assertEquals(105.0, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT3, 0), .001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(779.4, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 0), .001);	
		assertEquals(713.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2, 0), .001);	
		assertEquals(150.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3, 0), .001);	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(4664.5, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT), .001);
		assertEquals(885, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT2), .001);
		assertEquals(92, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT3), .001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() {
		double[][] array=null;
		outputFile = new File("OutputData1.txt");
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		
		outputFile = new File("OutputData2.txt");
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT2, outputFile);
		
		outputFile = new File("OutputData3.txt");
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT3, outputFile);
		
		inputFile = new File("OutputData1.txt");
		array = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertArrayEquals(dataSetSTUDENT, array);
		
		inputFile = new File("OutputData2.txt");
		array = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertArrayEquals(dataSetSTUDENT2, array);
		
		inputFile = new File("OutputData3.txt");
		array = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertArrayEquals(dataSetSTUDENT3, array);
	}

}