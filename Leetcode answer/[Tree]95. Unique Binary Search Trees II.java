// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3


// 和之前的一道相比 就是要把所有组成的树都返回。难在这次要操作的是一个List<TreeNode>[] 返回的是一个List<TreeNode> 
// 开篇都一样 用得着List之前的树结构 所以要保证存储在一个List里。初始化。
// traversal部分 和之前一样的理念选定了root之后按照相似结构来合成，需要访问到res[root] & res[level - root] 并且修改右侧子树的值，设计一个clone私有方法
// clone done nothing but to access n.val and process a plus
// Then add res to list. 

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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n + 1];
        res[0] = new ArrayList<TreeNode>();
        if(n == 0) return res[0];
        res[0].add(null);
        
        for(int level = 1; level <= n; level++){
            res[level] = new ArrayList<TreeNode>();
            for(int root = 0; root < level; root++){
                for(TreeNode nodeL : res[root]){
                    for(TreeNode nodeR : res[level - root - 1]){
                        TreeNode node = new TreeNode(root + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, root + 1);
                        res[level].add(node);
                    }
                }
            }
        }
        return res[n];
    }
    
    private static TreeNode clone(TreeNode n, int offset){
        if(n == null){
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}