import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] jumbledNums = new int[nums.length];
        Map<Integer, List<Integer>> jumbleToNumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int originalNum = nums[i];
            int jumbledNum = 0;
            int place = 1;
            
            // add the jumbled number to the jumbledNums array and jumbleToNumMap
            // separating each digit and taking its mapped value
            if (originalNum < 10) {
                jumbledNum = mapping[originalNum];
            } else {
                while (originalNum > 0) {
                    int digit = originalNum % 10;
                    jumbledNum = mapping[digit] * place + jumbledNum;
                    place *= 10;
                    originalNum /= 10;
                }
            }

            jumbledNums[i] = jumbledNum;

            jumbleToNumMap.putIfAbsent(jumbledNum, new ArrayList<>());
            jumbleToNumMap.get(jumbledNum).add(nums[i]);
        }

        // sort jumbledNums
        quicksort(jumbledNums, 0, jumbledNums.length - 1);

        int[] sortedNums = new int[nums.length];
        int index = 0;

        // add each original number to sortedNums and return
        for (int jumbledNum : jumbledNums) {
            List<Integer> originalNums = jumbleToNumMap.get(jumbledNum);
            for (int originalNum : originalNums) {
                sortedNums[index++] = originalNum;
            }
            originalNums.clear();
        }

        return sortedNums;
    }

    private static int partition(int[] v, int first, int last) {
        int x = v[last];
        int i = first - 1;

        for (int j = first; j < last; j++) {
            if (v[j] <= x) {
                i++;
                int tmp = v[i];
                v[i] = v[j];
                v[j] = tmp;
            }
        }
        i++;
        v[last] = v[i];
        v[i] = x;
        return i;
    }

    private static void quicksort(int[] v, int first, int last) {
        if (first < last) {
            int q = partition(v, first, last);
            quicksort(v, first, q - 1);
            quicksort(v, q + 1, last);
        }
    }
}
