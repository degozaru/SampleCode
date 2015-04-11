import data_structures.*;

import java.util.*;

public class Test {
  public static void main(String args[]) {
    DictionaryADT<Integer,Integer> dictionary = new BinarySearchTree<Integer,Integer>();
  Random gen = new Random(1337);
  int[] array = new int[10];
  Integer[] theArr= new Integer[10];
  array[0] =5;
  array[1] =7;
  array[2] =8;
  array[3] =4;
  array[4] =3;
  array[5] =1;
  array[6] =2;
  array[7] =6;
  array[8] =9;
  array[9] =10;
  for(int i=0; i<10; i++) { 
    theArr[i] = new Integer(array[i]);
    dictionary.add(theArr[i],theArr[i]);
  }
  for(int i=0; i<10; i++) {
	  try {
    dictionary.delete(theArr[i]);
	  }
	  catch(Exception e) {
		  System.out.println("Exception at index "+ i);
	  }
	  }
  System.out.println(dictionary.size());
  }
}