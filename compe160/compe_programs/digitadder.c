#include <stdio.h>
int main(){
	int id, total = 0, digit;
	printf("Enter REDid: ");
	scanf("%d", &id);
	printf("%d (", id);
	while(id > 0){
		digit = id % 10;
		total += digit;
		id  = id / 10;
		if(id != 0){
			printf("%d+", digit);
		};
	};
	printf("%d = %d)\n", digit, total);
}

