// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].

// 类似于之前做的level order traversal, 这一次相当于输出每一个level最后一个元素。一个想法就是直接读取最后一个元素。然而会占用大量不必要的空间。做一点小手脚：if(level == list.size()) list.add(root.val) 保证每一次加的元素都是这一层最应该加的。此话怎讲？先右再左 顺序不能乱



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(res, root, 0);
        return res;
    }
    private void rightView(List<Integer> list, TreeNode root, int level) {
        if(root == null) return;
        if(level == list.size()) list.add(root.val);
        rightView(list, root.right, level + 1);
        rightView(list, root.left, level + 1);
    }
    // 另一种做法 复杂度比刚才大吧
    private void rightView(List<Integer> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) list.add(0);
        list.set(level, root.val);
        rightView(list, root.left, level + 1);
        rightView(list, root.right, level + 1);
    }
}