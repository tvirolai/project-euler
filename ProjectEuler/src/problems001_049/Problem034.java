/**
 * Project Euler (http://projecteuler.net) problem 34: Digit factorials
 *
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of 
 * their digits. 
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

package problems001_049;

import projecteuler.domain.Problem;

public class Problem034 extends Problem {

    @Override
    public void solve() {
        long i = 3L;
        long res = 0L;
        while (i < 100000) {
            if (sumOfFactorialOfDigits(i) == i) {
                res += i;
            } 
            i++;
        }
        System.out.println("Problem 34: " + res);
    }
    
    private long sumOfFactorialOfDigits(long n) { 
        return methods.digitsToArrayList(n)
                .stream()
                .map((x) -> methods.factorial(x))
                .reduce(0L, Long::sum);
    }

}
