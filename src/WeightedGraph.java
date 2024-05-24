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
        Vertex<V> v1 = new Vertex<>(source);
        Vertex<V> v2 = new Vertex<>(dest);
        map.get(v1).add(new Edge<>(v1, v2, weight));  // Add new edge
        v1.addAdjacentVertex(v2, weight);  // Updating adjacent vertex
    }
    public Map<Vertex<V>, List<Edge<V>>> getMap() {
        return map;  // return map of graph
    }
}
