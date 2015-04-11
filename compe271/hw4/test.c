#include <stdio.h>

extern int isNumber(char);

main () {
  printf("%d", isNumber('c'));
  printf("%d", isNumber('8'));
  printf("%d", isNumber('9'));
  printf("%d", isNumber('0'));
}

