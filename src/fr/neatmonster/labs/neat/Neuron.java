package fr.neatmonster.labs.neat;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
    public static double sigmoid(final double x) {
        return 1.0 / (1.0 + Math.exp(-1 * x)) ;
    }

    public double              value  = 0.0;
    public final List<Synapse> inputs = new ArrayList<Synapse>();
}
