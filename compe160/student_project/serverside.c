#include <stdio.h>
#include <string.h>
#include <wiringPi.h>

//Constants
#define KEYSIZE 15 //key WITH '\0'
#define SUCCESS 0
#define FAILURE 1

//Function prototypes
char encrypt(char plain, char key);
void authenticate();

main() {
  char *message; 
  char key[KEYSIZE] = "FiShEyEpLaCeBo";
  int i, length;
  FILE *enc = fopen("encrypted.txt", "w");

  //WiringPi setup
  wiringPiSetup();
  pinMode(SUCCESS, INPUT);
  pinMode(FAILURE, INPUT);

  //Starts authentication process
  printf("Please enter credentials on authentication device.\n");
  delay(10);
  authenticate(); 


  //Setting up message buffer.
  message = malloc(1000);
  printf("Type message to encrypt: ");
  fgets(message, 1000, stdin);
  length = strlen(message);

  //Converting the string to ciphertext
  for(i = 0; i < length; i++) message[i] = encrypt(message[i], key[i % KEYSIZE]);

  //Writing message into file
  for(i = 0; i < length; i++) fputc(message[i], enc);

  printf("Encryption finished.\n");
} //End main()

//returns encrypted char
char encrypt(char plain, char key) {
  return plain ^ key;
} //End encrypt()

//Authenticates the user, exits program if authentication fails
void authenticate() {

  //Wait for a success/failure signal from the FPGA
  while(1) {
    if (digitalRead(SUCCESS)) {
      printf("==========AUTHORIZED==========\n"); delay(500);
      printf("Encrypting/Decrypting message...\n"); delay(500);
      return 1;
    }
    if (digitalRead(FAILURE)) {
      printf("==========ACCESS DENIED=========\n"); delay(500);
      printf("Intruder disposal drones have been dispatched...\n"); delay(500);
      printf("Have a nice day.");
      exit(1);
    }
  }
} //End authenticate()

