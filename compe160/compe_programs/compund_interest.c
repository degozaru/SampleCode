#include <stdio.h>
#include <math.h>

calctotal(double value, double interest, double days);

main() {
  double value;
  double interest;
  double days;

  //Ask for inputs
  printf("Enter principal value: ");
  scanf("%lf", &value);
  printf("Enter yearly interest: ");
  scanf("%lf", &interest);
  printf("Enter number of days: ");
  scanf("%lf", &days);

  calctotal(value, interest, days);

} //End main()

calctotal(double value, double interest, double days) {
  double result;
  
  //Calculate interest
  interest = interest / 365;
  interest++;

  //Perform calculation
  printf("%lf\n", value * pow(interest, days));

} //End calctotal()

