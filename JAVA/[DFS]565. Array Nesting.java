/*
A zero-indexed array A consisting of N different integers is given. The array contains all integers in the range [0, N - 1].

Sets S[K] for 0 <= K < N are defined as follows:

S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

Sets S[K] are finite for each K and should NOT contain duplicates.

Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
*/



/*
    1. brute force: casues time limit exceeded.

    2. need a marker, say visited. The intuition behind this is if one element in the set is visited,  all other later comers will form a equal or less set.

    3. So the idea of either remove the element or mark it as visited.

    4. the way second answer did is to write a inner loop, maintain an int ak and iterate until visited point find. for (int k = i; a[k] >= 0; size++) interesting formmating of for loop. 
    size get cleared every outer loop, which is equal as your set.clear()
*/

public class Solution {
    /* // exceed time limit
    public int arrayNesting(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        
        for (int i=0; i<n; i++) {
            if(nums[i] < 0) continue;
            set.add(i);
            nesting(nums, set, nums[i]);
            if (res < set.size()) res = set.size();
            set.clear();
        }
        return res;
    }
    
    private void nesting(int[] nums, Set<Integer> set, int elem) {
        if(set.contains(elem)) return;
        else {
            set.add(elem);
            nesting(nums, set, nums[elem]);
        }
    }
    */
    
    public int arrayNesting(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}