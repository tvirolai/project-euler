
package projecteuler.domain;

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
    
}
