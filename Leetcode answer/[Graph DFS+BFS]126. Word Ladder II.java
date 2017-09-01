// Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

// Only one letter can be changed at a time
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// For example,

// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// Return
//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]

// Crazyyyyyyist one that ever had.
// 分离开了1). Use BFS to find the shortest distance between start and end, tracing the distance of crossing nodes from start node to end node, and store node's next level neighbors to HashMap;

// 2). Use DFS to output paths with the same distance as the shortest distance from distance HashMap: compare if the distance of the next level node equals the distance of the current node + 1.

// 怎么讲呢 里边分开了nodeNeighbors method把所有的点间的neighbors找到放在一个hashMap里
// BFS 把这个搜索树建立起来
// DFS在这个搜索树上搜索所有的答案并返回到res里

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet(wordList); 
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> tempList = new ArrayList<>();
        if (words.size() == 0) return res;
        
        words.add(beginWord);
        bfs(beginWord, endWord, words, nodeNeighbors, distance);
        dfs(beginWord, endWord, words, nodeNeighbors, distance, tempList, res);
        return res;
    }
    
    private void bfs(String start, String end, Set<String> words, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance){
        for(String str : words) nodeNeighbors.put(str, new ArrayList<String>());
        
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        distance.put(start, 0);
        
        while(!q.isEmpty()){
            int size = q.size();
            boolean foundEnd = false;
            for(int i = 0; i < size; i++){
                String word = q.poll();
                int curDistance = distance.get(word);
                ArrayList<String> neighbors = getNeighbors(word, words);
                for(String neighbor : neighbors){
                    nodeNeighbors.get(word).add(neighbor);
                    if(!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if(end.equals(neighbor))
                            foundEnd = true;
                        else
                            q.offer(neighbor);
                    }
                }
            }
            if(foundEnd)
                break;
        }      
    }
    
    private ArrayList<String> getNeighbors(String node, Set<String> words){
        ArrayList<String> res = new ArrayList<>();
        char[] chars = node.toCharArray();
        
        for(int i = 0; i < chars.length; i++){
            for(char c = 'a'; c <= 'z'; c++){
                char oldCh = chars[i];
                chars[i] = c;
                String newWord = new String(chars);
                if(words.contains(newWord)) {
                    res.add(newWord);
                }
                chars[i] = oldCh;
            }
        }
        return res;
    }
    
    private void dfs(String cur, String end, Set<String> words, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> tempList, List<List<String>> res){
        tempList.add(cur);
        if(end.equals(cur)) {
            res.add(new ArrayList<String>(tempList));
        } else {
            for(String next : nodeNeighbors.get(cur)) {
                if(distance.get(next) == distance.get(cur) + 1){
                    dfs(next, end, words, nodeNeighbors, distance, tempList, res);
                }
            }
        } 
        tempList.remove(tempList.size() - 1);
    }
}