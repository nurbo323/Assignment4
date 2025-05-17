package graph;

import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<T> {
    private Set<Vertex<T>> vertices;

    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        source.addAdjacentVertex(destination, weight);
        vertices.add(source);
        vertices.add(destination);
    }

    public Set<Vertex<T>> getVertices() {
        return vertices;
    }
}
