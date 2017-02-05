package jds.algos;

import jds.algos.primes.PrimeNumbers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AlgorithmsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        for (int i = 2; i < 15; i++){
            if(primeNumbers.isNumberPrimeNaive(i)){
                System.out.printf("The number %d is prime%n", i);
            } else {
                System.out.printf("The number %d is not prime%n", i);
            }

        }
    }
}
