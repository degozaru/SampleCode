#include <stdio.h>
#include <math.h>
int main(){

//variable declarations
	int total = 0;
	int i;
	int j;
	int digit;

	printf("This program will print the armstrong numbers between 1 and 1000.\n");

// main function
	for (i = 1; i < 1000; i++){
		j = i;
		while (	j != 0){
			digit = j % 10;
			total = total + digit*digit*digit;
			j = j / 10;
		}; // calculate total of the cube of all the digits
		if (total == i){
			printf("%d\n", i);
		}; // if total = integer (If armstrong) printf the number.
		total = 0;
	}; // increase the number and advance the for loop
}
