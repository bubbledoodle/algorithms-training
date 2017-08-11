// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

// 道：看输入s 有数字比较 substring() Integer.parseInt(s) 
// 分段 count计数， idx记位
// backtracking一次 要pushing to next level, 所以在进入之前有进入checking，是skipping条件：>256 或者 startWith 0 且有除了0之外的长度：因为后续的backtracking会与之重复

// 术： prefix + s + (count==3? "" : ".")

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtracking(res, s, "", 0, 0);
        return res;
    }
    
    private void backtracking(List<String> list, String ip, String prefix, int count, int idx){
        if(count > 4) return;
        if(count == 4 && idx == ip.length()) list.add(prefix);// validation check
        
        for(int i = 1; i < 4; i++){
            if(idx+i > ip.length()) break;
            String s = ip.substring(idx, idx+i);
            if((s.startsWith("0") && s.length()>1) || (Integer.parseInt(s) >= 256)) continue;//entering checking
            backtracking(list, ip, prefix + s + (count==3? "" : "."), count + 1, idx + i);
        }
    }
}