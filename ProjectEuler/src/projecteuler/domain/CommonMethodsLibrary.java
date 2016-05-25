
package projecteuler.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommonMethodsLibrary {
    
    public boolean isPrime(int n) {
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
    
    public boolean isPermutation(int a, int b) {
        return intToSet(a).equals(intToSet(b));
    }
    
    public int reverseInteger(int a) {
        return Integer.parseInt(new StringBuilder("" + a).reverse().toString());
    }
    
    public int[] digitsToArray(long a) {
        String numberString = "" + a;
        int[] digitArray = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            digitArray[i] = Character.getNumericValue(numberString.charAt(i));
        }
        return digitArray;      
    }
    
    public ArrayList<Integer> digitsToArrayList(long n) {
        ArrayList<Integer> digitAL = new ArrayList<>();
        int[] digitArray = this.digitsToArray(n);
        for (int i = 0; i < digitArray.length; i++) {
            digitAL.add(digitArray[i]);
        }
        return digitAL;
    }

    public long reverseLong(long a) {
        return Long.parseLong(new StringBuilder("" + a).reverse().toString());
    }
    
    public BigInteger reverseBigInt(BigInteger a) {
        return new BigInteger(new StringBuilder(a.toString()).reverse().toString());
    }
    
    public boolean isPalindromic(int a) {
        return ("" + a).equals("" + this.reverseInteger(a));
    }

    public boolean isPalindromic(long a) {
        return ("" + a).equals("" + this.reverseLong(a));
    }
    
    public boolean isPalindromic(BigInteger a) {
        return a.toString().equals("" + this.reverseBigInt(a));
    }
    
    private Set<Integer> intToSet(int i) {
        Set<Integer> set = new HashSet<>();
        String iString = "" + i;
        for (int z = 0; z < iString.length(); z++) {
            set.add(Character.getNumericValue(iString.charAt(z)));
        }
        return set;
    }
}
