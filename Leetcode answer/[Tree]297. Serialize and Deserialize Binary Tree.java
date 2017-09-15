// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// For example, you may serialize the following tree

//     1
//    / \
//   2   3
//      / \
//     4   5
// as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

// 几个特殊用法的methods：
// StringBuilder res = new StringBuilder();
// res.append(node.val + ", ");
// res.toString();

// 想到抓取页面以后的数据提取split()
// String[] value = data.split(", ");
// if(!value[i].equals("n"))
// Integer.parseInt(value[i])

// BST Queue Based 逻辑很简单

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("n, ");
                continue;
            }
            q.offer(node.left);
            q.offer(node.right);
            res.append(node.val + ", ");
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] value = data.split(", ");
        TreeNode root = new TreeNode(Integer.parseInt(value[0]));
        q.offer(root);
        for(int i = 1; i < value.length; i++){
            TreeNode parent = q.poll();
            if(!value[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(value[i]));
                parent.left = left;
                q.add(left);
            }
            if(!value[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(value[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));