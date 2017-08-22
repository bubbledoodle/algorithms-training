// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

// 感觉还是一道backtracking的题目。逃逸条件和pathSum第一题相似都是 叶子节点，sum正好用完。添加答案以后去掉当前添加的最后一个数以便backtracking。分两步分remove是为了直接return。


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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        suming(res, new ArrayList<>(), root, sum);
        return res;
    }
    private void suming(List<List<Integer>> list, List<Integer> tempList, TreeNode root, int sum) {
        if(root == null) return;
        tempList.add(new Integer(root.val));
        if(root.left == null && root.right == null && sum == root.val){
            list.add(new ArrayList(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        } else {
            suming(list, tempList, root.left, sum - root.val);
            suming(list, tempList, root.right, sum - root.val);
        }
        tempList.remove(tempList.size() - 1);
    }
}