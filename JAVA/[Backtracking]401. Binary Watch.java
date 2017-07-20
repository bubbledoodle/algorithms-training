/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
*/

/*
    1. classic permutation boil down to 3 parts: 
                            select number of bit in different position
                            permutation of each part
                            combine & convert to strings

    2. way of convert: res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
    3. permutation: in order to make it easy to understand, introducted a helper function
       which together with the toDigit function perform as regulation permutation problem. 
       maintain variavles: i.   answer list; 
                           ii.  nums list;
                           iii. max bit;
                           iv.  current sum;
                           v.   cur pos;


*/


public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        
        for(int i=0; i<=num; i++) {
            List<Integer> list1 = backtrack(nums1, i);
            List<Integer> list2 = backtrack(nums2, num - i);
            
            for(int num1 : list1) {
                if(num1 >= 12) continue;
                for(int num2 : list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
            
        }
        return res;
    }
    
    private List<Integer> backtrack(int[] nums, int max) {
        List<Integer> res = new ArrayList<Integer>();
        helper(res, nums, max, 0, 0);
        return res;
    }
    
    private void helper(List<Integer> res, int[] nums, int max, int sum, int pos) {
        if(max == 0) {
            res.add(sum);
            return;
        }
        for(int i=pos; i< nums.length; i++) {
            helper(res, nums, max-1, sum+nums[i], i+1);
        }
    }
}