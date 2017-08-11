/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

## Thinkings
1. Ordinary binary search problems. Model: 00000011111111 find the first 1
2. Notice the mid = left + (right - left) / 2 way of prevent overflow. 
3. make sure the logic works: the update only happes at 1 found. 

*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int right = n, left = 0, res = n;
        while(left<=right){
            int mid = left + (right - left) / 2;
        if(isBadVersion(mid)==true) {
            if(mid < res) res = mid;
            right = mid - 1;
        }
        else left = mid + 1;
        }
        return res;
    }
}

/* Or save a bit of spaces. 
public int firstBadVersion(int n) {
    int start = 1, end = n;
    while (start < end) {
        int mid = start + (end-start) / 2;
        if (!isBadVersion(mid)) start = mid + 1;
        else end = mid;            
    }        
    return start;
}
*/
