/*
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
*/

// Math.pow;
// find the maximum number, here as the leftmost, can also use second solution:

public class Solution {
    public int findComplement(int num) {
        int leftmost = 0, temp = num, i = 0;
        while(temp!=0) {
            leftmost += Math.pow(2,i);
            temp = temp>>>1;
            i++;
        }
        return num^leftmost;
    }
}

/*
public int findComplement(int num) 
    {
        int i = 0;
        int j = 0;
        
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        
        return i - num;
    }
 */
