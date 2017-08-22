##扒一扒递归

### recursive function
1. Defination: function calls itself, basically devide & conquer
2. Features: ___two branches___, if else statement. One calls itself as __recursive__, the other serves as __base case__
3. Types: Mutual recursive, that `f()`  calls `g()` and `g()` calls `f()`; tail recursive (more in detail in following section)
4. Pros: "neat" and compact to write and confident code; 
5. Cons: sometime increases storage complexity, stack. Stacks nowadays are like few MBs, allowing recursive go fairly deep with causing __core dump__. _1000_ times should be fine.
6. How it works: Each function call causes some memory to be __pushed on a stack__. Once the call is done, that memory is popped off the stack, and the flow of control goes back to the function that made the call.
6. Place to use: Trees and some of the sorting algo
7. When: you must be able to __use the solutions__ of the small problem to help solve the larger one.


-
### Types & Usage Situation
#### tail recursive
Definition: none of the recursive call do additional work after the recursive call is complete:
 
```(JAVA)
return recFunc( x, y ) ;    // tail

return recFunc( x, y ) + 3; // non-tail
```
Feature: often tail recursive __need additional parameter__ to pass values, while non can __relay on operations__ which effects the return value.

-
### Steps

```
int sum( int arr[], int n )
{
  if ( n == 0 )  // base case
    return 0 ;   // no recursive call
  else
    {
      int small = sum( arr, n - 1 ) ; // solve smaller problem No.4
      return small + arr[ n - 1 ] ; // use solution of smaller to solve larger No.5
    }
}
```

1. Write a prototype for the recursive function.
2. Write a comment that describes what the function does.
3. Determine the base case (maybe >= 1), and its solution(s).
4. Determine what smaller problem (or problems) to solve. 
5. Use the solutions of the smaller problem to solve the larger problem.

-
### Base Case
important, to repeat it again.

-
### Helper Function
Recursive functions __rely heavily on parameters__ and return values of functions to do their work

i.e. the prototpye vs. helper function.

```
void print() ;
void printRec( Node * curr ) ; // helper

```

Common Mistake: to use the EXACT SAME PROTOTYPE, meaning the helper func and prototype have the same parameter.

Converting for loop to recursion: don't use post-increment or post-decrement