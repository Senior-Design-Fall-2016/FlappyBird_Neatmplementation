package fr.neatmonster.labs.neat.NewCode;

/**
 * Created by swaroopakkineni on 10/27/16.
 */

import fr.neatmonster.labs.neat.Synapse;

import java.util.*;

class Network{
    public List<Conn> connectionList = new ArrayList<Conn>();
    public double fitness = 0.0;
    public int maxNode = 0;
    public int rank_with_in_Population = 0;
    //public final double[] mutationRates = new double[]();
    public Map<Integer,Node> graph = null;

    public List<Node> nodeList = new ArrayList<Node>();
    public Random rand_generator = new Random();

    public Network clone(){
        Network cloneNet = new Network();
        cloneNet.maxNode = maxNode;
        for( final Conn conn : connectionList){
            cloneNet.connectionList.add(conn.clone());
        }
        //for (int i = 0; i < 7; ++i)
        //    cloneNet.mutationRates[i] = mutationRates[i];
        return cloneNet;
    }
    public boolean containsLink(final Conn link){
        for(final Conn conn : connectionList){
            if((link.input == conn.input) && (link.output == conn.output)){
                return true;
            }
        }
        return false;
    }
    public double disjoint(final Network net){
        double disjointConnectionList = 0.0;
        search: for (final Conn conn : connectionList) {
            for (final Conn otherConn : net.connectionList)
                if (conn.innovationNumber == otherConn.innovationNumber)
                    continue search;
            ++disjointConnectionList;
        }
        return disjointConnectionList / Math.max(connectionList.size(), net.connectionList.size());
    }
    public double[] evaluateNetwork(final double[] input){
return null;
    }
    /*void mutate(){
        int randomMutate = rand_generator.nextInt(4);

        switch(randomMutate) {
            case 1:
                mutateConnection_Weight();
                break;
            case 2:
                mutateNode_Value();
                break;
            case 3:
                mutateNode_Add();
                break;
            default:
                mutateConnection_Add();
        }
    }

   /* void mutateConnection_Weight(){
        Node randomConnection = rand_generator(connectionList.size());
        connectionList.get(randomConnection).value = rand_generator(num);//placeHolderNum
    }

    void mutateNode_Value(){
        Node randomNode = rand_generator(nodeList.size());
        nodeList.get(randomNode).value = rand_generator(num);//placeHolderNum
    }

    void mutateNode_Add(){
        Conn conn1 = connectionList.get( rand_generator(connectionList.size()) ); //input
        do{
            Conn conn2 = connectionList.get( rand_generator(connectionList.size()) );
        } while( !conn1.checkConnection(conn2) );

        Node newNode = new Node();

        newNode.value = rand_generator(num)//placeHolderNum;
        newNode.listOfConnections(conn1);
        newNode.listOfConnections(conn2);
    }

    void mutateConnection_Add(){
        //creates new synapse with connection
        Conn newConn = new Conn();
        int nodeList_length = nodeList.size();

        newConn.input = rand_generator.nextInt(nodeList_length);
        do{
            newConn.output = rand_generator.nextInt(nodeList_length);
        } while(outputNode == inputNode);

        if( checkConnection(newConn) ){
            mutateConnection_Add();
        }
        connectionList.add(newConn);
    }
*/
    boolean checkConnection( Conn connection_ToCheck){
        for(int i = 0; i < connectionList.size(); i++){
            if( connection_ToCheck.equals( connectionList.get(i) ) ){
                return true;
            }
        }
        return false;
    }
}

/*
    public Genome clone() X
    public boolean containsLink(final Synapse link) X
    public double disjoint(final Genome genome) X
    public double[] evaluateNetwork(final double[] input)
    public void generateNetwork()
    public void mutate()
    public void mutateEnableDisable(final boolean enable)
    public void mutateLink(final boolean forceBias)
    public void mutateNode()
    public void mutatePoint()
    public int randomNeuron(final boolean nonInput, final boolean nonOutput)
    public boolean sameSpecies(final Genome genome)
    public double weights(final Genome genome)

 */