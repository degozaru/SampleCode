import data_structures.*;

import java.util.*;

public class Test {
  public static void main(String args[]) {
    DictionaryADT<Integer,Integer> dictionary = new BinarySearchTree<Integer,Integer>();
  Random gen = new Random(1337);
  Integer[] array = new Integer[150000];
  for(int i=0; i<150000; i++) { 
    array[i] = new Integer(gen.nextInt());
    dictionary.add(array[i],array[i]);
  }
  for(int i=0; i<150000; i++) {
    dictionary.delete(array[i]);
  }
  System.out.println(dictionary.size());
  }
}
