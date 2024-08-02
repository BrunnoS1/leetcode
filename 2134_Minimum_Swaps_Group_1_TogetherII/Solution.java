import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int minSwaps(int[] nums) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                indexList.add(i);
        }

        boolean grouped = false;
        int maxGroupedIndex = 0;
        int maxAmountGrouped = 0;
        for (int j = 0; j < indexList.size(); j++) {
            int i = j;
            int amountGrouped = 0;
            while (i < indexList.size() - 1) {
                if (!((indexList.get(i) + 1) % nums.length == indexList.get(i + 1))) {
                    grouped = false;
                    break;
                }
                amountGrouped++;
                grouped = true;
            }
            if (grouped)
                return 0;

            if (amountGrouped > maxAmountGrouped) {
                maxAmountGrouped = amountGrouped;
                maxGroupedIndex = j;
            }
        }

        Set<Integer> swapsSet = new HashSet<>();
        // minSwapsHelper(int[] nums, swapsSet);
        return Collections.min(swapsSet);
    }
}