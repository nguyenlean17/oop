//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
	private final boolean[][] grid;

	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}


	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		for (int i = 0; i < grid.length; i++) {
			boolean checkRow = true;
			for (int j = 0; j < grid[i].length; j++) {
				if (!grid[i][j]) {
					checkRow = false;
					break;
				}
			}

			if (checkRow) {

				for (int k = i - 1; k >= 0; k--) {
					grid[k + 1] = grid[k].clone();
				}


				for (int j = 0; j < grid[0].length; j++) {
					grid[0][j] = false;
				}

				i--;
			}
		}
	}

	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return null; // YOUR CODE HERE
	}
}
