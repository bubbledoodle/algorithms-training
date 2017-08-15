## 一题一句话
1. [414] 3rd maximum number: [New array] Maintain a new array. (causion about update condition.) 
2. [283] Move zeros: [inline op, 2 ptr] 有参考价值的：Two pointer trick(type1) ptr1-->need to return. ptr2-->oridinary iterator
3. [268] Missing Number: [search type1] Basic searching problem, binary search.
4. [219] Contains Duplicate ii: [search type2] HashMap. This is like few steps--> new HashMap --> (find --> compare) --> build HashMap
5. [217] Contains Duplicate: [search type1 or 2] HashMap. Can utilize the HashMap.szie()用长度对不上来search,像268 更快用HashMap, get and return
6. [169] Majority Element: [search type 2] typical HashMap.
7. [167] Two Sum ii: [search, sorted, type3] 有参考价值的：Two pointer trick(type2)一般在这种sorted，会一头一尾. return new int[]{left + 1, right + 1}
8. [119] pascal's triangle ii. [inline op, 2 ptr] 
9. [118] pascal's triangle. [new array] compare to 119, still 2 ptr, hence, the 2nd ptr++ is binded in 1 ~length - 1. return type.
10. [88] merge sorted array. [inline op, 2 ptr method] nums1[i--]这种写法
11. [66] plus one. [inline, with bit like op] logic matters, 模仿十进制
12. [35] search for insert position: [search, type1] causion about edge condition, ordinary binary edges.
13. [27] remove element: [inline op, 2 ptr] 一开始看查重想到hash，但是显然是个same array, 2 ptr 不管不顾的问题
14. [26] Remove Duplicates from Sorted Array:[inline op, sorted]跳过0index的一个方法`res == 0 || nums[i] != nums[i-1]`,效用sorted here is to compare near elements.
15. [1] two sum: [search type 2].


Not so trivial ones
1. [189] Rotate Array:
2. [122] Best time buy sell stock ii: not hard, tricky. For each loop uses only at need access i index array. 
3. [121] Best time buy sell stock: [Inline op, 2 ptr] Maintain return value. pointer1-->buy in. pointer2-->oridinary iterator.
4. [53] Maximum subarray: [greedy] is really beautiful one to this. [inline op] however greedy here track on three things, the current sum over [0~i], the min, and the result. The result is for update condition. Note there is also divide & conquer way. 


## Array methods
1. ArrayList get(), set()
2. List<List<type>> = new ArrayList<List<type>>();
3. if (nums == null || nums.length == 0) return 0;
4. null only work for Integer
5. List add()


## Array conventions
1. [search type 1] binary search, sorted given. 
2. [search type 2] HashMap
3. [inline op] basically go to see if 2 ptr helps. Also the 2nd ptr start position, use from the side that won't be used as next update. i.e. [119]的递推公式里出现了j 项和j+1项，只好从后往前更新咯。
