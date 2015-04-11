#include <iostream>
#include <iomanip>

using namespace std;

main () {
  //This will ask for user input and
  //verify that it is a valid input.
  int order;
  cout << "Magic Square Generator\n" << "=====================\n";
  cout << "Enter Order of square: ";
  cin >> order;
  if(order==1 | order%2==0) {
    cout << "Invalid number, please enter an odd number greater than 1.\n";
    return 0;
  }

  //This will initialize the square, zeroing out the elements.
  int square[order][order];
  for(int i=0; i<order; i++)
    for(int n=0; n<order; n++)
      square[i][n] = 0;
  square[0][order/2] = 1;
  int nextRow = -1;
  int nextColumn = (order/2)+1;

  //This will populate the array,
  //while also checking for special cases and adjusting.
  for(int nextInt=2; nextInt<=(order*order); nextInt++) {
    if(nextColumn>=order && nextRow<0) {
      nextColumn -= 1;
      nextRow += 2;
    }
    if(nextColumn>=order)
      nextColumn = 0;
    if(nextRow<0)
      nextRow = order-1;
    if(square[nextRow][nextColumn]!=0) {
      nextColumn -= 1;
      nextRow +=2;
    }
    square[nextRow][nextColumn] = nextInt;
    nextRow--;
    nextColumn++;
  }


  //This prints the array once the generation is complete.
  for(int i=0; i<order; i++) {
    for(int n=0; n<order; n++) {
      cout << setw(5);
      cout << square[i][n];
    }
    cout << endl;
  }
} //End main
