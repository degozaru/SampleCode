#include <stdio.h>

//Function table of contents
int strlen(char* s);              //Ln. 49
char* strcpy(char* s1, char* s2); //Ln. 54
char* strcat(char* s1, char* s2); //Ln. 61

void main() {
  char s1[100]; 
  char s2[100];
  char s3[100];
  char catLine[100] = "Hello ";

  //Demonstrate strlen(), prints name length.
  printf("Enter first name: ");
  printf("The name length is: %d\n", strlen(gets(s1)));

  //Demonstrate strcpy(), copys a string and prints both
  printf("Enter name: ");
  strcpy(s2, gets(s1));
  printf("s1 = ");
  puts(s1);
  printf("s2 = ");
  puts(s2); 

  //Demonstrates strcat(), prints the concatonated lines
  printf("Enter Name: ");
  gets(s1);
  printf("Enter Last Name: ");
  gets(s2);
  printf("Enter RedID: ");
  gets(s3);
  
  puts(s1); //This part prints out strings
  puts(s2);
  puts(s3);

  s2[strlen(s2) + 1] = '\0'; //This part appends spaces.
  s2[strlen(s2)] = ' ';
  s1[strlen(s1) + 1] = '\0';
  s1[strlen(s1)] = ' ';

  strcat(s2, s3); //This part runs strcat() to combine strings.
  strcat(s1, s2);
  strcat(catLine, s1);
  puts(catLine);
} //End main()

//This will return the numbers of char in the string
int strlen(char* s) {
  return (*s == '\0') ? 0 : 1 + strlen(s + 1);
} //End strlen()

//This will copy s2 into s1 and return the address
char* strcpy(char* s1, char* s2) {
  int i;

  for(i = 0; i <= strlen(s2); i++) s1[i] = s2[i];
} //End strcpy()

//This will concatenate s2 into s1 and return the address of s1
char* strcat(char* s1, char* s2) {
  int startpnt = strlen(s1);
  int i;

  for(i = 0; i <= strlen(s2); i++) s1[i + startpnt] = s2[i];
} //End strcat()

