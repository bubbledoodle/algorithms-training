## Question
Count the number of prime numbers less than a non-negative number, n.
## Code
```JAVA
public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count=0;
        for (int i=2; i<n; i++) {
            if(notPrime[i]==false){
                count++;
                for(int j=2; i*j<n; j++) notPrime[i*j]=true;
            }
        }
        return count;
    }
}
```

## Thinking
Sieve of Eratosthenes. nice and elegant solution.
JAVA: instance variable and array components are given default values, while the local variables, ya have to initialize them.
