class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // array with possible directions for traversal
        int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        // array to store traversed cells
        int[][] traversed = new int[rows * cols][2];
        // index to store the traversed cells
        int index = 0;

        // step increases by 1 after each pair of movements and initial direction is right
        for (int step = 1, direction = 0; index < rows * cols;) {
            // direction 0 = right 1 = down
            // direction 2 = left 3 = up
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {
                    // check if current position is valid within the matrix and add it to traversed array
                    if (rStart >= 0 &&
                            rStart < rows &&
                            cStart >= 0 &&
                            cStart < cols) {
                        traversed[index][0] = rStart;
                        traversed[index][1] = cStart;
                        index++;
                    }
                    // go to next position in spiral
                    rStart += directions[direction][0];
                    cStart += directions[direction][1];
                }
                // 0 <= direction <= 3 (right down left up)
                direction = (direction + 1) % 4;
            }
            // increment the step after a pair of moves
            step++;
        }
        return traversed;
    }
}