import java.util.*;

public class SimpleQueue<E> implements Queue<E> {

  /* Table of contents for SimpleQueue:
   * Constructor  //Ln. 24
   * add()        //Ln. 32
   * remove()     //Ln. 41
   * poll()       //Ln. 51
   * clear()      //Ln. 57
   * size()       //Ln. 64
   * toArray()    //Ln. 70
   * peek()       //Ln. 78
   * element()    //Ln. 83
   * isEmpty()    //Ln. 89
   * expandList() //Ln. 94
   * UnusedMethod //Ln. 105
   */

  //Variable declarations
  private int head, tail, size;
  private E[] queue;

  //This is the constructor for SimpleQueue
  public SimpleQueue() {
    queue= (E[])new Object[5]; 
    size = 5;
    head = 0;
    tail = 0;
  } //End constructor

  /* This will add the item to the queue
     Will return true when the item has been sucessfully added. */
  public boolean add(E itemToAdd) {
    queue[tail] = itemToAdd;
    tail = ++tail % size;
    if(tail == head) expandList();
    return true;
  } //End add()

  /* Pops the item off the queue and adjusts the head accordingly.
     Returns exception if empty */
  public E remove() {
    if(isEmpty()) throw new IllegalArgumentException("Empty List");
    E temp = queue[head];
    queue[head] = null;
    head = ++head % size;
    return temp;
  } //End remove()

  //Pops the item off the queue and returns null if empty
  public E poll() {
    if(isEmpty()) return null;
    return remove();
  } //End poll() 

  //This will clear the array
  public void clear() {
    queue = (E[]) new Object[size];
    head = 0;
    tail = 0;
  } //End clear()

  //This will return the array size as an int
  public int size() {
    if(isEmpty()) return 0;
    return (tail > head) ? (tail - head) : (size - head + tail);
  } //End size()

  //This will return the array
  public E[] toArray() {
    if(isEmpty()) return (E[])new Object[size()];
    E[] temp = (E[])new Object[size()];
    for(int i=0; i < size(); i++) temp[i] = queue[(head + i) % size]; 
    return temp;
  } //End toArray()

  //Return but not remove the head. Returns null if empty
  public E peek() {
    return queue[head];
  } //End peek()

  //Returns but not remove the head. Throws exception if empty
  public E element() {
    if(isEmpty()) throw new NoSuchElementException("Empty queue");
    return peek();
  } //End element()

  //Returns true if the array is empty, false if not
  public boolean isEmpty() {
    return queue[head] == null;
  } //End isEmpty()

  //Expands the list.
  private void expandList() {
    E[] temp = (E[]) new Object[size*2];
    for(int i=0; i < size(); i++) temp[i] = queue[(head + i) % size()]; 
    tail = size();
    head = 0;
    size *= 2;
    queue = temp;
    System.gc(); //Reccomend a g.collection
  } //End expandList()

  /* This is going to be used for testing.
   * Will add itemToAdd to list defined by times
   * Will be commented out on code submission
   */
  public void stressTest(int times, E itemToAdd) {
    if(times == 0) return;
    add(itemToAdd);
    stressTest(times - 1, itemToAdd); // :^)
  } //End stressTest()

  //These are the unused methods
  public boolean remove(Object arg0) 
    {throw new UnsupportedOperationException();}
  public boolean removeAll(Collection<?> arg0) 
    {throw new UnsupportedOperationException();}
  public Iterator<E> iterator() 
    {throw new UnsupportedOperationException();}
  public boolean addAll(Collection<? extends E> arg0) 
    {throw new UnsupportedOperationException();}
  public boolean containsAll(Collection<?> arg0) 
    {throw new UnsupportedOperationException();}
  public boolean retainAll(Collection<?> arg0) 
    {throw new UnsupportedOperationException();}
  public boolean offer(E arg0) 
    {throw new UnsupportedOperationException();}
  public <T> T[] toArray(T[] arg0) 
    {throw new UnsupportedOperationException();}
  public boolean contains(Object o) 
    {throw new UnsupportedOperationException();}
  //End unused methods

} //End SimpleQueue()
