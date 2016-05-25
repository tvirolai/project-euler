/*
 * Solutions to Project Euler programming puzzles. This is the main class from
 * where to call solution classes.
 * 
 * @author: Tuomo Virolainen <tuomo.virolainen@kapsi.fi>
 */

package projecteuler.domain;

import problems001_049.*;
import problems050_099.*;

public class ProjectEuler {

    public static void main(String[] args) {

        Problem092 problem = new Problem092();
        problem.solve();
    }
    
}
