class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        return 1 + minStepsHelper(n, 1, 1);
    }

    int minStepsHelper(int n, int currentLen, int pasteLen) {
        if (currentLen == n) return 0;

        if (currentLen > n) return 1000;

        // copy + paste
        int path1 = 2 + minStepsHelper(n, currentLen*2, currentLen);

        // paste
        int path2 = 1 + minStepsHelper(n, currentLen + pasteLen, pasteLen);

        return Math.min(path1, path2);
    }
}