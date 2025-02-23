import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.List;

/**
 * GraphCalculator.java
 * 
 * @authors Carolina Cepeda, Juanita Rubiano
 *          ECI 2025-1
 */
public class GraphCalculatorTest {

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {

    }

    @Test
    public void ShouldcreateCalculator() {
        GraphCalculator calculadora = new GraphCalculator();
        assertTrue(calculadora.getVariables().isEmpty());
        assertNull(calculadora.getultGrafo());

    }

    @Test
    public void ShouldAssign() {
        GraphCalculator calculadora = new GraphCalculator();
        String[] vertices = { "A", "M", "E", "N" };
        String[][] edges = { { "A", "M" }, { "M", "E" }, { "E", "N" }, { "N", "A" } };
        calculadora.assign("hola", vertices, edges);
        TreeMap<String, Graph> var = calculadora.getVariables();
        ArrayList<ArrayList<String>> edgesList = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList("A", "M")),
                        new ArrayList<>(Arrays.asList("M", "E")),
                        new ArrayList<>(Arrays.asList("E", "N")),
                        new ArrayList<>(Arrays.asList("N", "A")))); // debido a cambios de variables internamente en
                                                                    // grafos

        List<String> listVertices = Arrays.asList(vertices);

        assertEquals(var.get("hola").losVertices(), listVertices);
        assertEquals(var.get("hola").losEdges(), edgesList);
        assertTrue(calculadora.ok());
    }

      @Test
    public void shouldConvertToString(){
        GraphCalculator calculator = new GraphCalculator();
        String [] vertices ={"ABCD","ABC","MUL"};
        String [][] edges = {{"ABCD","MUL"},{"MUL","ABC"}};  
        String data= "(MUL, ABC) (ABCD, MUL)";
        Graph grafo = new Graph (vertices,edges);
        assertEquals(data, calculator.toString(grafo));
    }
    @Test
    public void ShouldinsertarArco() {
        GraphCalculator calculadora = new GraphCalculator();
        String[] vertices = { "1", "2", "3" };
        String[][] edges = { { "1", "2" }, { "2", "1" }, { "1", "3" }, { "2", "3" } };
        calculadora.assign("pruebaA", vertices, edges);
        calculadora.assignUnary("1", "2", '+', vertices);
        List<List<String>> esperado = Arrays.asList(Arrays.asList("1", "2"));

        assertTrue(calculadora.getVariables().get("pruebaA").losEdges().containsAll(esperado));

    }

    @Test
    public void shouldEliminarArco() {
        GraphCalculator calculadora = new GraphCalculator();
        String[] vertices = { "A", "B", "C" };
        String[][] edges = { { "A", "B" }, { "B", "C" }, { "A", "C" }, { "B", "A" } };
        calculadora.assign("pruebac", vertices, edges);

        calculadora.assignUnary("B", "C", '-', vertices);

        List<List<String>> noEsperado = Arrays.asList(Arrays.asList("B", "A"));

        assertFalse(calculadora.getVariables().get("pruebac").losEdges().containsAll(noEsperado));

    }

    @Test
    public void ShouldConjuntoPertenece() {
        GraphCalculator calculadora = new GraphCalculator();
        String[] vertices = { "A", "M", "O", "R" };
        String[][] edges = { { "A", "M" }, { "M", "O" }, { "O", "R" } };
        calculadora.assign("pruebae", vertices, edges);
        calculadora.assignUnary("A", "M", '?', vertices);
        List<String> vertices_pr = calculadora.getVariables().get("pruebae").losVertices();
        assertTrue(vertices_pr.containsAll(Arrays.asList(vertices)));
    }

    
    @Test
    public void shouldUnion(){
    }
    
    @Test
    public void shouldIntersection(){
        GraphCalculator calculadora = new GraphCalculator();
        calculadora.assign("b",new String[]{"a","b","c"},new String [][]{{"a","b"},{"b","c"}});
        calculadora.assign("c",new String[]{"a","b","d"},new String [][]{{"a","b"},{"b","d"}});
        Graph grafoEsperado = new Graph(new String[] {"a","b"}, new String[][] {{"a","b"}}) ;
        assertTrue(calculadora.sameGraphExactly (calculadora.assignBinary("a","b",'i',"c"),grafoEsperado));
    }
    
    @Test
    public void shouldJoin(){
    }
    
    @Test
    public void shouldDifference(){
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
}