// Given inorder and postorder traversal of a tree, construct the binary tree.

// 基本上和给定pre in求解BT相同。依旧没用使用hash的方法

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if(postEnd < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for(int i = inIndex; i <= inEnd; i++){
            if(root.val == inorder[i]) inIndex = i;
        }
        
        root.left = helper(postEnd - inEnd + inIndex - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = helper(postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;
    }
}