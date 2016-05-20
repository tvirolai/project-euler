/*
 * Project Euler (http://projecteuler.net) problem 36: Double-base palindromes
 * number
 * 
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * Find the sum of all numbers, less than one million, which are palindromic in
 * base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include 
 * leading zeros.)
 */

package problems001_049;

import java.math.BigInteger;


public class Problem036 {
    
    public void solve() {
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < 1000000; i++) {
            if (isDoubleBasePalindromic(i)) {
                BigInteger bigI = new BigInteger("" + i);
                sum = sum.add(bigI);
            }
        }
        System.out.println("Problem 36: " + sum);
    }
    
    private boolean isDoubleBasePalindromic(int no) {
        String decimalBase = "" + no;
        String binaryBase = Integer.toBinaryString(no);
        return (isPalindrome(decimalBase) && isPalindrome(binaryBase));
    }
    
    private boolean isPalindrome(String str) {
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}
