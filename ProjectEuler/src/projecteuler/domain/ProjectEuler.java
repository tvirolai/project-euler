/*
 * Solutions to Project Euler programming puzzles. This is the main class from
 * where to call solution classes.
 * 
 * @author: Tuomo Virolainen <tuomo.virolainen@kapsi.fi>
 */

package projecteuler.domain;

import problems001_049.*;
import problems050_099.*;
import problems100_149.*;

public class ProjectEuler {

    public static void main(String[] args) {

        Problem024 problem = new Problem024();
        problem.solve();
    }
    
}
