As always said, the algorithm testing is the combination of language usage and the algorithm. 

## 一题一句话
1. [500. Keyboard Row][HashMap type1: Index search] Indexing mapping. __FOCUS__ on string manipulation. Input: String List. Return 建立了List，add比较好用吧，然后res.toArray(new String[0]) 【need farther research on return value】
2. [463. Island Perimeter][General Hash] neighboor & blocks; neighboor will kill 2 length, while block commits to 4. A trick to avoid repetation is count neighboor from left up --> right bottom
3. [447. Number of Boomerangs][HashMap type2: appear] Appearance times的记录. 
4. __[438. Find All Anagrams in a String]__[Sub-search --> slide window; Hash, without order: appear] by without order I mean: the order of char appears does not metter. 是HashMap appear type & General Hash 的结合体。 __utilize__ `int[256] //general unicode int[26] //alphabet`
5. [409. Longest Palindrome][General Hash, without order: appear] with uppercase and lowercase, maintain two int[]. care about return. 
6. [389. Find the Difference][Hash, 最粗暴] originally to record all appear times, however could use unicode sum and minus.
7. [349. & 350 Intersection of Two Arrays][HashSet or HashMap] need only 有没有 --> HashSet. need times --> HashMap. caution about __return__ type.
8. [290. Word Pattern][HashMap: type1: Index search] utilize split and equals method makes it much more easier.
9. [242. Valid Anagram] [General Hash, alphabet] `int[char -'a']`
10. [217 &219 Contains Duplicate] [HashSet & HashMap] two different stand for: is there any duplicate, where. map to index.
11. __[205. Isomorphic Strings]__ [General Hash inter two int[unicode]] the basic hash idea is the lock between two list.
12. [204. Count Primes][General Hash] not exactly count as hash but to maintain a boolean[] stand prime
13. [202. Happy Number][HashSet] basic need to know is those unhappy number always in loop, while to find the place to break the loop, is utilize HashSet
14. [136. Single Number] [trick to XOR all]
15. [1. Two Sum][inline op; HashMap, type1] need index, find key using containsKey()

## Hash & String Methods
### String Methods
1. String[] strs本质是一个由String组成的Array, strs[i]才可以使用一系列String Method
2. String Methods .toCharArray() .toUpperCase
3. String.split(' ') --> String[]
4. charAt(i)

### HashMap Methods
1. for(int val : map.values()) // val           
2. map.clear()
3. map.containsKsy() O(1)
4. map.containsValue() O(n)

### HashSet Methods
1. set.add()
2. set.clear()
3. set.contains()
4. set.isEmpty()
5. set.size()
6. set.remove()

## Hash Conventions
1. 好多string的题目
2. HashSet used for exist or not problem, while HashMap used for how many? where? 
3. General Hash, always not requires order. three types: (int[unicode]) (int[alphabet]) (int[] or whatever[], but the math mapping)
4. the Basic idea behind the Hash is function, or more in detail, dictionary. __Gather info we need in a new array.__ while some of them(questions) could utilize the primitive, others create the list your self, __and the mapping method, always create your self.__ In ez part, adding is most famous one. 
