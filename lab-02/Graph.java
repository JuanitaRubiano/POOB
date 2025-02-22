import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertices;
    private ArrayList<ArrayList<String>> edges;

    public Graph(String[] vertices, String[][] edges) {
        this.vertices = new ArrayList<>();

        for (String vertex : vertices) {
            String v = vertex.toUpperCase();
            if (!this.vertices.contains(v)) {
                this.vertices.add(v);
            }
        }

        for (String[] edge : edges) {
            for (int i = 0; i < edge.length; i++) {
                edge[i] = edge[i].toUpperCase();
            }
        }

        this.edges = new ArrayList<>();
        for (String[] edge : edges) {
            if (edge.length == 2 && this.vertices.contains(edge[0]) && this.vertices.contains(edge[1])) {
                ArrayList<String> newEdge = new ArrayList<>(Arrays.asList(edge));
                if (!containsEdge(this.edges, newEdge)) {
                    this.edges.add(newEdge);
                }
            }
        }
    }

    public Graph path(String start, String end) {
        return null;
    }

    private ArrayList<String> getNeighbors(String vertex) {
        return null;

    }

    public Graph union(Graph g) {
        return null;
    }

    private boolean containsEdge(ArrayList<ArrayList<String>> edgeList, ArrayList<String> edge) {
        for (ArrayList<String> e : edgeList) {
            if (e.size() == edge.size() && e.containsAll(edge) && edge.containsAll(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna la cantidad de vertices del grafo
     */
    public int vertices() {
        return vertices.size();
    }

    /**
     * Retorna la cantidad de aristas del grafo
     */
    public int edges() {
        return edges.size();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Graph)) {
            return false;
        }
        if ((this.vertices == ((Graph) o).vertices) && (this.edges == ((Graph) o).edges)) {
            return true;
        }
        return false;
    }

    // Only arcs in space-separated tuples. The vertices are capitalized. The edges
    // must always be in alphabetical order.
    // For example, (A, B) (C, D)
    public static void main(String[] args) {
        // Grafo de ejemplo
        String[] vertices = { "A", "B", "C", "D", "E" };
        String[][] edges = { { "A", "B" }, { "B", "C" }, { "C", "D" }, { "D", "E" }, { "B", "D" } };

        Graph graph = new Graph(vertices, edges);
        System.out.println("Grafo original:");
        System.out.println(graph);

        // Obtener un camino desde A hasta E
        Graph pathGraph = graph.path("A", "E");
        if (pathGraph != null) {
            System.out.println("\nCamino encontrado desde A hasta E:");
            System.out.println(pathGraph);
        } else {
            System.out.println("\nNo se encontró camino desde A hasta E.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = edges.size() - 1; i >= 0; i--) {
            sb.append("(").append(edges.get(i).get(0)).append(", ").append(edges.get(i).get(1)).append(") ");
            if (i < edges.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString().strip();
    }

    // Adicionales
    
    /**
     * Función que inserta un arco entre dos vertices al conjunto de arcos
     * del grafo.
     * @param String vertice a , String vertice b
     * @return void
     */
    public void insertarArco(String a, String b) {
        this.edges.add(new ArrayList<>(Arrays.asList(a, b)));
    }

    /**
     * Función que elimina un arco entre dos vertices del conjunto de arcos
     * del grafo.
     * @param String vertice a , String vertice b
     * @return void
     */
    public void eliminarArco(String a, String b) {
        for (int i = 0; i < edges.size(); i++) {
            ArrayList<String> sublista = edges.get(i);
            if (sublista.equals(Arrays.asList(a, b)) || sublista.equals(Arrays.asList(b, a))) {
                edges.remove(i);
                i--;
            }
        }
    }

    
    /**
     * Función que verifica si un vértice dado es parte de
     * el conjunto de vertices del grafo
     * @param String vertices
     * @return boolean
     */
    public boolean enElGrafo(String vertice) {
        return vertices.contains(vertice);
    }

    /**
     * Función que retorna los vertices del grafo
     * @return ArrayList<String>
     */
    public ArrayList<String> losVertices() {
        return this.vertices;
    }

    /**
     * Función que retorna los arcos del grafo
     * @return ArrayList<ArrayList<String>>
     */
    public ArrayList<ArrayList<String>> losEdges() {
        return this.edges;
    }

    
    
    
    
    public Graph join(Graph g) {
        return null;
    }
    
    public Graph difference(Graph g) {
        return null;
    }
    
    public Graph intersection (Graph g) {
        return null;
    }

}