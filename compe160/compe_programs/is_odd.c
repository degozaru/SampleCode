#include <stdio.h>

//Function signatures
int isOdd(int n);

main() {
  int i;

  printf("n   | odd?\n");
  for(i = 0; i <= 10; i++) {
    printf("%d   |  %d\n", i, isOdd(i));
  }

} //End main()

int isOdd(int n) {
  return n % 2;
} //end isOdd
