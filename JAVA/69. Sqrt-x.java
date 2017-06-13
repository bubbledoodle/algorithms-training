// Implement int sqrt(int x).
public class Solution {
    public int mySqrt(int x) {
        if (0 == x) return 0;
        int left = 1, right = x/2 + 1, ans = 0;
        while(left <= right){
            int mid = (left + right)/2; // in case of overflow, you should not use this also
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

// 374. Guess Number Higher or Lower
// exactly same idea
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right - left)/2;
            int temp = guess(mid);
            if (temp == 0) return mid;
            else if (temp > 0) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
