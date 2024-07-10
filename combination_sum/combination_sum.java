import java.util.ArrayList;
import java.util.List;

public class combination_sum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> all_combinations = new ArrayList<List<Integer>>();

        for (int i = 0; i < candidates.length; i++) {
            int sum = candidates[i];
            List<Integer> combination = new ArrayList<Integer>();
            combination.add(candidates[i]);

            for (int j = 0; j < candidates.length; j++) {
                if (target % candidates[i] == 0) {
                    while (sum + candidates[j] <= target) {
                        sum += candidates[j];
                        combination.add(candidates[j]);
                    }
                } 
                else if (sum + candidates[j] <= target) {
                    sum += candidates[j];
                    combination.add(candidates[j]);
                    // combination.sort(null);
                }
                if (sum == target) {
                    if (!all_combinations.contains(combination)) all_combinations.add(combination);
                }
            }
        }
        return all_combinations;
    }
}
