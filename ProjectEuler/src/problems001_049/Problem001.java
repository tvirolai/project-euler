/*
 * Project Euler (http://projecteuler.net) problem 1: Multiples of 3 and 5
 * 
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, 
 * we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all 
 * the multiples of 3 or 5 below 1000.
 * 
 */

package problems001_049;

import java.util.HashSet;
import java.util.Set;

public class Problem001 {

    public void solve() {
        Set<Integer> results = new HashSet<>();
        findMultiplesBelow(results, 3, 1000);
        findMultiplesBelow(results, 5, 1000);
        System.out.println("Problem 1: " + sum(results));
    }
    
    public void findMultiplesBelow(Set res, int number, int limit) {
        int factor = 1;
        while (true) {
            int result = number * factor;
            if (result >= limit) {
                break;
            } else {
                res.add(result);
                factor++;
            }
        }
    }
    
    public int sum(Set<Integer> res) {
        return res.stream().mapToInt(Number::intValue).sum();
    }
    
}
