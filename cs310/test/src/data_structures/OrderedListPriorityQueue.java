package data_structures;

import java.util.Iterator;

public class OrderedListPriorityQueue<E> implements PriorityQueue<E>{
  OrderedList<E> list;

  //Constructor
  public OrderedListPriorityQueue() {
    list = new OrderedList();
  }

  //Inserts a new object into the queue.
  //Returns true if insertion successful
  public boolean insert(E object) {
    list.insert(object);
    return true;
  }

  //Removes the highest priority object
  //in the queue the longest.
  public E remove() {
    return list.pop();
  }

  //Returns the object of the highest priority
  //that has been in the queue the longest
  //but does not remove it.
  public E peek() {
    return list.peek();
  }

  //Returns true of the priority queue contains
  //specified element
  public boolean contains(E obj) {
    return list.contains(obj);
  }

  //Returns the size of the list
  public int size() {
    return list.size();
  }

  //Returns the PQ to an empty state
  public void clear() {
    list = new OrderedList();
  }

  //Returns true if the queue is empty
  public boolean isEmpty() {
    return list.isEmpty();
  }

  //Returns true if the queue is full.
  //Lists always return false.
  public boolean isFull() {
    return false;
  }

  //Returns an Iterator of the queue.
  public Iterator<E> iterator() {
    return list.iterator();
  }
}
