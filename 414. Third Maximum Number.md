## Question

## Code
```JAVA
/*public class Solution {
    public int thirdMax(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i< nums.length; i++){//update only if nums[i]never shown in the abc.
            if(nums[i]>a) {
                c = b;
                b = a;
                a = nums[i];
                count++;
            } else if(nums[i]!=a && nums[i]>=b) {
                c = b;
                b = nums[i];
                count ++;
            } else if(nums[i]!=a && nums[i]!=b && nums[i]>=c) { 
                c = nums[i];
                count++;
            }
            System.out.printf("a=%d,b=%d,c=%d\n",a,b,c);
        }
        if (count>=3) return c;
        else return a;
    }*/
public class Solution {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
```

## Thinking
复制了两段代码，有种日了🐶的感觉。JAVA相较于python对于null的限制是这道题恶心的地方 1. Integer 才有null。 2. null不能和正常的数字比大小。
so 每次见到null，要有一个是不是等于null的判断让没有赋值的数掉进这个if statement里。 

另外来说，也不能一串赋值 所有的这些导致了代码长了好多倍。
喜欢的写法 for each loop: for (Integer x : nums)
         marco: return max3 == null ? max1: max3;
