#include <stdio.h>
#include <wiringPi.h>

#define LED 1

main() {
  //Run the initialization for the output
  setup();

  //This will blink the led at second intervals
  while(1) {
    digitalWrite(LED, 1);
    delay(1000);
    digitalWrite(LED, 0);
    delay(1000);
  }
} //End main()

//This is the setup function to set up the Pi for this program.
void setup() {
  if(wiringPiSetup() == -1) exit();
  pinMode(LED, output);
} //End setup()
