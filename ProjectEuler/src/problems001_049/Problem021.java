/*
 * Project Euler (http://projecteuler.net) problem 21: Amicable numbers
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n 
 * which divide evenly into n).
 * 
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and
 * each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */

package problems001_049;

import java.util.ArrayList;


public class Problem021 {
    
    public void solve() {
        int solution = 0;
        int i = 0;
        while (i < 10000) {
            if (isAmicable(i)) {
                solution += i;
            }
            i++;
        }
        System.out.println("Problem 21: " + solution);
    }
    
    public boolean isAmicable(int x) {
        int sumOfDivisors = getSumOfDivisors(x);
        return x == getSumOfDivisors(sumOfDivisors) && x != sumOfDivisors;
    }
    
    public int getSumOfDivisors(int x) {
        ArrayList<Integer> smallFactors = new ArrayList<>();
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                smallFactors.add(i);
                factors.add(i);
            }
        }
        smallFactors.stream().forEach((z) -> {
            if (z > 1) {
                factors.add(x / z);  
            }
        });

        return factors.stream().mapToInt(Integer::intValue).sum();
    }

}
