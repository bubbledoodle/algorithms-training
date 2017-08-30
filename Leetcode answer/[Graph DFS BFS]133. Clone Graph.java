// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


// OJ's undirected graph serialization:
// Nodes are labeled uniquely.

// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.

// The graph has a total of three nodes, and therefore contains three parts as separated by #.

// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
// Visually, the graph looks like the following:

//        1
//       / \
//      /   \
//     0 --- 2
//          / \
//          \_/

// 第一道接触的无向图问题，本来还觉得很简单
// 无向图包含两个部分：1. 自己的node号 label 2. neighbors作为一个存着无向图node类型的数据的List
// 无论DFS/BFS哪种方法 使用HashMap的作用在这里是：
//         在遍历的过程中，见到一个node不能次次都copy出一个新的来，这样copy来的neighbors List地址不一样 有毒
//         所以需要一个private的HashMap, key是label就可以


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {

    // DFS 详细说DFS。 DFS一定涉及到递归调用，helper function肯定用的着。
     // 出口是null， 也要判断HashMap里有没有曾经添加过，没有就说明见到了一个新的节点，做一个copy，加入到Map里
     // copy的具体方法呢 就是开辟一个新的存储空间：
     // UndirectedGraphNode copy = new UndirectedGraphNode(node.label)
     // 之后从原来的node.neighbors给copy节点添加neighbors 用.add 因为是一个List
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    private UndirectedGraphNode clone(UndirectedGraphNode node){
        if(node == null) return null;
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(copy.label, copy);
        for(UndirectedGraphNode neighbor : node.neighbors) {
            copy.neighbors.add(clone(neighbor));
        }
        return copy;
    }


    // BFS 惯用queue 这里用了queue来存储要访问的节点，而这个节点的存储就是按照广度来的。
    // 同样选取某个节点，也是map.get(original.label)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        map.put(res.label, res);
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            UndirectedGraphNode original = q.poll();
            for(UndirectedGraphNode neighbor: original.neighbors){
                if(!map.containsKey(neighbor.label)){
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    q.add(neighbor);
                }
                map.get(original.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return res;
    }
}