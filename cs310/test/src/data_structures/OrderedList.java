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
 */

public class OrderedList<E> implements Iterable<E>{

  Node<E> head, tail;
  int size;
  long modifyCtr;

  class Node<T> {
    T data;
    Node<T> next;

    public Node(T obj) {
      data = obj;
      next = null;
    }
  } //End Node class

  public OrderedList() {
    size = 0;
    modifyCtr = 0;
  } 

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
          }
          else {
            previous.next = newNode;
            newNode.next = current;
          }
        previous = current;
        current = current.next;
      }
      if(current==null) 
        tail.next = tail = newNode;
    }
    size++;
    modifyCtr++;
  }


  public E pop() {
    E temp = head.data;
    head = head.next;
    size--;
    modifyCtr++;
    return temp;
  }

  public E peek() {
    return head.data;
  }

  public boolean contains(E obj) {
    for(E current : this) 
      if(((Comparable<E>)obj).compareTo(current)==0)
        return true;
    return false;
  }

   public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public Iterator<E> iterator() {
    return new IteratorHelper();
  }

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
} //End OrderedList class
