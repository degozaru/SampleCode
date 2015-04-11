#include <stdio.h>
int isPrime(long i);

main() {
  long number = 600851475143;
  long i;

  //This will factor 

  //This will find out if a number is divisible
  for(i = 2L; i < number/2; i++) {
    if(number % i == 0 && isPrime(i)) {
        printf("%ld", i);
    }
  }
}//End main()

int isPrime(long i) {
  long n;

  //Will return 0 if the number is not prime.
    for (n = 2L; n*n <= i; n++) {
      if (i % n == 0) {
        return 0;
      }
    }
    return 1;
} //End isPrime()

