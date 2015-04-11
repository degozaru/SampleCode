#include <stdio.h>
#include <string.h>

//Heap var
int *intPointer;

void main() {
  int intVar1;
  int intVar2;
  short shortVar1;
  short shortVar2;
  float floatVar1;
  float floatVar2;
  char nameVar[30];
  int intVar3;
  char *charPointer;

  //These variables are allocated onto the stack, and will have a high memory address
  intVar1=1;
  intVar2=2;
  shortVar1=1;
  shortVar2=2;
  floatVar1=1;
  floatVar2=4;
  intVar3=10;

  //These variables are allocated on the heap, and will have a low memory address
  intPointer=(int*) malloc(1000);
  charPointer=(char*) malloc(1000);
  strcpy(charPointer,"Yusuf Ozturk");

  //Print addresses of all variables
  printf("Heap variables\n==============\n");
  printf("[%014p] -> intPointer\n", intPointer);
  printf("[%014p] -> charPointer\n", charPointer);
  printf("\n");
  printf("Stack variables\n==============\n");
  printf("[%014p] -> intVar1\n", &intVar1);
  printf("[%014p] -> intVar2\n", &intVar2);
  printf("[%014p] -> shortVar1\n", &shortVar1);
  printf("[%014p] -> shortVar2\n", &shortVar2);
  printf("[%014p] -> floatVar1\n", &floatVar1);
  printf("[%014p] -> floatVar2\n", &floatVar2);
  printf("[%014p] -> nameVar\n", nameVar);
  printf("[%014p] -> intVar3\n", &intVar3);
} //End main()

