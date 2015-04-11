/*
 * BitManipulations.c
 *
 *  Created on: Feb 8, 2013
 *      Author: yozturk
 */

#include <stdio.h>
#include "BitManipulations.h"



void main(int *argc, char **argv)
{
	uint32_t Number;
	uint32_t bitPosition;
	uint32_t value;


	value = 0;
	bitPosition = 30;
	Number = 15345;

  printf("Binary number:");
	writeinBinary(Number) ; // Print the number  in Binary
  printf("\ninverted:");
	invertBits(&Number); 	// Take 1's complement of the Number

	writeinBinary(Number) ; // Print the number  in Binary
  printf("\nsetbit:");
	setBit(&Number, bitPosition,value); // set bit in bitposition to value

	writeinBinary(Number) ; // Print the number  in Binary
  printf("\n");



}

