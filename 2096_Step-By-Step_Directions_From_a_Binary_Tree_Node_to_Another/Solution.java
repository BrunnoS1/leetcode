class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        String startPath = findNode("", root, startValue);
        String destPath = findNode("", root, destValue);
        
        if (startPath.equals("not found") || destPath.equals("not found")) {
            throw new IllegalArgumentException("Start or destination value not found in the tree.");
        }

        int i = 0;
        while (i < startPath.length() && i < destPath.length() && startPath.charAt(i) == destPath.charAt(i)) {
            i++;
        }

        StringBuilder directions = new StringBuilder();

        for (int j = i; j < startPath.length(); j++) {
            directions.append('U');
        }

        for (int k = i; k < destPath.length(); k++) {
            directions.append(destPath.charAt(k));
        }

        return directions.toString();
    }
    
    private String findNode(String path, TreeNode current, int target) {
        if (current == null) return "not found"; 
        if (current.val == target) return path;
        
        String leftString = findNode(path + "L", current.left, target);
        if (!leftString.equals("not found")) return leftString;
        
        String rightString = findNode(path + "R", current.right, target);
        return rightString;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        Solution solution = new Solution();
        String result = solution.getDirections(root, 3, 6);
        System.out.println(result);
    }
}
