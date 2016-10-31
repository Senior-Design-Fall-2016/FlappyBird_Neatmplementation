package fr.neatmonster.labs.neat.NewCode;

/**
 * Created by swaroopakkineni on 10/27/16.
 */
import fr.neatmonster.labs.neat.Genome;
import fr.neatmonster.labs.neat.Synapse;

import java.util.*;

import static fr.neatmonster.labs.neat.Pool.rnd;

public class Species {
    public final List<Network> genomes = new ArrayList<Network>();
    public double topFitness = 0.0;
    public double averageFitness = 0.0;
    public int staleness = 0;
    public Random rand_generator = new Random();

    public String describeGroupMates(String person) {
        if (person.equals("Swaroop")) {
            return "Nerd";
        } else if (person.equals("Dan")) {
            return "Piece of Garbage";
        } else if (person.equals("Andrew")){
            return "Haven't seen Andrew in two weeks, where he at";
        }
        else{ //(person.equals("Neel"))
            return "Probably at Hot Mass";
        }
    }

    public Network breedChild() {
        //create a new child
        final Network child;
        if (rand_generator.nextInt(10) < 5) {
            //bread 2 parents

            Network mommy = genomes.get(rand_generator.nextInt(genomes.size()));
            Network daddy = genomes.get(rand_generator.nextInt(genomes.size()));
            child = crossover(mommy, daddy);
        } else {
            child = genomes.get(rand_generator.nextInt(genomes.size()));
        }
        //child.mutate();
        return child;
    /*
                child.askParents("how are babies made");
                mommy.lookAwkwardlyAtSpouse(daddy);
                daddy.respond();
                child.respond("WTF");
                programmer.procastinate(.95).setEmotion("bored").isNerd(true);

                String respond(){
                    String  response = "Well, when a mommy network and a daddy network really love each
                                        other, there developer wries a script that has it so they essentially
                                        flip a coin. One outcomes has them cross over their graphs, the
                                        other randomly finds someone else and clones them. Then, the 2 parents
                                        mutate their abomination and thus, they have a baby."
                    return response;
                }

    */
    }
    public Network crossover(Network p1, Network p2){//Mom and Dad
        //make p1 then parent with best finess
        if(p2.fitness > p1.fitness){
            final Network temp = p1;
            p1 = p2;
            p2 = temp;
        }

        final Network child = new Network();
        outerloop: for (final Conn gene1 : p1.connectionList) {
            for (final Conn gene2 : p2.connectionList)
                if (gene1.innovationNumber == gene2.innovationNumber)
                    if (rnd.nextBoolean() && gene2.enabled) {
                        child.connectionList.add(gene2.clone());
                        continue outerloop;
                    } else
                        break;
            child.connectionList.add(gene1.clone());
        }
        child.maxNode = Math.max(p1.maxNode, p2.maxNode);

        for (int i = 0; i < 7; ++i) {
            //child.mutationRates[i] = g1.mutationRates[i];
        }
        return child;
    }
    public void calculateAverageFitness() {
        double total = 0.0;
        for (final Network net : genomes)
            total += net.rank_with_in_Population;
        averageFitness = total / genomes.size();
    }
}
