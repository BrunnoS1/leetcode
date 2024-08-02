class Solution {
    public int minSwaps(int[] nums) {
        // using sliding window
        int n = nums.length;
        int numOfOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                numOfOnes++;
            }
        }

        if (numOfOnes == 0 || numOfOnes == n) {
            return 0;
        }

        int[] extendedNums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            extendedNums[i] = nums[i % n];
        }

        int maxOnesInWindow = 0;
        int currentOnesInWindow = 0;

        for (int i = 0; i < numOfOnes; i++) {
            if (extendedNums[i] == 1) {
                currentOnesInWindow++;
            }
        }
        maxOnesInWindow = currentOnesInWindow;

        for (int i = numOfOnes; i < 2 * n; i++) {
            if (extendedNums[i] == 1) {
                currentOnesInWindow++;
            }
            if (extendedNums[i - numOfOnes] == 1) {
                currentOnesInWindow--;
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }

        return numOfOnes - maxOnesInWindow;
    }
}
