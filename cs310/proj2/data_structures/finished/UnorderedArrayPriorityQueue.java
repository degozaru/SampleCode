/* Vincent Chan
 * masc0264
 */
package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class UnorderedArrayPriorityQueue<E> implements PriorityQueue<E> {

  /* Functions Included
   * ====PUBLIC====
   * constructors       //Ln.30
   * insert(object)     //Ln.40
   * remove()           //Ln.47
   * peek()             //Ln. 68
   * contains(Object)   //Ln. 83
   * size()             //Ln. 91
   * clear()            //Ln. 96
   * isEmpty()          //Ln. 102
   * isFull()           //Ln. 107
   * iterator()         //Ln. 112
   */

  // Variable Declarations
  private int size, maxSize, modCtr;
  private E[] vectorArray = (E[])new Object[DEFAULT_MAX_CAPACITY];

  //Constructor
  public UnorderedArrayPriorityQueue() {
    size = modCtr = 0;
    maxSize = DEFAULT_MAX_CAPACITY;
  } //End constructor
  public UnorderedArrayPriorityQueue(int max) {
    size = modCtr = 0;
    maxSize = max;
  } //End constructor

  //Insert will insert an object at the end of the array.
  public boolean insert(E object) {
    if(isFull()) return false;
    vectorArray[size++] = object;
    return true;
  } //End insert()

  //Will remove the highest priority object.
  //Ties are broken by which was inserted first.
  public E remove() {
    if(isEmpty()) return null;
    int lastIndex = 0;
    
    //Finding what to remove: compare priority.
    int comp;
    for(int i=1; i<size; i++) {
      comp=((Comparable<E>)vectorArray[lastIndex]).compareTo(vectorArray[i]);
      if(comp>0) lastIndex = i;
    }

    //Cleanup and retrun: Shift array and return object.
    E temp = vectorArray[lastIndex];
    size--;
    for(;lastIndex<size;lastIndex++)
      vectorArray[lastIndex] = vectorArray[lastIndex+1];
    return temp;
  } //End remove()

  //Returns object of highest priority,
  //does NOT remove it.
  public E peek() {
    if(isEmpty()) return null;
    int lastIndex = 0;

    int comp;
    for(int i=1; i<size; i++) {
      comp=((Comparable<E>)vectorArray[lastIndex]).compareTo(vectorArray[i]);
      if(comp>0) lastIndex = i;
    }

    return vectorArray[lastIndex];
  } //End peek()

  //Will check the queue to see if
  //the specified object is a component.
  public boolean contains(E obj) {
    for(int i=0; i<size; i++) 
      if(((Comparable<E>)obj).compareTo(vectorArray[i])==0) return true;
    return false;
  } //End contains()

  //Returns the current size of the queue.
  public int size() {
    return size;
  } //End size()

  //Clears the queue.
  public void clear() {
    vectorArray = (E[])new Object[maxSize];
    size = 0;
  } //End clear()

  //Returns true if queue is empty.
  public boolean isEmpty() {
    return size==0;
  } //End isEmpty()

  //Returns true if the queue is full.
  public boolean isFull() {
    return size == maxSize;
  } //End isFull()

  //Returns an iterator to use for iterating
  public Iterator<E> iterator() {
    return new IteratorHelper();
  } //End iterator()

  class IteratorHelper implements Iterator<E> {
    int iterIndex;
    int modChk;

    public IteratorHelper() {
      iterIndex = 0;
      modChk = modCtr;
    }

    public boolean hasNext() {
      return iterIndex<size;
    }

    public E next() {
      if(!hasNext()) throw new NoSuchElementException();
      if(modCtr != modChk) throw new ConcurrentModificationException();
      return vectorArray[iterIndex++];
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
} //End UnorderedListPriorityQueue
