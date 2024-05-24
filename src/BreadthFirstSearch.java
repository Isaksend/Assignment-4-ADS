import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    @Override
    public List<Vertex<V>> search(Vertex<V> start, Vertex<V> end) {
        Map<Vertex<V>, Vertex<V>> predecessors = new HashMap<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        Set<Vertex<V>> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            if (current.equals(end)) {
                return buildPath(predecessors, end);  // Building way
            }
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    predecessors.put(neighbor, current);  // Remember previous neighbor
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
