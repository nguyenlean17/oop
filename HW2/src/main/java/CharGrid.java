// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int rows = grid.length;
		int cols = grid[0].length;

		int minRow = rows, maxRow = -1;
		int minCol = cols, maxCol = -1;

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (grid[r][c] == ch) {
					if (r < minRow) minRow = r;
					if (r > maxRow) maxRow = r;
					if (c < minCol) minCol = c;
					if (c > maxCol) maxCol = c;
				}
			}
		}
		if (maxRow == -1) return 0;

		int height = maxRow - minRow + 1;
		int width  = maxCol - minCol + 1;
		return height * width;
	}

	/**
	 *
	 * @param row
	 * @param col
	 * @param dRow
	 * @param dCol
	 * @param c
	 * @return
	 */
	private int countDir(int row, int col, int dRow, int dCol, char c) {
		int count = 0;
		row += dRow;
		col += dCol;
		while (row >= 0 && row < grid.length &&
				col >= 0 && col < grid[0].length &&
				grid[row][col] == c) {
			count++;
			row += dRow;
			col += dCol;
		}
		return count;
	}
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int count = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[0].length; column++) {
				char center = grid[row][column];

				int up    = countDir(row, column, -1, 0, center);
				int down  = countDir(row, column,  1, 0, center);
				int left  = countDir(row, column,  0, -1, center);
				int right = countDir(row, column,  0, 1, center);

				int arm = Math.min(Math.min(up, down), Math.min(left, right));

				if (arm >= 2) {
					count++;
				}
			}
		}

		return count;
	}
}
