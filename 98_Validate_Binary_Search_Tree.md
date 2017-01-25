## Question 
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
## Code
```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return self.isValid(root, -2147483648.1, 2147483647.1)

    def isValid(self, root, min, max):
        if not root:
            return True
        if root.val <= min or root.val >= max:
            return False

        return self.isValid(root.left, min, root.val) and self.isValid(root.right, root.val, max)
```

## Thinkings
two things: 对于最末叶子child，return True，入口if not root (root is empty)
introducting range, make it more easy to access values. Also python, -2147483648.1 to +. don't know how to remember, but certainly something worthy of remembering
