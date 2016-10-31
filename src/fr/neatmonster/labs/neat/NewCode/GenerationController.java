package fr.neatmonster.labs.neat.NewCode;

import fr.neatmonster.labs.neat.Genome;
import fr.neatmonster.labs.neat.Pool;

import java.util.*;

/**
 * Created by swaroopakkineni on 10/27/16.
 */
public class GenerationController {
    public static final int POPULATION    = 50;
    public static final int STALE_SPECIES = 15;
    public static final int INPUTS        = 4;
    public static final int OUTPUTS       = 1;
    public static final int TIMEOUT       = 20;

    public static final double DELTA_DISJOINT  = 2.0;
    public static final double DELTA_WEIGHTS   = 0.4;
    public static final double DELTA_THRESHOLD = 1.0;

    public static final double CONN_MUTATION    = 0.25;
    public static final double LINK_MUTATION    = 2.0;
    public static final double BIAS_MUTATION    = 0.4;
    public static final double NODE_MUTATION    = 0.5;
    public static final double ENABLE_MUTATION  = 0.2;
    public static final double DISABLE_MUTATION = 0.4;
    public static final double STEP_SIZE        = 0.1;
    public static final double PERTURBATION     = 0.9;
    public static final double CROSSOVER        = 0.75;


    public Random rand_generator = new Random();
    public static final List<Species>  popul    = new ArrayList<Species>();
    public static int generation = 0;
    //public static int innovation = OUTPUTS;
    public static double maxFitness = 0.0;


    public static void addToSpecies(final Network child) {
        for (final Species spec : popul){
          //  if (child.sameSpecies(spec.genomes.get(0))) {
                spec.genomes.add(child);
                return;
           // }
        }
        final Species childSpecies = new Species();
        childSpecies.genomes.add(child);
        popul.add(childSpecies);
    }
    public static void cullSpecies(final boolean cutToOne) {
    }
    public static void initializePool() {
        for (int i = 0; i < POPULATION; i++){
            final Network net = new Network();
            net.maxNode = INPUTS;
           // net.mutate();
            addToSpecies(net);
        }
    }
    public static void newGeneration() {
    }
    public static void rankGlobally() {
    }
    public static void removeStaleSpecies() {
    }
    public static void removeWeakSpecies() {

    }
    public static double totalAverageFitness() {
        double retValue = 0.0;
        for(final Species species : popul){
            retValue += species.averageFitness;
        }
        return retValue;
    }
}
