/* Vincent Chan
 * masc0264
 */

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

/*Unordered Linked List
 * This is an unordered linked list data structure.
 * It will manage data by adding data to the start
 * or end of the stack. It will not order the objects.
 *
 * Supported Constructors:
 *    Default
 *
 * Supported Insertions:
 *    Front insertion
 *    End insertion
 *
 * Supported Removals:
 *    Remove first
 *    Remove by object
 *    Remove by index
 */

public class UnorderedList<E> implements Iterable<E>{
  /* Functions Included
   * ====PUBLIC====
   * Constructor        //Ln. 58
   * addFirst(object)   //Ln. 64
   * addLast(object)    //Ln. 77
   * removeFirst()      //Ln. 88
   * find(object)       //Ln. 98
   * remove(object)     //Ln. 108
   * isEmpty()          //Ln. 129
   * size()             //Ln. 134
   * iterator()         //Ln. 139
   */

  //Variable declarations
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

  //Constructors
  public UnorderedList() {
    size = 0;
    modifyCtr = 0;
  } //End constructors

  //Add in front of the list
  public void addFirst(E obj) {
    Node<E> newNode = new Node(obj);
    if(isEmpty())
      head = tail = newNode;
    else {
      newNode.next = head;
      head = newNode;
    }
    size++;
    modifyCtr++;
  } //End addFirst()

  //Add to the back of the list.
  public void addLast(E obj) {
    Node<E> newNode = new Node(obj);
    if(isEmpty())
      head = tail = newNode;
    else
      tail = tail.next = newNode;
    size++;
    modifyCtr++;
  } //End addLast()

  //Remove the first element
  public E removeFirst() {
    if(isEmpty()) return null;
    E temp = head.data;
    head = head.next;
    size--;
    modifyCtr++;
    return temp;
  } //End removeFirst()

  //Find the specified object
  public E find(E obj) {
    Node<E> current = head;
    while(current != null)
      if(((Comparable<E>)obj).compareTo(current.data)==0)
        return (E)current.data;
      else current = current.next;
    return null;
  } //End find()

  //Returns true if object is inside the list
  public boolean contains(E obj) {
   return find(obj)!=null;
  } //End contains()

  //Remove the specified object
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

  //Returns true if empty
  public boolean isEmpty() {
    return size == 0;
  } //End isEmpty()

  //Returns the size
  public int size() {
    return size;
  } //End size()

  //Returns an iterator for iteration
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
} //End UnorderedList
