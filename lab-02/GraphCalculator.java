import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * GraphCalculator.java
 * 
 * @author Carolina Cepeda, Juanita Rubiano
 */
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

    /**
     * Método para obtener el último grafo en el TreeMap
     */
    public Graph getultGrafo() {
        if (variables.isEmpty()) {
            return null;
        }
        String llavefin = "";
        for (String llave : variables.keySet()) {
            llavefin = llave;
        }
        return variables.get(llavefin);
    }

    /**
     * Get Variables
     * 
     * @return Treemap
     */
    public TreeMap<String, Graph> getVariables() {
        return this.variables;
    }

    /**
     * Crea una nueva variable
     * 
     * @param String nombre
     * @return void
     */
    public void create(String nombre) {
        variables.put(nombre, null);
    }

    /**
     * Assign a graph to an existing variable
     * a := graph
     * 
     * @param : String, String [], String[][]
     */
    public void assign(String nombre_graph, String[] vertices, String[][] edges) {
        Graph grafo = new Graph(vertices, edges);

        variables.put(nombre_graph, grafo);

        status = true;

    }

    /**
     * 
     * Assigns the value of a binary operation to a variable
     * a = b op v*
     * The operator characters are: '+' adding a edge between two vertices, '-'
     * removing a edge between two vertex
     * '?' checking if a graph contains the given vertices
     * 'p' return the graph with a path that passes through all the vertices in the
     * indicated order
     */
    public void assignUnary(String a, String b, char op, String[] vertices) {

        ultGrafo = getultGrafo();

        switch (op) {
            case '+':
                insertarArco(ultGrafo, a, b);
                break;
            case '-':
                eliminarArco(ultGrafo, a, b);
                break;

            case '?':
                conjuntoPertence(ultGrafo, vertices);
                break;

            case 'p':
                // mostrarCamino(ultGrafo, vertices);
                break;

            default:
                System.out.println("Operador no reconocido: " + op);
                break;

        }

    }

    // Assigns the value of a binary operation to a variable
    // a = b op c
    // The operator characters are: 'u' union, 'i' intersection, 'd' difference, 'j'
    // join

    public void assignBinary(String a, String b, char op, String c){
        
        ultGrafo = getultGrafo();

        switch (op) {

            case 'u':

                 a = ultGrafo.union(b,c);
                break;

            case 'i':
                 a = ultGrafo.intersection(b,c);
                break;

            case 'd':                
                 a = ultGrafo.diff(b,c);
                break;

            case 'j':
                 a = ultGrafo.join(b,c);
                break;

        }
    }
        /**
         * Returns the graph with the edges in uppercase in alphabetical order.
         */
        public String toString(Graph graph) {
        return graph.toString();
    }

    private void insertarArco(Graph grafo, String a, String b) {
        grafo.insertarArco(a, b);

    }

    private void eliminarArco(Graph grafo, String a, String b) {
        grafo.eliminarArco(a, b);
    }

    private boolean conjuntoPertence(Graph grafo, String[] vertices) {
        ArrayList<String> lVertices = new ArrayList<>(Arrays.asList(vertices));

        for (int i = 0; i < lVertices.size(); i++) {
            String vertice = lVertices.get(i);
            boolean booleano = grafo.enElGrafo(vertice);
            if (booleano == false) {
                return false;
            }
        }
        return true;
    }

    // path es con un arraylist o con un graph???
    /**
     * private ArrayList<String> mostrarCamino(Graph grafo, String[] vertices){
     * 
     * ArrayList < String > caminoCompleto = new ArrayList<>();
     * ArrayList <String> listaVertices= new ArrayList <> (Arrays.asList(vertices));
     * 
     * for (int i = 0; i < listaVertices.size() -1 ; i++ ){
     * String inicio = listaVertices.get(i);
     * String destino = listaVertices.get(i+1);
     * ArrayList<String> subcamino = grafo.path(inicio, destino);
     * caminoCompleto.addAll(subcamino);
     * }
     * return caminoCompleto;
     * }
     */

    // If the last operation was successfully completed
    public boolean ok() {
        return status;
    }
}
