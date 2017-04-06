import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class CircleRadiusTest {

	/*
	 *  This function is to test method ComputeCentre
	 *  
	*/ 
	@Test
	public void testComputeCentre() {
		double[] resultXYActual;
		int[][] arrActual = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
		int[][] arrActual1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		int[][] arrExpected = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
		
		// Verify if we are getting (-1,-1) if not able  to find white
		resultXYActual = CircleRadius.computeCentre(arrActual1);
		assertEquals(-1, resultXYActual[0],0.5);
		
		// Calculates right Y value for the given matrix
		resultXYActual = CircleRadius.computeCentre(arrActual);
		assertEquals(1.5, resultXYActual[1],0.5);
		
		//Checks if arrays are equal
		assertArrayEquals(arrExpected, arrActual);
		
		//Checks if 2D Array is null
		assertNotNull(arrActual);
	}
	
	/*
	 *  This function is to test method AddCoord
	 *  
	*/ 	
	@Test
	public void testAddCoord() {
		int[][] arrActual = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
		int[][] arrExpected = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
		
		//Verify if the inner element first element is 0 
		ArrayList<ArrayList<Integer>> cordXY = CircleRadius.AddCoord(arrActual);
		List<Integer> inner = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1));		
		int ActualValue = cordXY.get(0).get(0);
		assertEquals(inner.get(0), ActualValue, 0);
		
		//Checks if arrays are equal
		assertArrayEquals(arrExpected, arrActual);
		
		//Checks if 2D Array is null
		assertNotNull(arrActual);
	}

	/*
	 *  This function is to test method PrintMatrix
	 *  
	*/ 
	@Test
	public void testPrintMatrix() {
		double[][] arrActual = {{0.0}, {1.0}, {2.0}, {1}};
		double[][] arrExpected = {{0.0}, {1.0}, {2.0}, {1}};
		assertArrayEquals(arrExpected, arrActual);
	
	}
	
	/*
	 *  This function is to test All
	 *  the positive test cases of method FindCentreXY
	 *  
	*/ 
	@Test
	public void testFindCentreXYPass() {
		//Pass if Upper Variation is less than 0.5
		assertEquals(4.5, CircleRadius.FindCentreXY(2,6), 0.5);
		//Pass if Variation is less than 0.5
		assertEquals(4, CircleRadius.FindCentreXY(2,6), 0.5);
		//Pass if lower Variation is less than 0.5
		assertEquals(3.5, CircleRadius.FindCentreXY(2,6), 0.5);
	}
	
	/*
	 *  This function is to test All
	 *  Negative test cases of method FindCentreXY
	 *  
	*/ 	
	@Test
	public void testFindCentreXYFail() {
		//Fails if Variation is more than 0.5
		assertNotEquals(4.6, CircleRadius.FindCentreXY(2,6), 0.5);
		//Fails if Variation is more than 0.5
		assertNotEquals(3.4, CircleRadius.FindCentreXY(2,6), 0.5);
		//Fails if Variation is more than 0.5
		assertNotEquals(0, CircleRadius.FindCentreXY(2,6), 0.5);
	}
}
