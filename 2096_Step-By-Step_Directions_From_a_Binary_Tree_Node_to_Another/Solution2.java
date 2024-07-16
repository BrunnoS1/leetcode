class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution2 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        
        StringBuilder pathToStart = new StringBuilder();
        findPath(lca, startValue, pathToStart);
        
        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, destValue, pathToDest);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) {
            result.append('U');
        }
        result.append(pathToDest);
        
        return result.toString();
    }

    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return null;
        }
        if (root.val == startValue || root.val == destValue) {
            return root;
        }
        
        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }

    private boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        
        path.append('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
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
