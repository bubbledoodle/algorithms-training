// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

// 递归很好地解决了每一层递归 都有一个单独的height 压入堆栈。



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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }
    private void levelHelper(List<List<Integer>> list, TreeNode root, int height) {
        if (root == null) return;
        if (height >= list.size()) {
            list.add(new ArrayList<Integer>());
        }
        list.get(height).add(root.val);
        levelHelper(list, root.left, height + 1);
        levelHelper(list, root.right, height + 1);
    }
}