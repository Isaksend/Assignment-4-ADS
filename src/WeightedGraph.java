import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<V>>> map;  // Map of Vertex

    public WeightedGraph() {
        this.map = new HashMap<>();
    }
    public void addVertex(V data) {
        map.putIfAbsent(new Vertex<>(data), new ArrayList<>());  // Adding new vertex
    }
    public void addEdge(V source, V dest, double weight) {
        Vertex<V> v1 = findVertex(source);
        Vertex<V> v2 = findVertex(dest);
        if (v1 == null || v2 == null) {
            System.out.println("Vertex not found!");
            return;
        }
        map.get(v1).add(new Edge<>(v1, v2, weight));  // Add new edge
        v1.addAdjacentVertex(v2, weight);  // Updating adjacent vertex
    }
    public Vertex<V> findVertex(V data) {
        for (Vertex<V> vertex : map.keySet()) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }
    public Map<Vertex<V>, List<Edge<V>>> getMap() {
        return map;  // return map of graph
    }
}
