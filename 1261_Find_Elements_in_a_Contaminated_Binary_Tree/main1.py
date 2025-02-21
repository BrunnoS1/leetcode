# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class FindElements(object):
    #recovers the tree and then does a dfs to find the value
    #time complexity is O(2n) -> n for recovering and n for searching (worst case)
    root = None

    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        root.val = 0
        self.root = root
        self.fixTree(root, root.val)
    
    def fixTree(self, root, val):
        if not root.left and not root.right:
            return
        if root.left:
            root.left.val = 2 * val + 1
            self.fixTree(root.left, root.left.val)
        if root.right:
            root.right.val = 2 * val + 2
            self.fixTree(root.right, root.right.val)

    def find(self, target):
        """
        :type target: int
        :rtype: bool
        """
        return self.findRec(target, self.root)
        
    def findRec(self, target, root):
        if not root:
            return False

        if root.val == target:
            return True
        
        return self.findRec(target, root.left) or self.findRec(target, root.right)

# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)