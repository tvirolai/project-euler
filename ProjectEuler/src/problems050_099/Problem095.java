/*
 * Project Euler (http://projecteuler.net) problem 95: Amicable chains
 *
 * The proper divisors of a number are all the divisors excluding the number 
 * itself. For example, the proper divisors of 28 are 1, 2, 4, 7, and 14. As 
 * the sum of these divisors is equal to 28, we call it a perfect number.
 * 
 * Interestingly the sum of the proper divisors of 220 is 284 and the sum of 
 * the proper divisors of 284 is 220, forming a chain of two numbers. For this 
 * reason, 220 and 284 are called an amicable pair.
 * 
 * Perhaps less well known are longer chains. For example, starting with 12496, 
 * we form a chain of five numbers:
 * 
 * 12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)
 * 
 * Since this chain returns to its starting point, it is called an amicable 
 * chain.
 * 
 * Find the smallest member of the longest amicable chain with no element 
 * exceeding one million.
 */

package problems050_099;

import java.util.ArrayList;
import java.util.Collections;
import projecteuler.domain.Problem;

public class Problem095 extends Problem {

    @Override
    public void solve() {
        int longest = 0;
        int smallestMember;
        int i = 28;
        while (i < 1000000) {
            ArrayList<Integer> chain = getAmicableChain(i);
            if (chain == null) {
                i++;
                continue;
            } else {
                if (chain.size() > longest) {
                    longest = chain.size();
                    Collections.sort(chain);
                    int z = chain.get(0);
                    System.out.println(i + " " + longest + " " + z);
                }
            }
            i++;
        }
        System.out.println(longest);
    }
    
    private ArrayList<Integer> getAmicableChain(int x) {
        ArrayList<Integer> chain = new ArrayList<>();
        chain.add(x);
        int divisors = super.methods.getSumOfProperDivisors(x);
        int i = 1;
        while (divisors != x && divisors > 1) {
            chain.add(divisors);
            System.out.println(divisors + " " + x);
            divisors = super.methods.getSumOfProperDivisors(divisors);
            if (divisors == x) {
                return chain;
            }
            i++;
        }
        return null;
    }

}
