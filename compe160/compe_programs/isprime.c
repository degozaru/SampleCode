#include <stdio.h>

main() {
  int i;
  int total = 0;

  //This will run isPrime() for 1 to 1000
  for (i = 1; i <= 1000; i++) {
    if (isPrime(i)) {
      total += 1;
      printf("%d ", i);
      if (total % 10 == 0) {
        printf("\n");
      }
    }
  }
  printf("\n");
} //End main()

int isPrime(int i) {
  int n;

  //Will return 0 if the number is not prime.
    for (n = 2; n <= i/2; n++) {
      if (i % n == 0) {
        return 0;
      }
    }
    return 1;
} //End isPrime()

