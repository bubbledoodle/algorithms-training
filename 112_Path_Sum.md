## Question
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

## code
```python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        if root == None:
            return False
        if root.left == None and root.right == None:
            return root.val == sum
        return self.hasPathSum(root.left, sum - root.val) or self.hasPathSum(root.right, sum - root.val)
```

## Thinkings
单看code分为三个部分。第一部分检查是否空，作为每一个中断或者initial条件的返回方式
思考这种情况：当走到一个末梢时，return root.val == sum 到上一次调用中断hasPathSum。似乎是没有机会去touch到末梢再往下走 用root == None这条来返回。一层一层的减少sum
这里的递归思想不仅体现在了调用自己身上，而且在于每个调用的输入值有变化，比如前一道题的只会去改变root.left 作为递归的root输入，这里改变了sum。慢慢感受递归，不会去想很多全局的东西，一层就是一层。定义好每层的工作，也就定义好了全局的。

What does [1,null,2,3] mean in binary tree representation?
The input [1,null,2,3] represents the serialized format of a binary tree using level order traversal, where null signifies a path terminator where no node exists below. 
