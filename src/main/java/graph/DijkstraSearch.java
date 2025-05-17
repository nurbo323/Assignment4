package graph;

import java.util.*;

public class DijkstraSearch<T> {
    public Map<Vertex<T>, Double> computePaths(Vertex<T> source) {
        Map<Vertex<T>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparing(distances::get));

        for (Vertex<T> v : source.getAdjacentVertices().keySet()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }

        distances.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();

            for (Map.Entry<Vertex<T>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<T> neighbor = entry.getKey();
                double newDist = distances.get(current) + entry.getValue();

                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    pq.add(neighbor);
                }
            }
        }

        return distances;
    }
}
