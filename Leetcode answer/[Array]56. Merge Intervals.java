// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

// Q 
// 1. lambda expression 这里有class Interval 的定义，问但是interval instance的sort是指？ Integer.compare返回的是一个-1 0 1
// 2. get()这个method是从哪里来的？
// 学到了的
// 3. 还是写语言上的东西 添加时候先要instantiate, 拿到一个新的class先看什么一个构成。
// 4. 这道题的算法很简单，只是去把所有的start点排序，然后按照end的重叠与否决定添加

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // any object instance that is not built in should use .size()
        if (intervals.size() <= 1) return intervals; 
        // lambda expression question!
        List<Interval> res = new LinkedList<Interval>();
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start)); 
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval interval : intervals){
            if(interval.start <= end){
                end = Math.max(end, interval.end);
            }else{
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }   
}