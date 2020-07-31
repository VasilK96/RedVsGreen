package Game;

import java.util.Arrays;

public class Grid {
	final int[] changeToGreen = {3,6};
	final int[] changeToRed= {0,1,4,5,7,8};
	
	private int width;
	private int height;
	private	Cell[][] cells;
	
	public Grid(int width, int height, String[] rows) {
		
		this.width = width;
		this.height = height;
		this.cells = new Cell[this.height][this.width];
		
		for (int y = 0; y < height; y++) {
			String row=rows[y];
			for (int x = 0; x < width; x++) {
				cells[y][x] = new Cell(Integer.parseInt(row.substring(x, x+1)));
			}
		}
		
	}
	
	public void goToNextGeneration() {
		Cell[][] nextGenerationCells = new Cell[this.height][this.width];
		
		for (int x = 0; x < this.width; x++) {
			for (int y = 0; y < this.height; y++) {
				nextGenerationCells[y][x] = createNewCell(x, y);
			}
		}
		
		this.cells = nextGenerationCells;
	}	
	
	private Cell createNewCell(int x, int y) {
		int neighboursSum = calculateNeighboursSum(x, y);
		
		if (cells[y][x].isGreen()) {
			if ( Arrays.stream(changeToRed).anyMatch(i -> i == neighboursSum)){
				return new Cell(1);
			} 
			else {
				return new Cell(0);
			}
		} else { 
			// Red
			if (Arrays.stream(changeToGreen).anyMatch(i -> i == neighboursSum)){
				return new Cell(0);
			} 
			else {
				return new Cell(1);
			}
		}
	}

	private int calculateNeighboursSum(int x, int y) {
		int neighboursSum = 0;
		if (x > 0) {
			if (y > 0) {
				neighboursSum += cells[y-1][x-1].value;
			}
			neighboursSum += cells[y][x-1].value;
			if (y < height-1) {
				neighboursSum += cells[y+1][x-1].value;
			}
		}
		
		// Under
		if (y > 0) {
			neighboursSum += cells[y-1][x].value;
		}
		
		// Above
		if (y < height-1) {
			neighboursSum += cells[y+1][x].value;
		}	
		
		// To the right
		if (x < width-1) {
			if (y > 0) {
				neighboursSum += cells[y-1][x+1].value;
			}
			neighboursSum += cells[y][x+1].value;
			if (y < height-1) {
				neighboursSum += cells[y+1][x+1].value;
			}
		}
		
		return neighboursSum;
	}

	public boolean isGreen(int x,int y){
		return cells[x-1][y-1].isGreen();
	}
}