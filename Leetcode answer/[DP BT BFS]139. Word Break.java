// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

// UPDATE (2017/1/4):
// The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

// 看解释 别说话

class Solution {
    // backtracking with memo, where memo is used to store from current index as start to the end boolean existance judge.
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        words.addAll(wordDict);
        
        return backtrack(s, words, 0, new Boolean[s.length()]);
    }
    private boolean backtrack(String s, Set<String> words, int start, Boolean[] memo){
        if(start == s.length()) return true;
        if(memo[start] != null) return memo[start];
        for(int end = start + 1; end <= s.length(); end++){
            if(words.contains(s.substring(start, end)) && backtrack(s, words, end, memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }
    
    // 针对当前start 所有可能的BFS tree is built and pushed into queue. next iteration (while is the case) will poll one element and trates it as the new start. Why not end + 1? substring method. 
    // so queue pattern: 1. new a queue outside the while loop. push the start into it as initial element. 
    //                   2. while loop as outer loop. pop one to processing each time. the processing actually will add new element to the queue
    //                   3. some condition to go inner loop and construct inner loop, where adding elements to queue happens here.
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet(wordDict);
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[s.length()];
        q.add(0);
        while(!q.isEmpty()) {
            int start = q.poll();
            if(visited[start] == 0){
                for(int end = start + 1; end <= s.length(); end++){
                    if(words.contains(s.substring(start, end))){
                        q.add(end);
                        if(end == s.length()) return true;
                    }
                }
            }
            visited[start] = 1;
        }
        return false;
    }
}