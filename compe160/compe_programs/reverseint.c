#include <stdio.h>
int main(){
	int rem;
	int num;
	printf("Enter int to be reversed: ");
	scanf("%d", &num);
	while(num >= 1){
		rem = num % 10;
		printf("%d", rem);
		num = num / 10;
	};
	printf("\n");
	return 0;	 
} // main
