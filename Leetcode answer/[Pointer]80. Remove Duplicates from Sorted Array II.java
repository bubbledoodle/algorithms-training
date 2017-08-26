// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

// 题意：remove dup can leave a bit dup.
// 操作返回array，nums[res]是要管好的，就好像你收拾东西搬家，考虑好要的东西，其他都是不要的。又像是在包饺子
// 两种方法都用到了这样的思想，不同的是第二种方法利用了sorted这个条件，因为是一个increased array，两个以后务必变大，否则就不给它变了


class Solution {
    // Method 6ms hashMap 
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(res == 0 || !map.containsKey(nums[i])){
                map.put(nums[i], 1);
                nums[res++] = nums[i];
            } else if (map.get(nums[i]) == 1) {
                nums[res++] = nums[i];
                map.put(nums[i], 0);
            } 
        }
        return res;
    }
    
    // Method utilized sorted and inline changing
    public int removeDuplicates(int[] nums) {
       int i = 0;
       for (int n : nums)
          if (i < 2 || n > nums[i - 2])
             nums[i++] = n;
       return i;
    }
}