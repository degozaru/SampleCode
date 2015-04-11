#include <stdio.h>
#include <string.h>

//Constants
#define KEYSIZE 6 //key WITH '\0'

//Function prototypes
void getMessage(char* message, FILE *input);
char decrypt(char enc, char key);
int getSize(FILE *file);

main() {
  char *message; 
  char key[KEYSIZE] = "loser";
  int i, length;
  FILE *enc = fopen("encrypted.txt", "r");
  FILE *plain = fopen("plain.txt", "w");

  //Setting up message buffer.
  message = malloc(1000);
  getMessage(message, enc);
  length = getSize(enc);

  //Converting the ciphertext to plaintext
  for(i = 0; i < length; i++) message[i] = decrypt(message[i], key[i % KEYSIZE]);

  //Writing message into file
  for(i = 0; i < length; i++) fputc(message[i], plain);

  printf("Decryption finished.\n");
} //End main()

//Copies the file into the character buffer
void getMessage(char* message, FILE *input) {
  int n, character;

  while((character = fgetc(input)) != EOF) {
    message[n++] = (char) character;
  }
} //End getMessage()

//returns decrypted char
char decrypt(char enc, char key) {
  return enc ^ key;
} //End encrypt()

//returns the size of the file in bytes
int getSize(FILE *file) {
  int n;

  fseek(file, 0, SEEK_END);
  n = ftell(file);
  fseek(file, 0, SEEK_SET);
  
  return n;
} //End getSize()
