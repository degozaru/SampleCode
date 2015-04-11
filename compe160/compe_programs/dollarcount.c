#include <stdio.h>
#include <stdlib.h>

int main() {
    int n, x=0, r=0, s=0, t=0;
    printf("Enter dollar amount: ");
    scanf("%d", &n);
    while (n>0) {
        if (n>=20) {
            n = n - 20;
            x++;
        }
        else if(n>=10) {
            n = n - 10;
            r++;
        }
        else if(n>=5) {
            n = n - 5;
            s++;
        }
        else if(n>=1) {
            n = n - 1;
            t++;
        }
 
     } //End of while loop

        printf("$20: %d\n", x);
        printf("$10: %d\n", r);
        printf("$5: %d\n", s);
        printf("$1: %d\n", t);
    	return 0;
}
