#include <stdio.h>
int pow(int n, int m);

int main() {
  int n;
  int m;

  printf("Enter n (entering 0 will exit the program): ");
  scanf("%d", &n);
  //Exit if n is 0
  if (n == 0) {
    return 0;
  }
  printf("Enter m: ");
  scanf("%d", &m);

  //Run power function and return to top
  printf("%d\n", pow(n, m));
  main();
} //End main()

int pow(int n, int m) {
  int total = 1;
  int i;
  
  for (i = 1; i <= m; i++) {
    total = total * n;
  }
  return total;
} //End pow()
