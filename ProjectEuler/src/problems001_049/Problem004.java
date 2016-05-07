/*
 * Project Euler (http://projecteuler.net) problem 4: Largest palindrome product
 * 
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

package problems001_049;

import java.util.ArrayList;
import java.util.Collections;

public class Problem004 {

    public void solve() {
        
        ArrayList<Integer> products = new ArrayList<>();
        int no1 = 100;
        int no2 = 999;
        for (int i = 100; i < 1000; i++) {
            for (int y = 100; y < 1000; y++) {
                int product = i * y;
                if (isPalindrome(product)) {
                    products.add(product);
                }               
            }
        }
        Collections.sort(products);
        System.out.println("Problem 4: " + products.get(products.size() - 1));
    }
    
    public boolean isPalindrome(int number) {
        String reversed = "";
        String numberAsString = number + "";
        for (int i = numberAsString.length() - 1; i >= 0; i--) {
            reversed += numberAsString.charAt(i);
        }
        return reversed.equals(numberAsString);
    }
    
}
