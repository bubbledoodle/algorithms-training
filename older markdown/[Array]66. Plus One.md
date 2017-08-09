## Question
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.


## Code
```JAVA
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for(int i = n-1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        // if this happens, meaning all previous are zeros.
        int[] newDigits = new int [n+1]; 
        newDigits[0] = 1;
        return newDigits;
    }
}
```

## Thinkings
1. JAVA array methods
2. the thinking pipeline. No more like too ditailed edge conditions. ez one but actually takes lots of time
