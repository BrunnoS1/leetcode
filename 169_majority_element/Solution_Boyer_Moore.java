import java.util.Scanner;

// solution using Boyer–Moore majority vote algorithm
class Solution_Boyer_Moore {
    public static int majorityElement(int[] nums) {
        // algorithm defines as the candidate the first element in the array
        // for every element, it increments the count if it's equal to the candidate
        // or decrements the count if it's different
        // if the count equals 0 it changes the candidate to the current element
        // because the count will always at least 1 for the majority,
        // since it's more than half (n/2) of the entries. 
        // it always returns a value, even if there is no majority
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] numsString = line.replaceAll("[\\[\\]]", "").split(",");
        int[] nums = new int[numsString.length];
        int i = 0;
        for (String num : numsString) {
            nums[i] = Integer.parseInt(num);
            i++;
        }
        System.out.println("majority = " + majorityElement(nums));
        sc.close();
    }
}
