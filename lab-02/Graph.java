import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
     private ArrayList<String> vertices;
     private ArrayList<ArrayList<String>> edges;

     public Graph(String[] vertices, String[][] edges) {
        // Inicializar la lista de vértices
        this.vertices = new ArrayList<>();
        this.convertVetorToArrayList(vertices, this.vertices);

        // Inicializar la lista de listas para las aristas
        this.edges = new ArrayList<>();

        // Verificar si la matriz de aristas no está vacía para evitar errores
        if (edges.length > 0 && edges[0].length > 0) {
            for (int i = 0; i < edges.length; i++) {
                ArrayList<String> row = new ArrayList<>();
                for (int j = 0; j < edges[i].length; j++) {
                    row.add(edges[i][j].toLowerCase());
                }
                this.edges.add(row);
            }
        }
    }

// Type copia = new Type(reftype);
/**
 * Convierte un array de cadenas en una lista de vértices, asegurándose de que no haya duplicados.
 *
 * @param vector   El array de cadenas que representa los vértices a agregar.
 * @param vertices La lista de vértices donde se almacenarán los valores únicos.
 */
    private void convertVetorToArrayList(String[] vector, ArrayList<String> vertices){
        ////Itera sobre el array vector 
        for (String vertice : vector) {
            vertice.toLowerCase();
            //Agrega cada vertice a la lista, siempre y cuando no este repetido.
            if (!vertices.contains(vertice)){
                vertices.add(vertice);
            }
        }
    }

    /**
 * Convierte una matriz de cadenas en una lista de listas, asegurándose de que las aristas sean válidas 
 * (es decir, que conecten vértices existentes en el grafo y que no estén duplicadas).
 *
 * @param matrix La matriz de cadenas que representa las aristas del grafo. 
 *               Cada fila contiene dos elementos que representan una conexión entre dos vértices.
 * @param edges  La lista de listas donde se almacenarán las aristas únicas.
 */
    private void convertMatrixToMatrixArrayList(String[][] matrix, ArrayList<ArrayList<String>> edges){
        //Itera sobre cada fila de matrix (cada arista).
        for (String[] edge : matrix) { 
            //Verifica que la arista tenga exactamente dos vertices y ambos existan.
            if(edge.length == 2 && vertices.contains(edge[0])&& vertices.contains(edge[1])){
                //convierte la fila en una lista.(una arista por cada dos vertices)
                ArrayList<String> newEdge = new ArrayList(Arrays.asList(edge));
                //Agrega la arista, sino esta repetida
                if(!containsEdge(edges,newEdge)){
                    edges.add(newEdge);
                }
            }
        }
    }
    
        public boolean contains(String vertex){
        return this.vertices.contains(vertex);
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

    // Método auxiliar para determinar si una lista de aristas ya contiene una arista (sin importar el orden)
    private boolean containsEdge(ArrayList<ArrayList<String>> edgeList, ArrayList<String> edge) {
        for (ArrayList<String> e : edgeList) {
            if (e.size() == edge.size() && e.containsAll(edge) && edge.containsAll(e)) {
                return true;
            }
        }
        return false;
    }

    
      /**
 * Retorna la canridad de vertices del grafo
 */
    public int vertices(){
        return vertices.size();
    }
    
   /**
 * Retorna la canridad de aristas del grafo
 */public int edges(){
        return edges.size();
    }    
    
    
    public boolean equals(Object o) {
        if (!(o instanceof Graph))
            return false;
        return equals((Graph) o);
    }
    
    //Only arcs in space-separated tuples. The vertices are capitalized. The edges must always be in alphabetical order.
    //For example, (A, B) (C, D) 
    public static void main(String[] args) {
        // Grafo de ejemplo
        String[] vertices = {"A", "B", "C", "D", "E"};
        String[][] edges = {{"A", "B"}, {"B", "C"}, {"C", "D"}, {"D", "E"}, {"B", "D"}};

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

}
