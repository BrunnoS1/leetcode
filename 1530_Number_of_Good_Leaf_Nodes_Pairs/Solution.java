class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public int countPairs(TreeNode root, int distance) {
        int[] pairCount = new int[1];
        countPairsHelper(root, distance, pairCount);
        return pairCount[0];
    }

    private int[] countPairsHelper(TreeNode node, int distance, int[] pairCount) {
        if (node == null) return new int[distance + 1];

        if (node.left == null && node.right == null) {
            int[] leafCount = new int[distance + 1];
            leafCount[1] = 1;
            return leafCount;
        }

        int[] leftDistances = countPairsHelper(node.left, distance, pairCount);
        int[] rightDistances = countPairsHelper(node.right, distance, pairCount);

        for (int l = 1; l <= distance; l++) {
            for (int r = 1; r <= distance; r++) {
                if (l + r <= distance) {
                    pairCount[0] += leftDistances[l] * rightDistances[r];
                }
            }
        }

        int[] currentDistances = new int[distance + 1];
        for (int i = 1; i < distance; i++) {
            currentDistances[i + 1] = leftDistances[i] + rightDistances[i];
        }

        return currentDistances;
    }

    public static void main(String[] args) {
        System.out.println();
        // [1,2,3,null,4]
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.right = new TreeNode(4);

        // [1,2,3,4,5,6,7]
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);

        // [1,1,1]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        Solution solution = new Solution();
        System.out.println(solution.countPairs(root, 3));
    }
}