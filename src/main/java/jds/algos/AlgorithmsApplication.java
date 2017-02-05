package jds.algos;

import jds.algos.primes.PrimeNumbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmsApplication implements CommandLineRunner{

	@Autowired
	PrimeNumbers primeNumbers;

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
        primeNumbers.isNumberPrimeNaive(100_001);
        primeNumbers.isNumberPrimeSquareRoot(100_001);
    }
}
