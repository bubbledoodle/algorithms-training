// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]

// 术： Method1. map.containsKey(key), defines List<String> t and ready to new one if not previously  exist one. t = res.get(map.get(key)); // ArrayList的方式去get by index
//     Method2. Arrays.sort(ca); String keyStr = String.valueOf(ca); map.get(keyStr).add(s);
// 道： 想法非常简单，都是找到在哪，然后放进去。不同的第一个method用了26个质数和乘积来做key 十分的聪明。第二种中规中矩每次把sort过的char array作为key



public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s: strs){
            int key = 1;
            for(char c: s.toCharArray()){
                key *= prime[c - 'a'];
            }
            List<String> t;
            if(map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }
    
    // Second version
    // public List<List<String>> groupAnagrams(String[] strs) {
    // if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
    //     Map<String, List<String>> map = new HashMap<String, List<String>>();
    //     for(String s: strs){
    //         char[] ca = s.toCharArray();
    //         Arrays.sort(ca);
    //         String keyStr = String.valueOf(ca);
    //         if(!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
    //         map.get(keyStr).add(s);
    //     }
    //     return new ArrayList<List<String>>(map.values());
    // }
}

