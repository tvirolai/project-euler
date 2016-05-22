/*
 * Solutions to Project Euler programming puzzles. This is the main class from
 * where to call solution classes.
 * 
 * @author: Tuomo Virolainen <tuomo.virolainen@kapsi.fi>
 */

package projecteuler.domain;

import problems001_049.*;

public class ProjectEuler {

    public static void main(String[] args) {

        Problem042 problem = new Problem042();
        problem.solve();
    }
    
}
