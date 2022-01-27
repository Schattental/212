//Benedikt Gregor 20215194

package a1;
import java.lang.Math;
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
	
	public static void init(int grains, int[][] cells) {
		int rows = cells.length;
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		}
		int cols = cells[0].length;
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		}
		if(grains < 0) {
			throw new IllegalArgumentException("grains < 0");
		}
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				cells[r][c] = 0;
			}
		}
		cells[rows/2][cols/2] = grains;
	}
	
	public static Index2 first_to_topple(int[][] cells) {
		int rows = cells.length;
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		}
		int cols = cells[0].length;
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		}
		Index2 idx = new Index2(0, 0);
		for(int r = 0; r < rows; r++) {
			idx.row = r;
			for(int c = 0; c < cols; c++) {
				idx.col = c;
				int val = cells[r][c];
				if(val >= 4) {
					return idx;
				}
			}
		}
		idx.row = -1;
		idx.col = -1;
		return idx;
	}
	
	public static void topple(Index2 i, int[][] cells) {
		int rows = cells.length;
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		}
		int cols = cells[0].length;
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		}
		int grains = cells[i.row][i.col];
		if(grains >= 4) {
			cells[i.row][i.col] -= 4;
		}
		if (i.row > 0) {
			cells[i.row - 1][i.col]++;
		}
		// move one grain east right (if possible)
		if (i.col < cols - 1) {
			cells[i.row][i.col + 1]++;
		}
		// move one grain south (if possible)
		if (i.row < rows - 1) {
			cells[i.row + 1][i.col]++;
		}
		// move one grain west (if possible)
		if (i.col > 0) {
			cells[i.row][i.col - 1]++;
		}
	}
	
	public static int degree(Index2 i, int[][] cells) {
		int rows = cells.length;
		if (rows <= 0) {
			throw new IllegalArgumentException("rows <= 0");
		}
		int cols = cells[0].length;
		if (cols <= 0) {
			throw new IllegalArgumentException("cols <= 0");
		}
		if(i.row > rows || i.col > i.col) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		//These check if the Index is in one of the four corners
		if(i.row == rows && i.col == cols) {
			return 2;
		}
		if(i.row == 0 && i.col == 0) {
			return 2;
		}
		if(i.row == 0 && i.col == cols) {
			return 2;
		}
		if(i.row == rows && i.col == 0) {
			return 2;
		}
		//These check whether the Index is along the edges excluding corners
		if(i.row == rows && i.col < cols && i.col != 0) {
			return 3;
		}
		if(i.row < rows && i.col == 0 && i.row != 0) {
			return 3;
		}
		if(i.row < rows && i.col == cols && i.row != 0) {
			return 3;
		}
		if(i.row == 0 && i.col < cols && i.col != 0) {
			return 3;
		}
		return 4; //Returning 4 which means Index is not a corner or along an edge
	}
	
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
		init((int) Math.pow(2,8), cells);
		System.out.println("Original cells\n");
		printCells(cells);
		Index2 i = first_to_topple(cells);
		while(i.row >= 0) {
			topple(i, cells);
			i = first_to_topple(cells);
		}
		System.out.println("\nFinal cells\n");
		printCells(cells);
		Index2 f = new Index2(2,3); //Test the degree method by changing Index here
		System.out.println("\nDegree of Index " + f.toString()+ " = " + degree(f,cells));
		// THE NEXT TWO LINES SHOULD BE THE LAST LINES OF THE METHOD 
		// show an image of the stable configuration
		SandpileViewer.draw(cells);
	}

}
