## Question
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.

## Code
```JAVA
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        List<Integer> resList = new ArrayList<Integer>();
        int n1 = nums1.length, n2 = nums2.length;
        for (int i=0; i<n1; i++) {
            if (set.contains(nums1[i])) continue;
            else set.add(nums1[i]);
        }
        for (int i=0; i<n2; i++) {
            if (set.contains(nums2[i])) {
                resList.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int res[] = new int[resList.size()];
        for(int i=0;i<resList.size();i++) res[i]=resList.get(i);
        return res;
    }
}
```

## Thinkings
主要是些JAVA的basic
1. HashSet 建立 method 
> boolean add(Element e): It adds the element e to the list.
> 
> void clear(): It removes all the elements from the list.
>
> Object clone(): This method returns a shallow copy of the HashSet.
> 
> boolean contains(Object o): It checks whether the specified Object o is present in the list or not. If the object has been > found it returns true else false.
> 
> boolean isEmpty(): Returns true if there is no element present in the Set.
>
> int size(): It gives the number of elements of a Set.
>
> boolean remove(Object o): It removes the specified Object o from the Set.

2. 关于List ArrayList 这俩有待考证
3. int[] return has to convert List to int[], which is like pain in the ass.
4. The only thing to remind about this question is to remove the element from the set after add to resList.

