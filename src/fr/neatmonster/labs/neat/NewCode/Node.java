package fr.neatmonster.labs.neat.NewCode;
import java.util.*;

/**
 * Created by swaroopakkineni on 10/27/16.
 */
public class Node {
    public static double sigmoid(final double x) {
        return 1.0 / (1.0 + Math.exp(-1 * x)) ;
    }

    public double value = 0.0;
    List<Conn> listOfConnections = new ArrayList<Conn>();

}
