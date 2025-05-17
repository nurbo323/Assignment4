package graph;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");


        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(a, b, 4); // A to B, cost 4
        graph.addEdge(a, c, 2); // A to C, cost 2
        graph.addEdge(b, d, 1); // B to D, cost 1
        graph.addEdge(c, b, 3); // C to B, cost 3
        graph.addEdge(c, d, 5); // C to D, cost 5


        System.out.println("=== BFS ===");
        BFS<String> bfs = new BFS<>();
        bfs.traverse(a);


        System.out.println("\n=== Dijkstra ===");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        Map<Vertex<String>, Double> distances = dijkstra.computePaths(a);

        for (Map.Entry<Vertex<String>, Double> entry : distances.entrySet()) {
            System.out.println("Distance to " + entry.getKey().getData() + " = " + entry.getValue());
        }
    }
}
