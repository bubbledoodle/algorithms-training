// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.

// 其实用个hashMap也可以 为什么256呢 ascii是不是就是256个长度

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.equals("")) return -1;
        char[] c = s.toCharArray();
        int[] cnt = new int[256];
        for(int i = 0; i < c.length; i++){
            cnt[c[i]]++;
        }
        for(int i = 0; i < c.length; i++){
            if(cnt[c[i]] == 1) return i;
        }
        return -1;
    }
}