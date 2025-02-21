# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        result = []
        self.recInorder(root, result)
        return result
    
    def recInorder(self, root, result):
        if root:
            self.recInorder(root.left, result)
            result.append(root.val)
            self.recInorder(root.right, result)
