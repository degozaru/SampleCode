#include <stdio.h>

//Function Prototypes
int isNumber(char*);                //Ln. 9
int compare(int, int);              //Ln. 14
int countOnes(int);                 //Ln. 19
int twinPrimes(int*, int);          //Ln. 24

//This will return 1 if the char is a number. 0 if not.
int isNumber(char *c) {
  return ('0'<=c && c<='9');
} //End isNumber()

//This will compare two functions. Returns 1 if a>b, 0 if a==b, and -1 if a<b.
int compare(int a, int b) {
  return (a>b)?1 : (a<b)?-1 : 0;
} //End compare()

//This will return the number of 1s in the binary form of the given int
int countOnes(int number) {
  return (number==0)?0 : (unsigned)number%2 + countOnes((unsigned)number>>1);
} //End countOnes()

//Returns the address of an array containing twin primes up to the specified int b
int twinPrimes(int *twinPrimeNumbers, int numberofTwinPrimes) {
  //These are the base conditions.
  if(numberofTwinPrimes<1) return twinPrimeNumbers;
  twinPrimeNumbers[0] = 5;

  //This for loop will interate through twin primes and popular the array until the specified number is reached.
  for(int i=1; i<numberofTwinPrimes; i++) {
    int current = twinPrimeNumbers[i-1]+2;
    int previous = current-2;

    //This while loop will return the next twin prime.
    while(666) {
      //This is the prime check for the current
      int primeCur = 1;
      for(int j=2; j<current/2; j++)
        if(current%j==0) primeCur=0;
      int primePrev = 1;
      for(int k=2; k<previous/2; k++)
        if(previous%k==0) primePrev=0;

      //This compares the two primes and breaks the while loop if they are a twin prime, and continues to the next iteration if not.
      if(primeCur && primePrev) {
        twinPrimeNumbers[i] = current;
        break;
      }
      current++;
      previous++;
    }
  }
  return twinPrimeNumbers;
} //End twinPrimes()
