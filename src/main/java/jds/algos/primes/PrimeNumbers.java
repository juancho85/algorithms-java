package jds.algos.primes;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PrimeNumbers {

    public boolean isNumberPrimeNaive(int number) {
        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                System.out.printf("The number %d is not prime%n", number);
                return false;
            }
        }
        System.out.printf("The number %d is prime%n", number);
        return true;
    }

    /*
        We can make this code run faster by noticing that we only need to check
        divisibility for values of i that are less or equal to the square root of n
        (call this m). If n divides a number that is greater than m then the result
        of that division will be some number less than m and thus n will also divide
        a number less or equal to m. Another optimization is to realize that there
        are no even primes greater than 2. Once we’ve checked that n is not even we
        can safely increment the value of i by 2. We can now write the final method
        for checking whether a number is prime
     */
    public boolean isNumberPrimeSquareRoot(int number) {
        //we only take positive numbers greater than one
        if(number <= 1){
            System.out.printf("a The number %d is not prime%n", number);
            return false;
        }
        //2 is the only even prime number
        if(number==2) {
            System.out.printf("b The number %d is prime%n", number);
            return true;
        }
        //even numbers are not primes
        if(number % 2 == 0) {
            System.out.printf("c The number %d is not prime%n", number);
            return false;
        }
        int limit = (int) Math.ceil(Math.sqrt(number));
        for (int i = 3; i <= limit; i+=2) {
            if(number % i == 0){
                System.out.printf("d The number %d is not prime%n", number);
                return false;
            }
        }
        System.out.printf("e The number %d is prime%n", number);
        return true;
    }

    /*The Sieve of Eratosthenes will generate all the primes from 2 to a
    given number n. It begins by assuming that all numbers are prime.
    It then takes the first prime number and removes all of its multiples.
    It then applies the same method to the next prime number.
    This is continued until all numbers have been processed
     */
    public boolean[] isNumberPrimeSieve(int number) {
        boolean[] prime=new boolean[number+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        int limit = (int) Math.ceil(Math.sqrt(number));

        for (int i=2; i<=limit; i++){
            if (prime[i]){
                for (int k=i*i; k<=number; k+=i){
                    if(k == number) {
                        prime[k]=false;
                    }
                }
            }
        }

        return prime;
    }
}
