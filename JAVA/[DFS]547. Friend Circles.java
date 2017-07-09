/*
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
*/

/*
 1.interesting 朋友的朋友也是我的朋友
 2.dfs一定会出现。dfs就是走的不能走了再撤摊。这里dfs作用效果体现在visited数列上
 3.count在每次dfs以后一定会++ 因为不管是dfs走一步还是几步，都要有一次marking
 4.这是一道二维的dfs
*/





public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j<M.length; j++) {
            if(M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    
    }
    public int findCircleNum(int[][] M) {
        int count = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i< M.length; i++) {
            if(visited[i] == 0) {
                dfs(M, visited, i);
                count++; // add count anyway.
            }
        }
        return count;
    }
}