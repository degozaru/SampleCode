#include<stdio.h>

main(){
	int n, i;
	int sum = 0;

	//Take input for max and store in n
	printf("Please enter n: ");
	scanf("%d", &n);

	//Check to see if n is worth checking
        while (n == 0){
                printf("Please enter a number that's not 0: ");
                scanf("%d", &n);
        }
 	

	//Prepare equation
	printf("Sum of squares: ");

	//For every integer up to n, add the square
	for(i = 1; i <= n; i++){
		sum += i * i;
	}

	printf("%d\n", sum);
}

