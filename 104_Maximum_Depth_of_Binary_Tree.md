## Question 
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Code
```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        return max(self.maxDepth(root.left),self.maxDepth(root.right)) + 1
```

## Thinkings
树的问题很多都要靠递归 recursion解决。递归就是自己调用自己。想的时候想两个时间点：起始，最终层。
函数的return是会return回这个函数调用的中断那里。
还是先上来要验证树是不是空的
