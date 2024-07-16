import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childrenSet = new HashSet<>();
        Map<Integer, int[]> childrenHashMap = new HashMap<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            childrenHashMap.putIfAbsent(parent, new int[] { -1, -1 });
            childrenSet.add(child);

            if (isLeft) {
                childrenHashMap.get(parent)[0] = child;
            } else {
                childrenHashMap.get(parent)[1] = child;
            }
        }

        int headVal = 0;
        for (int parent : childrenHashMap.keySet()) {
            if (!childrenSet.contains(parent)) {
                headVal = parent;
                break;
            }
        }

        return buildTree(headVal, childrenHashMap);
    }

    private TreeNode buildTree(int currentVal, Map<Integer, int[]> childrenHashMap){
        TreeNode newNode = new TreeNode(currentVal);
        if (childrenHashMap.containsKey(currentVal)) {
            int[] children = childrenHashMap.get(currentVal);
            if (children[0] != -1) {
                newNode.left = buildTree(children[0], childrenHashMap);
            }
        
            if (children[1] != -1) {
                newNode.right = buildTree(children[1], childrenHashMap);
            }
        }
        return newNode;
    }
}