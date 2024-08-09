class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int magicSquareCount = 0;

        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[i].length - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    magicSquareCount++;
                }
            }
        }

        return magicSquareCount;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if the numbers are distinct and 1 <= num <= 9
        boolean[] seen = new boolean[10];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        // Sum of first row
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        // Check rows
        if (grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2] != sum ||
            grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2] != sum) {
            return false;
        }

        // Check columns
        if (grid[row][col] + grid[row + 1][col] + grid[row + 2][col] != sum ||
            grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1] != sum ||
            grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2] != sum) {
            return false;
        }

        // Check diagonals
        if (grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2] != sum ||
            grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col] != sum) {
            return false;
        }

        return true;
    }
}
