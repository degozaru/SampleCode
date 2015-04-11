#include <stdio.h>
#include <stdlib.h>

int main() {
   int line, n;

   for(line=1; line<=10; n++) {
	for(line=1; line<=n; line++) {
        	printf("*");
        }
	printf("\n");
   }
   return 0;
}



