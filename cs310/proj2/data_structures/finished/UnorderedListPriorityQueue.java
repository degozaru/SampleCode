/* Vincent Chan
 * masc0264
 */
package data_structures;

import java.util.Iterator;

public class UnorderedListPriorityQueue<E> implements PriorityQueue<E> {
  /* Functions Included
   * ====PUBLIC====
   * constructors       //Ln. 26
   * insert(object)     //Ln. 31
   * remove()           //Ln. 37
   * peek()             //Ln. 43
   * contains(Object)   //Ln. 63
   * size()             //Ln. 68
   * clear()            //Ln. 73
   * isEmpty()          //Ln. 78
   * isFull()           //Ln. 83
   * iterator()         //Ln. 89
   */

  //Variable declarations
  UnorderedList<E> list;

  //Constructor
  public UnorderedListPriorityQueue() {
    list = new UnorderedList<E>();
  } //End constructor

  //Inserts a new object. Returns true if insertion is succesful
  public boolean insert(E object) {
    list.addFirst(object);
    return true;
  } //End insert()

  //Removes the object with highest priority
  //Returns null if the list is empty
  public E remove() {
    return list.remove(peek());
  }//End remove()

  //Gets the object with the highest priority
  //the longest but does NOT remove it.
  //returns null if empty
  public E peek() {
    if(list.isEmpty()) return null;
    int comp;
    E lowPri = null;
    for(E current : list) {
      if(lowPri==null) {
        lowPri = current;
        continue;
      }
      comp = ((Comparable<E>)lowPri).compareTo(current);
      if(comp>0) {
        lowPri = current;
      }
    }
    return lowPri;
  } //End peek()

  //Returns true if the queue contains the specified element
  public boolean contains(E obj) {
    return list.find(obj)!=null;
  } //End contains()

  //Returns the number of objects in the queue.
  public int size() {
    return list.size();
  }

  //returns to an empty list.
  public void clear() {
    list = new UnorderedList<E>();
  } //End clear()

  //Returns true if queue is empty
  public boolean isEmpty() {
    return list.isEmpty();
  } //End isEmpty()

  //Returns true if full. otherwise false.
  //Linked lists are never full.
  public boolean isFull() {
    return false;
  } //End isFull()

  //Returns an iterator of the objects in the PQ,
  public Iterator<E> iterator() {
    return list.iterator();
  } //End iterator()
} //End UnorderedListPriorityQueue
