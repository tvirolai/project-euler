/*
 * Project Euler (http://projecteuler.net) problem 3: Largest prime factor
 * 
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 */

package problems001_049;

import java.util.ArrayList;
import java.util.Collections;

public class Problem003 {
    
    public void solve() {
        long number = 600851475143L;
        ArrayList<Long> divisors = getDivisors(number);
        for (int i = divisors.size() - 1; i >= 0; i--) {
            long divisor = divisors.get(i);
            if (isPrime(divisor)) {
                System.out.println("Problem 3: " + divisor);
                break;
            }
        }
    }
    
    public ArrayList<Long> getDivisors(long x) {
        ArrayList<Long> smallFactors = new ArrayList<>();
        ArrayList<Long> factors = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                smallFactors.add((long) i);
                factors.add((long) i);
            }
        }
        smallFactors.stream().forEach((z) -> {
            factors.add(x / z);
        });
       
        Collections.sort(factors);       
        return factors;
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
