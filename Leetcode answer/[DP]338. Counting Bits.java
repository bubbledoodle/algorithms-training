/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

*/

/*
 Some discussion is well narratived 
 https://discuss.leetcode.com/topic/40195/how-we-handle-this-question-on-interview-thinking-process-dp-solution
 the first idea come up with is find the pattern or rules for the result. Write few to check if see any pattern laies in. 

 Also the pattern behind this question is obvious. For so called offset is literally offset.
*/


public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int offset = 1;
        for (int i = 1; i< num + 1; i++) {
            if(offset * 2 == i) offset *= 2;
            res[i] = res[i - offset] + 1;
        }
        return res;
    }
}