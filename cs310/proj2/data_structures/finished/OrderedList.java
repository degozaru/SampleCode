/* Vincent Chan
 * masc0264
 */

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/*Ordered Linked List
 * This is an ordered linked list data structure.
 * It will organize data by ascending order.
 *
 * Supported Constructors:
 *    Default
 *
 * Supported Insertions:
 *    Insertion
 *
 * Supported Removals:
 *    Remove first
 *    Remove by object
 */

public class OrderedList<E> implements Iterable<E>{
  /*Functions Included
   * ====PUBLIC====
   * Constructors       //Ln. 57
   * insert(object)     //Ln. 63
   * remove(object)     //Ln. 94
   * pop()              //Ln. 116
   * peek()             //Ln. 127
   * contains(object)   //Ln. 133
   * find(object)       //Ln. 141
   * isEmpty()          //Ln. 151
   * size()             //Ln. 157
   * Iterator()         //Ln. 162
   */

  //Variable declarations
  Node<E> head, tail;
  int size;
  long modifyCtr;

  //Node class for the linked list
  class Node<T> {
    T data;
    Node<T> next;

    public Node(T obj) {
      data = obj;
      next = null;
    }
  } //End Node class

  //Constructors
  public OrderedList() {
    size = 0;
    modifyCtr = 0;
  } //End constructors

  //This will insert the object
  //Ordered by ascending order defined by
  //the comparable interface.
  public void insert(E obj) {
    Node<E> newNode = new Node(obj);
    if(isEmpty()) head = tail = newNode;
    else {
      Node<E> previous = null;
      Node<E> current = head;
      while(current!=null) {
        if(((Comparable<E>)obj).compareTo(current.data)<0) 
          if(previous==null) {
            newNode.next = current;
            head = newNode;
            break;
          }
          else {
            previous.next = newNode;
            newNode.next = current;
            break;
          }
        previous = current;
        current = current.next;
      }
      if(current==null) 
        tail.next = tail = newNode;
    }
    size++;
    modifyCtr++;
  } //End insert

    //This will remove the object if it is contained
  //in the list. Null otherwise.
  public E remove(E obj) {
    Node<E> previous = null;
    Node<E> current = head;
    while(current != null)
      if(((Comparable<E>)obj).compareTo(current.data)==0) {
        if(previous != null)
          previous.next = current.next;
        else
          head = current.next;
        size--;
        modifyCtr++;
        return current.data;
      }
      else {
        previous = current;
        current = current.next;
      }
    return null;
  } //End remove() 

  //This will pop out the first element
  //in the list. Null if is empty.
  public E pop() {
    if(isEmpty()) return null;
    E temp = head.data;
    head = head.next;
    size--;
    modifyCtr++;
    return temp;
  } //End pop()

  //This will return but not remove
  //the first element of the list.
  public E peek() {
    return (isEmpty())? null : head.data;
  } //End peek()

  //Returns true if the list contains the element
  public boolean contains(E obj) {
    for(E current : this) 
      if(((Comparable<E>)obj).compareTo(current)==0)
        return true;
    return false;
  } //End contains()

  //This will find and return the object
  //if it is contained in the list.
  //Null otherwise.
  public E find(E obj) {
    for(E current : this) 
      if(((Comparable<E>)obj).compareTo(current)==0)
        return obj;
    return null;
  } //End find()

  //This will return true if the
  //list contains nothing.
  public boolean isEmpty() {
    return size == 0;
  } //End isEmpty()

  //Returns the size of the list.
  public int size() {
    return size;
  } //End size()

  //This returns an iterator for iteration
  public Iterator<E> iterator() {
    return new IteratorHelper();
  } //End iterator()

  class IteratorHelper implements Iterator<E> {
    private long lastMod;
    Node<E> current;

    public IteratorHelper() {
      lastMod = modifyCtr;
      current = head;
    }

    public boolean hasNext() {
      return current != null;
    }

    public E next() {
      if(lastMod != modifyCtr)
        throw new ConcurrentModificationException();
      if(!hasNext())
        throw new NoSuchElementException();
      E data = current.data;
      current = current.next;
      return data;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
} //End OrderedList
