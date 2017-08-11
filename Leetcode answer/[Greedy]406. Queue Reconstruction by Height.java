/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

/*
 @.@ 不好做啊
 思路就是观察这个排序，两步走：整体队列最前边的一定第二位是0，第一位是所有是零里边最小的
 去掉这个之后考虑剩余的：比他高的 第二位不需要减，比他低的都要减
 ---> coding
 但是依然不好码:
        1. Arrays.copyOf 为什么用copy呢，你在people上乱动，结果是要输出到res里边的
        2. 为什么要一个k---> well defined flag 在所有第二位是零的里边寻找最小位，然而不能直接初始化成某一个people,会混进来min但不是0的情况
        3. O(n^2)
*/


public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] res = new int[n][];
        int[][] copy = new int[n][];
        
        for(int i=0; i<n; i++) copy[i] = Arrays.copyOf(people[i], 2);
        for(int i=0; i<n; i++) {
            int k = -1;
            for(int j=0; j<n; j++) {
                if(copy[j][1] == 0 && (k==-1 || copy[j][0] < copy[k][0])) k = j;
            }
            res[i] = people[k];
            for(int j=0; j<n; j++) {
                if(copy[j][0] <= copy[k][0]) copy[j][1]--;
            }
        }
        return res;
    }
}