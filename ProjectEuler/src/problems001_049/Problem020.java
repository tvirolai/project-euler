/*
 * Project Euler (http://projecteuler.net) problem 20: Factorial digit sum
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the 
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 */

package problems001_049;

import java.math.BigInteger;


public class Problem020 {
    
    public void solve() {
        int numberSum = 0;
        String factorial = "" + fact(100);
        for (int i = 0; i < factorial.length(); i++) {
            numberSum += Character.getNumericValue(factorial.charAt(i));
        }
        System.out.println("Problem 20: " + numberSum);
    }
    
    private static BigInteger fact(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }
    
}
