package fr.neatmonster.labs.neat;

import static fr.neatmonster.labs.neat.Pool.CROSSOVER;
import static fr.neatmonster.labs.neat.Pool.rnd;

import java.util.ArrayList;
import java.util.List;

public class Species {
    public final List<Genome> genomes        = new ArrayList<Genome>();
    public double             topFitness     = 0.0;
    public double             averageFitness = 0.0;
    public int                staleness      = 0;

    public Genome breedChild() {//added Code
        final Genome child;
        //System.out.print("++   ");
        if (rnd.nextDouble() < CROSSOVER) {
            Genome g1 = new Genome();
            Genome g2 = new Genome();

            for(Genome g : genomes){
                if(g1.fitness < g.fitness  && !g.bred){
                    g1 = g;
                }
            }
            for(Genome g : genomes){
                if((g2.fitness < g.fitness) &&  (g1 != g2) && !g.bred) {
                    g2 = g;
                }
            }

            child = crossover(g1, g2);
        } else
            child = genomes.get(rnd.nextInt(genomes.size())).clone();
        child.mutate();
        return child;
    }

    public void calculateAverageFitness() {
        double total = 0.0;
        for (final Genome genome : genomes)
            total += genome.globalRank;
        averageFitness = total / genomes.size();
    }
    public void writeOutGraphs(){
        for(Genome gene : genomes){
            for(Synapse syn : gene.genes){
                System.out.print(syn.input + " " + syn.output + " "  + syn.weight + " " + syn.enabled
                        + syn.innovation);
            }
        }
    }
    public Genome crossover(Genome g1, Genome g2) {
        if (g2.fitness > g1.fitness) {
            final Genome tmp = g1;
            g1 = g2;
            g2 = tmp;
        }

        final Genome child = new Genome();
        outerloop: for (final Synapse gene1 : g1.genes) {
            for (final Synapse gene2 : g2.genes)
                if (gene1.innovation == gene2.innovation)
                    if (rnd.nextBoolean() && gene2.enabled) {
                        child.genes.add(gene2.clone());
                        continue outerloop;
                    } else
                        break;
            child.genes.add(gene1.clone());
        }

        child.maxNeuron = Math.max(g1.maxNeuron, g2.maxNeuron);

        for (int i = 0; i < 7; ++i)
            child.mutationRates[i] = g1.mutationRates[i];
        return child;
    }
}
