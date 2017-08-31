// Design and implement a TwoSum class. It should support the following operations: add and find.

// add - Add the number to an internal data structure.
// find - Find if there exists any pair of numbers which sum is equal to the value.

// For example,
// add(1); add(3); add(5);
// find(4) -> true
// find(7) -> false


// 这个写的十分直白，list存正经东西，map存出现了几次。
// 其实可以想办法把list换掉的

class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    private List<Integer> list = new ArrayList<>();
    /** Initialize your data structure here. */
    public TwoSum() {
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)) map.put(number, map.get(number) + 1);
        else{
            map.put(number, 1);
            list.add(number);
        }
        
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i = 0; i < list.size(); i++){
            int num1 = list.get(i), num2 = value - num1;
            if((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */