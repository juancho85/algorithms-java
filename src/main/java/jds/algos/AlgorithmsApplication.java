package jds.algos;

import jds.algos.bfs.BreathFirstSearch;
import jds.algos.topological.TopologicalOrdering;
import jds.algos.vertex.Vertex;
import jds.algos.dfs.DepthFirstSearch;
import jds.algos.primes.PrimeNumbers;
import jds.algos.webcrawler.WebCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SpringBootApplication
public class AlgorithmsApplication implements CommandLineRunner{

	@Autowired
	PrimeNumbers primeNumbers;

    @Autowired
    BreathFirstSearch bfsAlgo;

    @Autowired
    DepthFirstSearch dfsAlgo;

    @Autowired
    WebCrawler crawler;

    @Autowired
    TopologicalOrdering topologicalOrdering;

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//        runPrimeNumbersAlgorithm();
//        runBfsAlgorithm();
//        runWebCrawler();
//        runDfsAlgorithm();
        runTopologicalOrdering();
    }

    private void runTopologicalOrdering(){
	    List<Vertex> graph = new ArrayList<>();
	    graph.add(new Vertex("0"));
	    graph.add(new Vertex("1"));
	    graph.add(new Vertex("2"));
	    graph.add(new Vertex("3"));
	    graph.add(new Vertex("4"));
	    graph.add(new Vertex("5"));

	    graph.get(2).addNeighbourVertex(graph.get(3));
	    graph.get(3).addNeighbourVertex(graph.get(1));
	    graph.get(4).addNeighbourVertex(graph.get(0));
	    graph.get(4).addNeighbourVertex(graph.get(1));
	    graph.get(5).addNeighbourVertex(graph.get(0));
	    graph.get(5).addNeighbourVertex(graph.get(2));


	    //we do a bfs on each node (we do not repeat nodes since we mark them
        //as visited
	    for(int i = 0; i < graph.size(); i++) {
	        if(!graph.get(i).isVisited()){
	            topologicalOrdering.dfs(graph.get(i));
            }
        }

        Stack<Vertex> stack = topologicalOrdering.getStack();

	    for(int i=0; i< graph.size(); i++) {
	        Vertex vertex = stack.pop();
            System.out.println(vertex+ " -> ");
        }
    }

    private void runBfsAlgorithm() {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");

        vertex1.addNeighbourVertex(vertex2);
        vertex1.addNeighbourVertex(vertex4);
        vertex4.addNeighbourVertex(vertex5);
        vertex2.addNeighbourVertex(vertex3);
        bfsAlgo.bfs(vertex1);
    }

    private void runDfsAlgorithm() {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");

        vertex1.addNeighbourVertex(vertex2);
        vertex1.addNeighbourVertex(vertex3);
        vertex3.addNeighbourVertex(vertex4);
        vertex4.addNeighbourVertex(vertex5);

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        vertexList.add(vertex4);
        vertexList.add(vertex5);
        dfsAlgo.dfs(vertexList);
    }

    private void runPrimeNumbersAlgorithm() {
        primeNumbers.isNumberPrimeNaive(100_001_001);
        primeNumbers.isNumberPrimeSquareRoot(100_001_001);
        primeNumbers.isNumberPrimeSieve(100_001_001);
    }

    private void runWebCrawler() {
        String rootUrl = "http://www.bbc.com";
	    crawler.discoverWeb(rootUrl);
    }
}
