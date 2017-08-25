// Given preorder and inorder traversal of a tree, construct the binary tree.

// 观察发现 preorder的第一个元素是root，找到inorder中的这个元素，左边都是left 右边都是right
// 左边的root是preorder紧接着的元素，右边的是从inorder数到所有左边的结束了 在preorder中查找到

// 保持 preStart inStart inEnd这三个量
// O(NlogN) ~ O(N^2)
// 但是用hashtable来查找保证了constant time searching---> O(N)

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i = inIndex; i <= inEnd; i++){
            if(inorder[i] == root.val)
                inIndex = i;
        }
        
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        // preStart + inIndex - inStart + 1：因为preorder中，只有所有left都写完了才会第一个写右子树的root
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}