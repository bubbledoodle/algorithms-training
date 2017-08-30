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
// 利用了list.get 这个方法access



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
    // DFS method
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

    // BFS method BFS的方法复杂度类似 但是速度慢一些，可能差别在stack和queue上
    // 这里选用queue的原因是：FIFO，你希望先添加进去的TreeNode先出来，在while不是空的大条件下
    // 出空queue：这个出queue的时候其实就已经把level内的所有新节点都放进queue后端，等待下次循环
    
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode currRoot = q.poll();
                tempList.add(currRoot.val);
                if(currRoot.left != null){
                    q.add(currRoot.left);
                }
                if(currRoot.right != null){
                    q.add(currRoot.right);
                }
            }
            res.add(tempList);
        }
        return res;
    }
}