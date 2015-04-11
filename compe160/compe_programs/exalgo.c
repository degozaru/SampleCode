//Preprocesser declaration
#include <stdio.h>

//Function Table of Contents
double pow(double step, double x); //Ln. 31
double fact(double step); //Ln. 43

//This main function that will take input and calculate e^x
int main() {
	int x;
  double step;
	double sum = 0;
	
  //Take user input
	printf("Enter number equal to or greater than 0, or negative number to exit: ");
	scanf("%d", &x);
	if (x < 0) {
		return 0;
	}

  //Calculate Taylor series to 50th step
  for(step = 0; step <= 50; step++) {
    sum += (pow(step, x)/fact(step));
  }

  //Output total and loop
  printf("The Taylor series sum for e^%d is: %lf\n", x, sum);
  main();
} //End main()

//This is the power function. It will raise a number to a power
double pow(double step, double x) {
  return (step == 0) ? 1 : x * pow(step - 1, x);
} //End pow()

//This is the factorial function. It will factorial a number.
double fact(double step) {
  return (step == 0 || step == 1) ? 1 : step * fact(step - 1);
} //End fact()
