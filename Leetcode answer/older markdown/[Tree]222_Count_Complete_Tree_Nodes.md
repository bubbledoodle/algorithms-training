## Question
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

## Code
```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        
        if self.getLevel(root, True) == self.getLevel(root, False):
            return int(pow(2, self.getLevel(root, True))) - 1
        else: return self.countNodes(root.left) + self.countNodes(root.right) + 1
        
    def getLevel(self, root, isLeft):
        """
        :type root: TreeNode
        :rtype: int
        """
        level = 0
        
        while root:
            if isLeft:
                root = root.left
            else:
                root = root.right
            level += 1
            
        return level
```

## Thinkings
Things to stress:

1. Think of directly count through all nodes, O(n) exceed time limit.
2. check two child branch, the level not equal, countNode respectively. 发现一个completeBT有多少层只需要走到头，看深度相等不。所以如果一个满二叉树，相等的深度，访问两边就能知道是不是全满。有条件给最后一行元素都尽量靠左，所以省去了很多没必要的元素访问
3. equal level directly compute the number of nodes. 
