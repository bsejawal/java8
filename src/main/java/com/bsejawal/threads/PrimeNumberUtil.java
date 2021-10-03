package com.bsejawal.threads;

public class PrimeNumberUtil {
    public static int calculatePrime(int n) {

        int number =0;
        int numberOfPrimesFound;
        int i;
        numberOfPrimesFound = 0;

        while(numberOfPrimesFound < n){
            number++;
            for(i =2; i<= number && number %i != 0; i++ ){

            }
            if(i== number){
                numberOfPrimesFound++;
            }

        }
        return number;

    }
}
