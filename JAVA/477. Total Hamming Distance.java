/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Now your job is to find the total Hamming distance between all pairs of the given numbers.

## Thinkings:
Situation 1. If the 2 number in a pair both comes from M (or N), the total will get 0.
Situation 2. If the 1 number in a pair comes from M, the other comes from N, the total will get 1.

Since Situation 1 will add NOTHING to the total, we only need to think about Situation 2
How many pairs are there in Situation 2?
We choose 1 number from M (p possibilities), and 1 number from N (q possibilities). The total possibilities is p × q = pq

The best thinking in the second method is it looks at a bit for all of the element in that array at one time.
*/

/* ...O(n^2)
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i<n; i++){
            for (int j = i+1; j<n; j++){
                int num = nums[i]^nums[j];
                while(num!=0){
                    res += num&1;
                    num = num>>>1;
                }
            }
        }
        return res;
    }
}

Try below  ;-) That gives O(n)
*/

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i<32; i++) {
            int bitcount = 0;
            for (int j = 0; j<n; j++){
            bitcount += (nums[j] >> i) & 1;
            }
            res += bitcount * (n - bitcount);
        }
        return res;
    }
}
