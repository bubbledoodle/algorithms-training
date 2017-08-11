// he set [1,2,3,…,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// 术 StringBuilder 大力出奇迹 String.valueOf(sb)
// 道 讲道理不算是一个Backtracking的题，涉及到的数学问题更多。



public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n];
        k -= 1;
        
        // A factorial lookup table
        int fact = 1;
        factorial[0] = 1;
        for(int i=1; i<n; i++){
            fact *= i;
            factorial[i] = fact;
        }
        
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        
        // find and remove
        for(int i=n-1; i>=0; i--){
            // index: k/(n-1)!  k/(n-2)! k/(n-3)! factorial lookup index decrease
            int index = k/factorial[i];
            // find the index, add it to final answer
            sb.append(String.valueOf(numbers.get(index)));
            // remove from the number array.
            numbers.remove(index);
            // update k
            k -= index*factorial[i];
        }
        
        return String.valueOf(sb);
    }
}