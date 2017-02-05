package jds.algos.primes;

import org.springframework.stereotype.Component;

@Component
public class PrimeNumbers {

    public boolean isNumberPrimeNaive(int number) {
        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
