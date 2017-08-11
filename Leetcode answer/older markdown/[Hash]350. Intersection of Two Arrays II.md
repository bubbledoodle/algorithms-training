## Question
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

## Code
```JAVA
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> resList = new ArrayList<Integer>();
        int n1 = nums1.length, n2 = nums2.length;
        
        for (int i=0; i<n1; i++) {
            if (map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i],1);
        }
        
        for (int i=0; i<n2; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
                resList.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int res[] = new int[resList.size()];
        for(int i=0;i<resList.size();i++) res[i]=resList.get(i);
        return res;
    }
}
```

ez HashMap
