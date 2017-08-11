/*
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
*/


/*
 @.@ nice to review on String method.
 1. split("\\+") using + to split into Sting array
 2. force type change Integer.valueOf(str)
 3. indexOf('c') first occurence of some char
 4. substring(index1, index2) to get the substring of original string.
 5. return directly + + +

 the idea is essentially ez
*/


public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] valA = getValue(a);
        int[] valB = getValue(b);
        
        int real = valA[0] * valB[0] - valA[1] * valB[1];
        int img = valA[0] * valB[1] + valA[1] * valB[0];
        
        return real + "+" + img + "i";
        
    }
    public int[] getValue(String s) {
        String[] str = s.split("\\+");
        int[] val = new int[2];
        val[0] = Integer.valueOf(str[0]);
        int img = str[1].indexOf("i");
        val[1] = Integer.valueOf(str[1].substring(0, img));
        
        return val;
    }
}