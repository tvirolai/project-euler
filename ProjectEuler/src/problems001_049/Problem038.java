/**
 * Project Euler (http://projecteuler.net) problem 38: Pandigital multiples
 * 
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * 
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * 
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. 
 * We will call 192384576 the concatenated product of 192 and (1,2,3)
 * 
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, 
 * and 5, giving the pandigital, 918273645, which is the concatenated product 
 * of 9 and (1,2,3,4,5).
 * 
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as 
 * the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
package problems001_049;

import java.math.BigInteger;
import projecteuler.domain.Problem;

public class Problem038 extends Problem {

    @Override
    public void solve() {
        int n = 8;
        BigInteger largest = BigInteger.valueOf(0);
        while (n < 10000) {
            n++;
            String res = concatProduct(n);
            if (res.length() > 9) {
                continue;
            }
            if (methods.isNDigitPanDigital(res)) {
                BigInteger result = new BigInteger(res);
                if (result.compareTo(largest) == 1) {
                    largest = result;
                }
            }
        }
        
        System.out.println("Problem 38: " + largest);
        
    }
    
    private String concatProduct(int n) {
        String product = "";
        int i = 1;
        while (product.length() < 9) {
            product += "" + i * n;
            i++;
        }
        return product;
    }

}
