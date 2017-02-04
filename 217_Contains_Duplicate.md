## Question
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

## Code

```Java
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> numHash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numHash.get(nums[i]) == null) {
                numHash.put(nums[i], i);
            }
        }
        return (nums.length != numHash.size());
    }
}
```

## thinkings

This is the vary first Leetcode finished by my self. Though very slow. The idea of contains duplicate is through hash, always. Through somebody gotta write it in other ways. Search it online and find more interesting result.

caution for return value is boolean. Below uses HashSet. which contains __contains(var)__ method and add(var) method. good!

```Java 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i ++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }    
        return false;
    }
}
```
