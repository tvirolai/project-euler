/*
 * Project Euler (http://projecteuler.net) problem 23: Non-abundant sums
 * 
 * A perfect number is a number for which the sum of its proper divisors is 
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less
 * than n and it is called abundant if this sum exceeds n.
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By 
 * mathematical analysis, it can be shown that all integers greater than 28123 
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers 
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 */

package problems001_049;

import java.util.ArrayList;
import java.util.Collections;

public class Problem023 {
    
    private final ArrayList<Integer> abundant;
    
    public Problem023() {
        this.abundant = new ArrayList();
        for (int i = 12; i < 28123; i++) {
            if (isAbundant(i)) {
                this.abundant.add(i);
            }
        }
    }
    
    public void solve() {
        int resultSum = 0;
        for (int i = 1; i < 28123; i++) {
            if (!canBeWrittenAsSumOfAbundantNumbers(i)) {
                resultSum += i;
            }
        }
        System.out.println(resultSum);
    }
    
    private boolean canBeWrittenAsSumOfAbundantNumbers(int x) {
        boolean returnValue = false;
        outerloop:
        for (int i = 0; i < this.abundant.size(); i++) {
            int value = this.abundant.get(i);
            for (int z = 0; z < this.abundant.size(); z++) {
                int secondValue = this.abundant.get(z);
                if (secondValue + value == x) {
                    returnValue = true;
                    break outerloop;
                }
                if (secondValue + value > x) {
                    break;
                }
            }
        }            
        return returnValue;
    }
    
    private boolean isAbundant(int x) {
        return x < getSumOfDivisors(x);
    }
    
    private int getSumOfDivisors(int x) {
        return getDivisors(x).stream().mapToInt(Integer::intValue).sum();
    }
    
    private ArrayList<Integer> getDivisors(int x) {
        ArrayList<Integer> smallFactors = new ArrayList<>();
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 1; i < Math.sqrt(x) + 1; i++) {
            if (x % i == 0 && x != i) {
                smallFactors.add(i);
                factors.add(i);
            }
        }
        smallFactors.stream().forEach((z) -> {
            int value = x / z;
            if (value != x && !factors.contains(value)) {
                factors.add(value);  
            }
        });
        Collections.sort(factors);
        return factors;
    }

}
