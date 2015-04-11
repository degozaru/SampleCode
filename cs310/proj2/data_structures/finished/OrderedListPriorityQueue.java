/* Vincent Chan
 * masc0264
 */
package data_structures;

import java.util.Iterator;

public class OrderedListPriorityQueue<E> implements PriorityQueue<E>{
  /* Functions Included
   * ====PUBLIC====
   * Constructor        //Ln. 26
   * insert(object)     //Ln. 31
   * remove()           //Ln. 38
   * peek()             //Ln. 44
   * contains(object)   //Ln. 51
   * size()             //Ln. 57
   * clear()            //Ln. 62
   * isEmpty()          //Ln. 67
   * isFull()           //Ln. 72
   * iterator()         //Ln. 78
   */
   
  //Variable Declarations
  OrderedList<E> list;

  //Constructor
  public OrderedListPriorityQueue() {
    list = new OrderedList();
  } //End Constructor

  //Inserts a new object into the queue.
  //Returns true if insertion successful
  public boolean insert(E object) {
    list.insert(object);
    return true;
  } //End insert()

  //Removes the highest priority object
  //in the queue the longest.
  public E remove() {
    return list.pop();
  } //End remove()

  //Returns the object of the highest priority
  //that has been in the queue the longest
  //but does not remove it.
  public E peek() {
    return list.peek();
  } //End peek()

  //Returns true of the priority queue contains
  //specified element
  public boolean contains(E obj) {
    return list.contains(obj);
  } //End contains()

  //Returns the size of the list
  public int size() {
    return list.size();
  } //End size()

  //Returns the PQ to an empty state
  public void clear() {
    list = new OrderedList();
  } //End clear()

  //Returns true if the queue is empty
  public boolean isEmpty() {
    return list.isEmpty();
  } //End isEmpty()

  //Returns true if the queue is full.
  //Lists always return false.
  public boolean isFull() {
    return false;
  } //End isFull()

  //Returns an Iterator of the queue.
  public Iterator<E> iterator() {
    return list.iterator();
  } //End iterator()
} //End OrderedListPriorityQueue
