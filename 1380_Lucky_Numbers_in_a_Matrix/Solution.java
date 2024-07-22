import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int candidate = matrix[i][0];
            int candidateCol = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < candidate) {
                    candidate = matrix[i][j];
                    candidateCol = j;
                }
            }

            int k = 0;
            for (k = 0; k < matrix.length; k++) {
                if (matrix[k][candidateCol] > candidate){
                    k = -1;
                    break;
                }
            }

            // if (k != -1) luckyNumbers.add(candidate);
            if (k == matrix.length) luckyNumbers.add(candidate);
        }
        for (int num : luckyNumbers) {
            System.out.println(num);
        }
        return luckyNumbers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println("\nlucky numbers = ");
        solution.luckyNumbers(matrix);
    }
}