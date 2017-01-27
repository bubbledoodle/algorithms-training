## Philosophy
一段程序调用自身的coding策略，大道至简。递归思维与常规思维相逆，通常都从上而下思考， 而递归趋从下往上思考。重点在于每一层递归的出口。

## 递归的注意点

1. 每次调用在规模上减半
2. 一般前一次的输出作为后一次的输入
3. 递归的入口条件一般就是规模，规模小到一定不再递归。符合divide & conquer要求。
4. 每一次调用 产生的变量都是局部变量，用栈来存储。所以可能导致栈溢出。

实际体验几个例子，前一个条件就是递归的出口，也就是最后一次调用函数需要满足的条件。著名的例子：

斐波纳契数列(Fibonacci Sequence)，最开始用于描述兔子生长的数目时用上了这数列。从数学上，费波那契数列是以递归的方法来定义：

```C
int Fibonacci(int n){
    if (n <= 1)  
        return n;  
    else  
        return Fibonacci(n-1) + Fibonacci(n-2);  
}
```

## inductive defination
有些数据结构本身就是自身调用，比如link list，比如tree

## tail call 尾部调用  [confused]
这是一类递归深度和栈大小没有关系的递归方式。external link: !(IBM Recursion Training)[http://www.ibm.com/developerworks/linux/library/l-recurs/index.html]
