## Question
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

## Code
```python
# Definition for a  binary tree node
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):
    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        while root:
            self.stack.append(root)
            root = root.left

    def hasNext(self):
        """
        :rtype: bool
        """
        return True if self.stack else False

    def next(self):
        """
        :rtype: int
        """
        current = self.stack.pop()
        node = current.right
        while node:
            self.stack.append(node)
            node = node.left
        return current.val

# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
```

## Thinkings
算是里程碑式的一道题，树，栈，中序遍历，循环器

1. BST的中序遍历
2. 循环器 像代码最后段写的怎样调用，i相当于self，v maintain一个stack存储当前的量。当栈不空，stack append
3. python的栈很简单直接pop但对于中序遍历的栈实在是6 详见后面一段：

>
本题相当于考察了BST的非递归中序遍历
需要maintain一个stack，首先从root开始push入栈直到最左节点
初始stack为：
10, 6, 3
在遍历过程中，如果某个节点存在右儿子，则继续从右儿子开始push入栈直到其最左节点
result = 3, 6
因为6有右儿子，所以6被pop出去之后，从6为root开始push入栈直到最左节点，然后stack为：
10， 9， 8， 7
