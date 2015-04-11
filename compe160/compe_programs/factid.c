#include <stdio.h>
int main(){
	int id;
	int i;

	printf("Enter REDid: ");
	scanf("%d", &id);
	printf("The factors of your REDid are: \n");
	for(i = 1; i <= id; i++){
		if (id % i == 0){
			printf("%d\n", i); 
		};
	};
}
