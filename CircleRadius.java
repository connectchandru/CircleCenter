import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that finds center of the White Circle Returns (-1,-1) as Center if no
 * White pixel is found, Else returns the Center (X,Y) of the circle
 * 
 * 
 * @version 1.1
 * @author Srinivasan, Chandrasekar
 * 
 */

public class CircleRadius {
	public static void main(String[] args) {
		//final int matrix[][] = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };
		final int matrix[][] =  FillMatrix();
		PrintMatrix(matrix);
		double resultXY[] = computeCentre(matrix);
		System.out.println("Centre(X,Y): (" + resultXY[0] + "," + resultXY[1]+ ")");
	}

	/**
	 * Finds the center of the Circle Returns (-1,-1) as Center if no White
	 * pixel is found, Else returns the Center (X,Y) of the circle
	 * 
	 * @param matrix  M*N Matrix
	 * @return X,Y coordinates that is the center of the Circle
	 */
	public static double[] computeCentre(int matrix[][]) {
		double resultXY[] = new double[2];
		double dist, maxDist = 0;
		ArrayList<Integer> maxElements = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> cordXY = AddCoord(matrix);
		if (cordXY.size() == 0)
			return resultXY;
		for (int k = 0; k < cordXY.size(); k++) {
			dist = 0;
			if (cordXY.get(k).size() > 0) {
				int x1 = cordXY.get(k).get(0);
				int y1 = cordXY.get(k).get(1);
				int x2 = cordXY.get(k).get(2);
				int y2 = cordXY.get(k).get(3);
				// Formulae to calculate distance between two points
				dist = Math.hypot(x2 - x1, y2 - y1);
			} else
				dist = 0;
			if (maxDist < dist) {
				maxDist = dist;
				if (maxElements.size() > 0)
					maxElements.removeAll(maxElements);

				for (int i = 0; i < cordXY.get(k).size(); i++) {
					maxElements.add(cordXY.get(k).get(i));
				}
			}
		}
		if (maxElements.size() > 0) {
			resultXY[0] = FindCentreXY(maxElements.get(0), maxElements.get(2));
			resultXY[1] = FindCentreXY(maxElements.get(1), maxElements.get(3));
		} else {
			resultXY[0] = -1;
			resultXY[1] = -1;
		}
		return resultXY;
	}

	/**
	 * Stores x and y coordinates in a ArrayList. If X1 starts with 1, it
	 * continues till X2 is 0
	 * 
	 * @param matrix  M*N Matrix
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> AddCoord(int matrix[][]) {
		int row = matrix.length;
		int col = matrix[0].length;
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		int flag = 0;
		for (int i = 0; i < row; i++) {
			ArrayList<Integer> inner = new ArrayList<Integer>();
			for (int j = 0; j < col; j++) {
				/*
				 * Checks if the element is 1, if 1 then it continues till it reaches 0
				 */
				if (matrix[i][j] == 1) {
					if (flag == 0) {
						inner.add(i);
						inner.add(j);
						flag = 1; // flag is set to indicate that start of X1
									// coordinate with value 1
					}
					/* Edge case to Handle if the last byte ends with 1 */
					else if (flag == 1 && j == col - 1) {
						inner.add(i);
						inner.add(j);
						flag = 0;
					}
				}

				/*
				 * When encounters 0, Marks the end of 1 by assigning the previous Y co-ordinate
				 */
				else if (matrix[i][j] == 0 && flag == 1) {
					inner.add(i);
					inner.add(j - 1);
					flag = 0;
				}
			}
			outer.add(inner);
		}
		return outer;
	}

	/**
	 * Computes the center of X or Y coordinates
	 * 
	 * @param t1    X1 or Y1 coordinate
	 * @param t2    X2 or Y2 coordinate
	 * @return the average of X1,X2 or Y1,Y2
	 */
	public static double FindCentreXY(double t1, double t2) {
		return ((t1 + t2) / 2);
	}

	/**
	 * Fills the Matrix Element by Element
	 * 
	 * @return the Filled matrix
	 */
	public static int[][] FillMatrix() {
		    System.out.println("Enter the number of Rows");
		    @SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
		    int M = in.nextInt();
		    System.out.println("Enter the number of Col");
		    int N = in.nextInt();
	        int[][] matrix = new int[M][N];
	        for(int row = 0; row< M; row++){
	            for(int col = 0 ;col< N; col++){
	                System.out.print("enter the element for the Matrix: A["+row+","+col+"]: ");
	                matrix[row][col] = in.nextInt();
	            }
	            System.out.println();
	        }
	        return matrix;
	    }
	
	/**
	 * Prints the M*N Matrix 
	 * 
	 * @param matrix  M*N Matrix 
	 */
	private static void PrintMatrix(int[][] matrix) {
        for(int row = 0; row< matrix.length; row++){
        	System.out.println();
            for(int col = 0;col< matrix[0].length; col++){
                System.out.print(matrix[row][col]+" "); 
            }
        }
        System.out.println();
	}

}
