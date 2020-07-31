package Game;

import java.util.Arrays;
import java.util.Scanner;

public class RedGreen {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("width=");
		int width = input.nextInt();
		System.out.println("height=");
		int height = input.nextInt();
		System.out.println("Grid size is "+ width + "x" + height);
		
		
		String[] rows = new String[height];
		
		for (int i = 0; i < height; i++) {
				
				System.out.printf("grid[row %d] = ", i);
				rows[i] = input.next();
				//validation for length of input 
		}
		Grid grid = new Grid(width, height, rows);
		System.out.println(Arrays.toString(rows));
			
		System.out.println("x1=");
		int x1 = input.nextInt();
		System.out.println("y1=");
		int y1 = input.nextInt();
		System.out.println("n=");
		int n = input.nextInt();
		
		input.close();
		int howManyTimesTheCellIsGreen=0;
				
		if (grid.isGreen(x1, y1)) {
			howManyTimesTheCellIsGreen++;
		}
		for(int i=0; i< n; i++) {
			grid.goToNextGeneration();	
			if (grid.isGreen(x1, y1)) {
				howManyTimesTheCellIsGreen++;
			}
		}
		System.out.println("Cell "+ y1 +","+ x1 + " has been green "+ howManyTimesTheCellIsGreen + " times in " + n + " generations.");				
	}
}


