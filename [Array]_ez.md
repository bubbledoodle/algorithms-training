## 一题一句话
1. [414] 3rd maximum number: [New array] Maintain a new array. (causion about update condition.) 
2. [283] Move zeros: [inline op, 2 ptr] 有参考价值的：Two pointer trick(type1) ptr1-->need to return. ptr2-->oridinary iterator
3. [268] Missing Number: [search type1] Basic searching problem, binary search.
4. [219] Contains Duplicate ii: [search type2] HashMap. This is like few steps--> new HashMap --> (find --> compair) --> build HashMap
5. [217] Contains Duplicate: [search type1 or 2] HashMap. Can utilize the HashMap.szie()用长度对不上来search,像268 更快用HashMap, get and return
6. [169] Majority Element: [search type 2] typical HashMap.
7. [167] Two Sum: [search, type3] 有参考价值的：Two pointer trick(type2)一般在这种sorted，会一头一尾. Return type int[]
8. [119] pascal's triangle ii. [inline op, 2 ptr] 
9. [118] pascal's triangle. [new array] compair to 119, still 2 ptr, hence, the 2nd ptr++ is binded in 1 ~length - 1. return type. 


Not so trivial ones
1. [189] Rotate Array:
2. [122] Best time buy sell stock ii: not hard, tricky. For each loop uses only at need access i index array. 
3. [121] Best time buy sell stock: [Inline op, 2 ptr] Maintain return value. pointer1-->buy in. pointer2-->oridinary iterator.


[inline op] basically go to see if 2 ptr helps. Also the 2nd ptr start position, use from the side that won't be used as next update. i.e. [119]的递推公式里出现了j 项和j+1项，只好从后往前更新咯。


## Array methods
1. ArrayList get, set, add
2. List<List<type>> = new ArrayList<List<type>>();
