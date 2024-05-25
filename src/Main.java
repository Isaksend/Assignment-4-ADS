import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex("Home");
        graph.addVertex("Mega");
        graph.addVertex("University");
        graph.addVertex("Office");
        graph.addVertex("Friend's apartment");

        graph.addEdge("Home", "Mega", 4);
        graph.addEdge("Home", "University", 2);
        graph.addEdge("Mega", "University", 1);
        graph.addEdge("Mega", "Office", 5);
        graph.addEdge("University", "Office", 8);
        graph.addEdge("University", "Friend's apartment", 10);
        graph.addEdge("Office", "Friend's apartment", 2);

        Vertex<String> start = graph.findVertex("Home");
        Vertex<String> end = graph.findVertex("Friend's apartment");
        System.out.println("Start Vertex: " + start);
        System.out.println("End Vertex: " + end);

        if (start == null || end == null) {
            System.out.println("Start or end vertex not found!");
            return;
        }
        Search<String> bfs = new BreadthFirstSearch<>();
        List<Vertex<String>> bfsPath = bfs.search(start, end);
        System.out.println("BFS Path: " + bfsPath);

        Search<String> dijkstra = new DijkstraSearch<>();
        List<Vertex<String>> dijkstraPath = dijkstra.search(start, end);
        System.out.println("Dijkstra Path: " + dijkstraPath);
    }
}
