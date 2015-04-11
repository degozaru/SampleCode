#include <iostream>
#include <stdio.h>
using namespace std;

class Date {
  /*PRIVATE******* 
   *FUNCTIONSPACE*/
  private:
    //Variable declarations
    int month, day, year;

    //Setting everything back to default
    void setDefault() {
      month = 1;
      day = 1;
      year = 2000;
    }
    
  /*PUBLIC********
   *FUNCTIONSPACE*/
  public:
    //Constructors: default and specialized
    Date() {
      month = 1;
      day = 1;
      year = 2000;
    }
    Date(month, day, year) {
      setMonth(month);
      setDay(day);
      setYear(2000);
    }

    //Accessor functions
    int getMonth() {
      return month;
    }
    int getDay() {
      return day;
    }
    int getYear() {
      return year
    }

    //Mutator functions.
    //Will set to default if invalid.
    void setMonth(int newMonth) {
      month = newMonth;
      if(newMonth > 12 || newMonth < 1)
        setDefault();
    }
    void setDay(int newDay) {
      day = newDay;
      if(newDay > 31)
        setDefault();
    }
    void setYear(int newYear) {
      year = newYear;
      if(newYear < 1)
        setDefault();
    }
}
