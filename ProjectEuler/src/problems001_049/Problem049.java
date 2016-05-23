/*
 * Project Euler (http://projecteuler.net) problem 49: Prime permutations
 *
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms 
 * increases by 3330, is unusual in two ways: (i) each of the three terms are 
 * prime, and, (ii) each of the 4-digit numbers are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this
 * sequence?
 */

package problems001_049;

import java.util.Set;
import java.util.HashSet;
import projecteuler.domain.CommonMethodsLibrary;
import projecteuler.domain.Problem;

public class Problem049 extends Problem {
    
    private final CommonMethodsLibrary methods;
    
    public Problem049() {
        this.methods = new CommonMethodsLibrary();
    }

    @Override
    public void solve() {
        String solution = "";
        for (int a = 0; a < 9999; a++) {
            if (a == 1487) {
                continue;
            }
            if (methods.isPrime(a)) {
                int b = a + 3330;
                int c = b + 3330;
                if (isPermutation(a, b) && isPermutation(a, c)) {
                    if (methods.isPrime(b) && methods.isPrime(c)) {
                        solution += "" + a + "" + b + "" + c;
                        break;
                    }
                }
            }
        }
        System.out.println("Problem 49: " + solution);
    }
    
    private boolean isPermutation(int a, int b) {
        return intToSet(a).equals(intToSet(b));
    }
    
    private Set<Integer> intToSet(int i) {
        Set<Integer> set = new HashSet<>();
        String iString = "" + i;
        for (int z = 0; z < iString.length(); z++) {
            set.add(Character.getNumericValue(iString.charAt(z)));
            System.out.println(Character.getNumericValue(iString.charAt(z)));
        }
        return set;
    }
    
    
    

}
