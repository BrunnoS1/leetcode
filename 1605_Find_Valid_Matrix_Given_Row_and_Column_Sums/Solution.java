class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        
        int[][] origMatrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

                rowSum[i] -= origMatrix[i][j];
                colSum[j] -= origMatrix[i][j];
            }
        }
        
        return origMatrix;
    }
}
