import java.util.*;

public class DijkstraSearch<V> implements Search<V> {

    @Override
    public List<Vertex<V>> search(Vertex<V> start, Vertex<V> end) {
        Map<Vertex<V>, Double> distances = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> predecessors = new HashMap<>();
        PriorityQueue<Vertex<V>> priorityQueue = new PriorityQueue<>(Comparator.comparing(distances::get));

        distances.put(start, 0.0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();
            System.out.println("Visiting: " + current);
            if (current.equals(end)) {
                return buildPath(predecessors, end);  // Building way
            }
            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = distances.get(current) + weight;
                if (newDist < distances.getOrDefault(neighbor, Double.POSITIVE_INFINITY)) {
                    distances.put(neighbor, newDist);
                    predecessors.put(neighbor, current);  // Remember previous neighbour
                    priorityQueue.add(neighbor);
                }
            }
        }
        return null; // Way not found
    }

    private List<Vertex<V>> buildPath(Map<Vertex<V>, Vertex<V>> predecessors, Vertex<V> end) {
        List<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> at = end; at != null; at = predecessors.get(at)) {
            path.add(at);  // Building way in reverse order
        }
        Collections.reverse(path);
        return path;
    }
}
