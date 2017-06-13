// Implement int sqrt(int x).
public class Solution {
    public int mySqrt(int x) {
        if (0 == x) return 0;
        int left = 1, right = x/2 + 1, ans = 0;
        while(left <= right){
            int mid = (left + right)/2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}

// why not multiplication? because it will over flow the int length
// left = mid + 1 && right = mid - 1, this preforms good.
// the while loop limit ans is right floored the sqrt(x)
