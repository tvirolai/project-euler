/*
 * Project Euler (http://projecteuler.net) problem 47: Distinct primes factors
 * number
 * 
 * The first two consecutive numbers to have two distinct prime factors are:
 * 
 * 14 = 2 × 7
 * 15 = 3 × 5
 * 
 * The first three consecutive numbers to have three distinct prime factors are:
 * 
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 * 
 * Find the first four consecutive integers to have four distinct prime 
 * factors. What is the first of these numbers?
 */

package problems001_049;

import java.util.ArrayList;
import java.util.Collections;


public class Problem047 {
    
    public void solve() {
        ArrayList<Long> results = new ArrayList<>();
        long i = 1000L;
        while (true) {
            if (hasFourPrimeFactors(i)) {
                if (results.size() > 0 && i - results.get(results.size() - 1) > 1) {
                    results.clear();
                }
                results.add(i);  
                
            }
            if (results.size() == 4) {
                System.out.println("Problem 47: " + results.get(0));
                break;
            }
            i++;
        }
    }
    
    private boolean hasFourPrimeFactors(long x) {
        return 4 == getDivisors(x).stream().filter(d -> isPrime(d)).count();
    }
            
    private ArrayList<Long> getDivisors(long x) {
        ArrayList<Long> smallFactors = new ArrayList<>();
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 1; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0 && x != i) {
                smallFactors.add(i);
                factors.add(i);
            }
        }
        smallFactors.stream().forEach((z) -> {
            long value = x / z;
            if (value != x && !factors.contains(value)) {
                factors.add(value);  
            }
        });
        Collections.sort(factors);
        return factors;
    }
    
    private boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        if (n > 2 && (n & 1) == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) 
                return false;
        return true;
    }

}
