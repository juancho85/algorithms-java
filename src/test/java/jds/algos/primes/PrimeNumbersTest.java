package jds.algos.primes;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeNumbersTest {
    @Test
    public void isNumberPrimeNaive() throws Exception {
        PrimeNumbers primeNumbers = new PrimeNumbers();
        int [] primes = {2,3,5,7,11,13};
        for(int prime : primes) {
            assertTrue(primeNumbers.isNumberPrimeNaive(prime));
        }
    }

}