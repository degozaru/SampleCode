#include <stdio.h>

main(){
	int n, i2, i3, i;
	
	//Take input for max and store.
	printf("Enter n: ");
	scanf("%d", &n);

	//Check if n is invalid
	while (n <= 0){
		printf("n is invalid, enter new n: ");
		scanf("%d", &n);
	}	

	//Initialize the board
	printf("Printing board from 1 to %d:\n", n);
	printf("N   N^2   N^3\n");

	//Print I, I^2, I^3 until n
	for(i = 1; n >= i; i++){
		i2 = i * i;
		i3 = i * i * i;
		printf("%d   %d     %d\n", i, i2, i3);
	} 
}
