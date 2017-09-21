/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

/*
 #Hash, #Two pointer, #String
 1. 好久不做hash生疏了
 2. 选用Set是并不需要map到别的东西
 3. 拉锯一样，扯到当前最长substring
*/

// 与其用set 不如用HashMap去直接存储每个元素出现的index 然后进行sliding window的跳跃滑窗


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int res = 0, max = 0, j = 0, i = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max++;
                if(max > res) res = max;
            }
            else {
                max--;
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, res = 0;
        for(int j = 0, i = 0; j < s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)) + 1, i);  // 对于abba这种 要保证始终会往后走 所以要进行一个比较
                // 防止在a重合以后left又被退火回到第一个b处。
            }
            System.out.println("i = " + i + "max = " + max);
            map.put(s.charAt(j), j);
            max = j - i + 1;
            if(max > res) res = max;
        }
        return res;
    }
}

