/*
 * Project Euler (http://projecteuler.net) problem 10: Summation of primes
 * 
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

package problems001_049;


public class Problem010 {
    
    public void solve() {
        long result = 0;
        int i = 2;
        while (i < 2000000) {
            if (isPrime(i)) {
                result += i;
            }
            i++;
        }
        System.out.println(result);
        
    }
    
    public boolean isPrime(int n) {
        if (n > 2 && (n & 1) == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) 
                return false;
        return true;
    }

}
