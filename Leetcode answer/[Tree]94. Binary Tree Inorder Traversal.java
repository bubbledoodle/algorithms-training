// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree [1,null,2,3],
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].

// 两段论，因为想要maintain List<Integer>. inorder是先左，再root 再右


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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(res, root);
        return res;
        
    }
    private void traverse(List<Integer> list, TreeNode root){
        if(root != null){
            if(root.left != null){
                traverse(list, root.left);
            }
            
            list.add(root.val);
            
            if(root.right != null){
                traverse(list, root.right);
            }
        }
    }
}