import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Three_sum {
    public static void main(String[] args) {
        int n = 3;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            input = input.trim().substring(1, input.length() -1);
            String[] stringNumbers = input.split(",");

            int[] nums = new int[stringNumbers.length];
            for (int j = 0; j < stringNumbers.length; j++) {
                nums[j] = Integer.parseInt(stringNumbers[j]);
            }
            System.out.println("Answer = " + threeSum(nums));
        }
        sc.close();        
    }
    
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answerList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    answerList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }

        return answerList;
    }
}
