package org.example.lab4;

//import com.google.common.graph.MutableNetwork;
//import com.google.common.graph.Network;
//import com.google.common.graph.NetworkBuilder;

import edu.uci.ics.jung.graph.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulation {
    private static int id = 0;
    private static final List<Node> nodesList = new ArrayList<>();
    private static int DEFAULT_NODES = 1000;

    public static int DELAY = 100;

    private static void initNodes() {
        for (int i = 0; i < DEFAULT_NODES; i++) {
            final Node node = new Node(id++);
            nodesList.add(node);
        }
    }

    //KKLayout();
    private static int idO = 0;
    private static int link = 0;

    public static Forest<Node, Number> createNetwork1() {
        final Forest<Node, Number> g = new DelegateForest<>();
        initNodes();
        Node mainP = getNode(idO++);
        final Node[] mas = new Node[5];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = getNode(idO++);
        }


        Random random = new Random();
        for (int i = 0; i < mas.length; i++) {
            Node p = mas[i];
            add(g, p, random.nextInt(3) + 3);
            mainP.addLink(p);
            g.addEdge(link++, mainP, p);
        }

        return g;
    }

    public static Node generateSecretNode(){
        for (Node node: getNodes()) {
            node.setStatus(StatusNode.GREEN);
        }

        Random random = new Random();
        int idSecret = random.nextInt(idO);
        Node secret = getNode(idSecret);
        secret.setStatus(StatusNode.RED);
        return secret;
    }

    public static void add(Forest<Node, Number> g, Node node, int count) {
        if(count==0){
            return;
        }
        Random random = new Random();
        for (int i = 0; i < random.nextInt(3) + 1; i++) {
            final Node nodeChild = getNode(idO++);
            node.addLink(nodeChild);
            g.addEdge(link++, node, nodeChild);
            add(g, nodeChild, count - 1);
        }

    }

    public static Node getNode(final int id) {
        return nodesList.get(id);
    }

    public static List<Node> getNodes() {
        return nodesList;
    }
}
