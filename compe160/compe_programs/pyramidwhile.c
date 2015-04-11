#include <stdio.h>
#include <stdlib.h>

int main()
{
    int line=1;
    int n;

    while(line <= 10) {
        n=1;

        while(n <= line) {
        	printf("*");
        	n++;
        }
    line++;
    printf("\n");
    };

    return 0;
}




