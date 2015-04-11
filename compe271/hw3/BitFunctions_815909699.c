#include "BitManipulations.h"

void invertBits(uint32_t *intData) {
  *intData = ~(*intData);
} //End invertBits()

void writeinBinary(uint32_t inData) {
  int i;
  for(i=31; i>=0; i--)
    printf("%d", (inData>>i)%2);
} //End writeinBinary()

void setBit(uint32_t *inData, uint32_t bitPosition, uint32_t value) {
  *inData = (value==0)?*inData&~(1<<bitPosition-1) : *inData|(1<<bitPosition-1);
} //End setBit()
