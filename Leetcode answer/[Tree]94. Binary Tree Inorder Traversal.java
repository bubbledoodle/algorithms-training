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

    // method 2
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));
        return res;
    }
    
    // method 3 和preorder的不太一样，preorder很明显的体现了先压进栈的后出来。
    // 这里一直要走到左侧子树头，pop一个然后添加右侧。如果右侧没有接着pop左边的
    // 思考的时候可以想画一个树，看如果去人为入栈结果是怎样的，按照这个逻辑来写代码：
    // 这样，1. to the left most 2. pop one and add to res 即最左叶子节点一定是作为root添加进res的3. point to it right 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> toVisit = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null || !toVisit.empty()){
            while(cur!=null){
                toVisit.add(cur);
                cur = cur.left;
            }
            cur = toVisit.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

}