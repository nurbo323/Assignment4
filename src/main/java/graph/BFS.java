package graph;

import java.util.*;

public class BFS<T> {
    public void traverse(Vertex<T> start) {
        Set<Vertex<T>> visited = new HashSet<>();
        Queue<Vertex<T>> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            System.out.println("Visited: " + current.getData());

            for (Vertex<T> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
