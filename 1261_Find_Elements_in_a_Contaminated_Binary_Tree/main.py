# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class FindElements(object):
    #recovers the tree while saving all values to a hashset for faster search in find function
    #time complexity is O(n) -> O(n) for recovering and O(1) for checking if elemnt is in the set
    treeValues = None

    def __init__(self, root):
        """
        :type root: Optional[TreeNode]
        """
        root.val = 0
        self.treeValues = set()
        self.treeValues.add(0)
        self.fixTree(root, root.val)
    
    def fixTree(self, root, val):
        if not root.left and not root.right:
            return
        if root.left:
            newval = 2 * val + 1
            root.left.val = newval
            self.treeValues.add(newval)
            self.fixTree(root.left, root.left.val)
        if root.right:
            newval = 2 * val + 2
            root.right.val = newval
            self.treeValues.add(newval)
            self.fixTree(root.right, root.right.val)

    def find(self, target):
        """
        :type target: int
        :rtype: bool
        """
        return target in self.treeValues

# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)