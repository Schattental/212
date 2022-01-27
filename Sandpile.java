package a1;

public class Sandpile {

	/**
	 * Print a 2-dimensional array of cells using least 3 spaces for each value.
	 * Values for each row of the array appear on a single line, and each row
	 * appears on its own line.
	 * 
	 * @param cells a two-dimensional array
	 * @throws IllegalArgumentException if the specified array has a dimension equal
	 *                                  to zero
	 */
	public static void printCells(int[][] cells) {
		int rows = cells.length;
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		}

		int cols = cells[0].length;
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		}
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				int val = cells[r][c];
				System.out.printf("%3d", val);
			}
			System.out.println();
		}
	}

	// TRANSLATE THE REMAINING C FUNCTIONS INTO JAVA METHODS HERE
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Creates a 15x15 sandpile simulation starting with 2 to-the-power 8 grains of
	 * sand on the center cell. The starting configuration of cells is printed to
	 * standard output and then the simulation is run until all cells reach a stable
	 * state (have fewer than 4 grains of sand). The stable configuration of cells
	 * is printed to standard output.
	 * 
	 * <p>
	 * Finally, an image of the stable configuration is shown.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		int[][] cells = new int[15][15];
		// FINISH TRANSLATING THE main FUNCTION HERE
		
		
		


		// THE NEXT TWO LINES SHOULD BE THE LAST LINES OF THE METHOD 
		// show an image of the stable configuration
		SandpileViewer.draw(cells);
	}

}
