/**import java.util.TreeMap;
import java.util.ArrayList;

/**
 * GraphCalculator.java
 *
 * @author ESCUELA 2025-01
 */
/**
// con una sola muestra del grafo obtenemos todo el grafo.//

public class GraphCalculator {

    private TreeMap<String, Graph> variables;
    private Graph ultGrafo;
    private boolean status;

    public GraphCalculator() {
        this.variables = new TreeMap<String, Graph>();
        ultGrafo = null;
        status = false;
    }

    //Create a new variable
    public void create(String nombre) {
        variables.put(nombre, null);
    }

    /**
     * Assign a graph to an existing variable
     * a := graph
     *
     * @param : String, String [], String[][]
     */
  /**  public void assign(String nom_graph, String[] vertices, String[][] edges) {
        Graph grafo = new Graph(vertices, edges);

        variables.put(nom_graph, grafo);

        status = true;

    }


    //Assigns the value of a binary operation to a variable
    // a = b op v*
    //The operator characters are: '+' adding a edge between two vertices, '-' removing a edge between two vertex
    // '?' checking if a graph contains the given vertices
    // 'p' return the graph with a path that passes through all the vertices in the indicated order
    public void assignUnary(String a, String b, char op, String[] vertices) {
    }

    //Assigns the value of a binary operation to a variable
    // a = b op c
    //The operator characters are:  'u' union, 'i' intersection, 'd' difference, 'j' join


    /**
     * public void assignBinary(String a, String b, char op, String c){
     * if (op =="u")
     * {
     * Graph c = graph.union(a,b);
     * }
     * <p>
     * else if (op == "i")
     * {
     * Graph c = graph.intersection(a,b);
     * }
     * <p>
     * else if (op =="d")
     * {
     * Graph c = graph.diff(a,b);
     * }
     * <p>
     * else if (op =="j")
     * {
     * Graph c = graph.join(a,b);
     * }
     * <p>
     * }
     */
    //Returns the graph with the edges in uppercase in alphabetical order.
  /**
    public String toString(String graph) {
        return graph.toString();
    }

    private void insertarArco(Graph graph, String edg) {
        graph.insertarArco(edg);

    }

    //private void eliminarArco(Graph graph, String edg) {
        //graph.eliminarArco(edg);
    //}

    //private boolean conjuntoPertence(Graph grafo, ArrayList<String> vertices) {
        //for (int i = 0; i < vertices.size(); i++) {
            //String vertice = vertices.get(i);
            //boolean booleano = grafo.enElGrafo(vertice);
            //if (booleano == false) {
                return false;
            }
        }
        return true;
    }


    //If the last operation was successfully completed
    public boolean ok() {
        return status;
    }
}
**/