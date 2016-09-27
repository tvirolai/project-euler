/**
 * Project Euler (http://projecteuler.net) problem 27: Quadratic primes
 * 
 * Euler discovered the remarkable quadratic formula:
 * 
 * n^2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive 
 * integer values 0≤n≤390≤n≤39. However, when n=40,402+40+41=40(40+1)+41n=40,
 * 402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,
 * 412+41+41n=41,412+41+41 is clearly divisible by 41.
 * 
 * The incredible formula n2−79n+1601n2−79n+1601 was discovered, which produces 
 * 80 primes for the consecutive values 0≤n≤790≤n≤79. The product of the 
 * coefficients, −79 and 1601, is −126479.
 * 
 * Considering quadratics of the form:
 * 
 * n^2+an+b where |a|<1000 and |b|≤1000
 * 
 * where |n| is the modulus/absolute value of n
 * e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b, for the quadratic expression 
 * that produces the maximum number of primes for consecutive values of n, 
 * starting with n=0.
 */

package problems001_049;

import projecteuler.domain.Problem;

public class Problem027 extends Problem {

    @Override
    public void solve() {
        int largestNoOfPrimes = 0;
        int product = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int res = consecutivePrimes(a, b);
                if (res > largestNoOfPrimes) {
                    largestNoOfPrimes = res;
                    product = a * b;
                }
            }
        }
        
        System.out.println("Problem 27: " + product);
        
    }
    
    private int consecutivePrimes(int a, int b) {
        
        int n = 0;
        int result = 0;
        while (true) {
            int res = (int) Math.pow(n, 2) + a * n + b;
            if (methods.isPrime(res)) {
                result++;
                n++;
                continue;
            }
            break;
        }
        return result;
    }

}
