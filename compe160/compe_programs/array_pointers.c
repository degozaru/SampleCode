//Library inclusions
#include <stdio.h>

//Preprocessor inclusions
#define ARRAY_SIZE 9

//Function Table of Contents
int sum(int array[], int asize);          //Ln. 34
int swap(int *pA, int *pB);               //Ln. 46
int sort_1pass(int array[], int asize);   //Ln. 60
void sort(int array[], int asize);        //Ln. 71
void printarray(int array[], int asize);  //Ln. 77

main() {
  int redID[ARRAY_SIZE] = {8, 1, 5, 9, 0, 9, 6, 9, 9};

  //Printing RedID
  printf("RedID digits: ");
  printarray(redID, ARRAY_SIZE);

  //Sum of digits of RedID
  printf("Sum of digits of RedID: %d\n", sum(redID, ARRAY_SIZE));
  
  //Sorting the RedID digits
  printf("Sorting RedID digits by ascending...\n");
  sort(redID, ARRAY_SIZE);

  //Printing median and average of RedID
  printf("Median of RedID: %d\n", redID[4]);
  printf("Average of RedID digits: %.2f\n",
              (float) sum(redID, ARRAY_SIZE) / ARRAY_SIZE);
} //End main()

//This will return the sum of the array.
int sum(int array[], int asize) {
  int i;
  int sum = 0;

  for (i = 0; i < asize; i++) {
    sum += array[i];
  }
  
  return sum;
} //End sum()

//This will swap the two elements.
int swap(int *pA, int *pB) {
  int temp;
  
  if(*pA > *pB) {
    temp = *pA;
    *pA = *pB;
    *pB = temp;
    return 1;
  }
  
  return 0;
} //End swap()

//This will make one pass through the array and sort in ascending order.
int sort_1pass(int array[], int asize) {
  int sorted = 0;
  int i;

  for(i = 0; i < (asize - 1); i++)
      if(swap(&array[i], &array[i+1])) sorted = 1;

  return sorted;
} //End sort_1pass()

//This will sort the whole array in ascending order.
void sort(int array[], int asize) {
  while (sort_1pass(array, asize)) 
    printarray(array, asize);
} //End sort()

//This will print the whole array.
void printarray(int array[], int asize) {
  int i;
  
  for (i = 0; i < asize; i++) printf("%d ", array[i]);
  printf("\n");
} //End printarray()

