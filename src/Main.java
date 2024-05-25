import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 10);
        graph.addEdge("D", "E", 2);

        Vertex<String> start = new Vertex<>("A");
        Vertex<String> end = new Vertex<>("E");

        Search<String> bfs = new BreadthFirstSearch<>();
        List<Vertex<String>> bfsPath = bfs.search(start, end);
        System.out.println("BFS Path: " + bfsPath);

        Search<String> dijkstra = new DijkstraSearch<>();
        List<Vertex<String>> dijkstraPath = dijkstra.search(start, end);
        System.out.println("Dijkstra Path: " + dijkstraPath);
    }
}
