#include <stdio.h>

int main(){
	int a = 1, b = 1, i = 1;
	int max;
	int sum = 0;

	//Take and input int into variable max
	printf("Enter max number ");
	scanf("%d", &max);
	
	//Check that it's a valid number
	while(max <= 0){
		printf("Please enter number greater than 0: ");
		scanf("%d", &max);
	}
	
	//Print the Fibonacci if it is just 1 because it is a special case
	if(max == 1){
		printf("0 1 1");
		return 0;
	}

	
	//Calculating Fibonacci
	printf("0 1 ");
	while( max >= i){
		if (i % 2 == 0 ) {
			sum += i;
		}
		printf("%d ", i);
		i = a + b;
		b = a;
		a = i;
	}

	printf("\n");
	printf("%d\n", sum);
	return 0;
}
