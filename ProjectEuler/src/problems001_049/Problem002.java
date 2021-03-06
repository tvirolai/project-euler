/*
 * Project Euler (http://projecteuler.net) problem 2: Even Fibonacci numbers
 * 
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not
 * exceed four million, find the sum of the even-valued terms.
 */

package problems001_049;

public class Problem002 {
    
    public void solve() {
        int i = 1;
        int sum = 0;
        while (true) {
            int res = fib(i);
            if (res > 4000000) {
                break;
            } else if (res % 2 == 0) {
                sum += res;
            }
            i++;
        }
        System.out.println("Problem 2: " + sum);
    }
    
    
    public static int fib(int number) {
        switch (number) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return fib(number - 1) + fib(number - 2);
        }
    }

}
