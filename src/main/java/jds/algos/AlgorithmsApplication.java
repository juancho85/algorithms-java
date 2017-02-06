package jds.algos;

import jds.algos.bfs.BreathFirstSearch;
import jds.algos.bfs.Vertex;
import jds.algos.primes.PrimeNumbers;
import jds.algos.webcrawler.WebCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmsApplication implements CommandLineRunner{

	@Autowired
	PrimeNumbers primeNumbers;

    @Autowired
    BreathFirstSearch bfsAlgo;

    @Autowired
    WebCrawler crawler;

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//        runPrimeNumbersAlgorithm();
//        runBfsAlgorithm();
        runWebCrawler();
    }

    private void runBfsAlgorithm() {
        Vertex vertex1 = new Vertex(1);
        Vertex vertex2 = new Vertex(2);
        Vertex vertex3 = new Vertex(3);
        Vertex vertex4 = new Vertex(4);
        Vertex vertex5 = new Vertex(5);

        vertex1.addNeighbourVertex(vertex2);
        vertex1.addNeighbourVertex(vertex4);
        vertex4.addNeighbourVertex(vertex5);
        vertex2.addNeighbourVertex(vertex3);
        bfsAlgo.bfs(vertex1);
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
