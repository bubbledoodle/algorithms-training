// Follow up for problem "Populating Next Right Pointers in Each Node".

// What if the given tree could be any binary tree? Would your previous solution still work?

// Note:

// You may only use constant extra space.
// For example,
// Given the following binary tree,
//          1
//        /  \
//       2    3
//      / \    \
//     4   5    7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \    \
//     4-> 5 -> 7 -> NULL

// 看都看了好久。。。 这道题朝着上次开始的方向想就对了，一会再写一个queue based level order traverse.

// Method 1 两层while分别在进行：外层：走root层有没有走到头
// 内层走child一直要走到链接玩。
// tricky part is: currentChild开始是tempChild的地址，进入内层loop第一个if满足的情况下会修改tempChild
// next的元素置为List的首元素，而后边的操作会让currentChild离开tempChild的绑定 从而在内层while走完之后赋值给
// root 滚动进入下一个level

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root != null){
                if(root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if(root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
        }
    }

    // Method 2 if(i == n - 1) continue; 比较通俗易懂
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        if (root == null) return;
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            TreeLinkNode node = q.poll();
            for (int i = 0; i < n; i++){
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                if(i == n - 1) continue;
                node.next = q.poll();
                node = node.next;
            }
        }
    }
}