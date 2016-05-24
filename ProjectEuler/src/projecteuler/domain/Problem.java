
package projecteuler.domain;


public abstract class Problem {
    
    public final CommonMethodsLibrary methods;
    
    public Problem() {
        this.methods = new CommonMethodsLibrary();
    }
    
    public abstract void solve();
    
}
