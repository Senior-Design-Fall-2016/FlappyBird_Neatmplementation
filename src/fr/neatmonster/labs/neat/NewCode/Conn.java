package fr.neatmonster.labs.neat.NewCode;


import fr.neatmonster.labs.neat.Synapse;
import java.util.*;

/**
 * Created by swaroopakkineni on 10/27/16.
 */
public class Conn {
    public int input = 0;
    public int output = 0;

    public double weight = 0.0;
    public int innovationNumber = 0;
    public boolean enabled = false;

    @Override
    public Conn clone() {
        final Conn connection = new Conn();

        connection.input = input;
        connection.output = output;
        connection.weight = weight;
        connection.innovationNumber = innovationNumber;
        connection.enabled = enabled;

        return connection;
    }
}
