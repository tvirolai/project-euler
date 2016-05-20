/*
 * Project Euler (http://projecteuler.net) problem 37: Truncatable primes
 * number
 * 
 * The number 3797 has an interesting property. Being prime itself, it is 
 * possible to continuously remove digits from left to right, and remain prime 
 * at each stage: 3797, 797, 97, and 7. Similarly we can work from right to
 * left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left
 * to right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

package problems001_049;


public class Problem037 {
    
    public void solve() {
        int sum = 0;
        int found = 0;
        int i = 11;
        
        while (found < 11) {
            if (isTruncatableBothWays(i)) {
                found++;
                sum += i;
            }
            i++;
        }

        System.out.println("Problem 37: " + sum);
    }
    
    private boolean isTruncatableBothWays(int n) {
        return isTruncatable(n, true) && isTruncatable(n, false);
    }
    
    private boolean isTruncatable(int n, boolean fromLeft) {
        boolean returnValue = true;
        String nString = "" + n;
        while (true) {
            int truncN = Integer.parseInt(nString);
            if (!isPrime(truncN)) {
                returnValue = false;
                break;
            }
            if (nString.length() > 1) {
                if (fromLeft) {
                   nString = nString.substring(1);
                } else {
                   nString = nString.substring(0, nString.length() - 1); 
                }
            } else {
                break;
            }
        }
        return returnValue;
    }
    
    private boolean isPrime(int n) {
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
