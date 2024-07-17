import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        
        for (int toDelete : to_delete) {
            toDeleteSet.add(toDelete);
        }

        List<TreeNode> forestRoots = new ArrayList<>();
        if (!toDeleteSet.contains(root.val)) {
            forestRoots.add(root);
        }

        delNodesHelper(root, toDeleteSet, forestRoots);
        return forestRoots;
    }

    public TreeNode delNodesHelper(TreeNode current, Set<Integer> toDeleteSet, List<TreeNode> forestRoots) {
        if (current == null) return null;

        current.left = delNodesHelper(current.left, toDeleteSet, forestRoots);
        current.right = delNodesHelper(current.right, toDeleteSet, forestRoots);

        if (toDeleteSet.contains(current.val)) {
            if (current.left != null) {
                forestRoots.add(current.left);
            }
            if (current.right != null) {
                forestRoots.add(current.right);
            }
            return null;
        }
        return current;
    }
}