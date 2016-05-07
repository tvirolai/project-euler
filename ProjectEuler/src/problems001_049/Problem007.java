/*
 * Project Euler (http://projecteuler.net) problem 7: 10001st prime
 * 
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see 
 * that the 6th prime is 13. 
 * What is the 10 001st prime number? 
 */

package problems001_049;

public class Problem007 {

    public void solve() {
        int target = 10002;
        int primes = 0;
        int i = 1;
        while (true) {
            if (isPrime(i)) {
                    primes++;
                    if (primes == target) {
                        System.out.println("Problem 7: " + i);
                        break;
                    }
                }
                i++;
            }
    }
    
    public boolean isPrime(long n) {
        if (n > 2 && (n & 1) == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) 
                return false;
        return true;
    }
    
}
