/*
 * Project Euler (http://projecteuler.net) problem 25: 1000-digit Fibonacci 
 * number
 * 
 * The Fibonacci sequence is defined by the recurrence relation:
  
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * 
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 
 * 1000 digits?
 */
package problems001_049;

import java.math.BigInteger;

public class Problem025 {
    
    public void solve() {
        String nMinusOne = "1";
        String nMinusTwo = "1";
        String current = "";
        int index = 0;
        for (int i = 3; current.length() < 1000; i++) {
            current = fib(nMinusOne, nMinusTwo);
            if (current.length() == 1000) {
                index = i;
            }
            nMinusOne = nMinusTwo;
            nMinusTwo = current;
        }
        System.out.println(index); //index);
        
    }
    
    private String fib(String nMinusOne, String nMinusTwo) {
        BigInteger n1 = new BigInteger(nMinusOne);
        BigInteger n2 = new BigInteger(nMinusTwo);
        return n1.add(n2).toString();
    }

}
