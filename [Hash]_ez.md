As always said, the algorithm testing is the combination of language usage and the algorithm. 

## 一题一句话
1. [500. Keyboard Row][HashMap type1: Index search] Indexing mapping. __FOCUS__ on string manipulation. Input: String List. Return 建立了List，add比较好用吧，然后res.toArray(new String[0]) 【need farther research on return value】
2, [463. Island Perimeter][General Hash] neighboor & blocks; neighboor will kill 2 length, while block commits to 4. A trick to avoid repetation is count neighboor from left up --> right bottom
3. [447. Number of Boomerangs][HashMap type2: appear] Appearance times的记录. 
4. [438. Find All Anagrams in a String][Sub-search --> slide window; Hash, without order: appear] by without order I mean: the order of char appears does not metter. 是HashMap appear type & General Hash 的结合体。 __utilize__ `int[256] //general unicode int[26] //alphabet`
5. [409. Longest Palindrome] [Hash, without order: appear] with uppercase and lowercase, maintain two int[]. care about return. 
6. 

## Hash & String Methods
### String Methods
1. String[] strs本质是一个由String组成的Array, strs[i]才可以使用一系列String Method
2. String Methods .toCharArray() .toUpperCase
### Hash Methods
1. for(int val : map.values()) // val           
2. map.clear()

## Hash Conventions
