// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// For example,

// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.

// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// UPDATE (2017/1/20):
// The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.


// Queue 与 BFS 结合的再一典范。
// 更新以后多了一句words.addAll(wordList)

// Queue在BFS里到底有什么用？存放要visit的东西，就好像checklist一样，先扔进去的先读出来。
// 这里分析一下得有这两层循环：当前单词word的按位读；按位之后的a-z的循环比对 操作；
// 外一层：在当前queue.size()范围循环。为什么呢？每次queue加的东西是当前单词可以reached到的所有单词。为了复用queue，规定了一些size定标来跳出循环，加level
// 最外层当然是queue如果出到空还没有找到最后单词，可以返回0了


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        
        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                String word = q.poll();
                for(int j = 0; j < word.length(); j++){
                    char[] chars = word.toCharArray();
                    
                    for(char c = 'a'; c <= 'z'; c++){
                        chars[j] = c;
                        String newWord = new String(chars);
                        if(words.contains(newWord)){
                            if(newWord.equals(endWord)) return res + 1;
                            else if(reached.add(newWord))
                                q.add(newWord);
                        } 
                    }
                }
            }
            res++;
        }
        return 0;
    }
}