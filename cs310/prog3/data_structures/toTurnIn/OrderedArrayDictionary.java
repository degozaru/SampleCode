/*Masc0264
 *Vincent Chan
 */
package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class OrderedArrayDictionary<K,V> implements DictionaryADT<K,V> {
  
  /**Node Wrapper Class********************************/
  /**                                                **/
  class Node<K,V> implements Comparable<Node<K,V>> {
    K key;
    V value;
    public Node(K k, V v) {
      key = k;
      value = v;
    }
    public int compareTo(Node<K,V> node) {
      return ((Comparable<K>)key).compareTo((K)node.key);
    }
  }
  /**                                                **/
  /****************************************************/
  
  /**Variables***************************/
  /*                                    */
  private int size;
  private int maxSize;
  private long modCtr;
  private Node<K,V>[] nodeArray;
  /*                                    */
  /**************************************/
  
  //Constructor
  public OrderedArrayDictionary(int max) {
    size = 0;
    modCtr = 0;
    maxSize = max;
    nodeArray = new Node[maxSize];
  } //End constructor

  //Returns true of the object is in the array
  public boolean contains(K key) {
    return getIdx(new Node<K,V>(key,null), 0, size-1)!=-1;
  } //End contains()

  //Inserts a new object into the priority queue.
  //Returns False if the queue is full.
  public boolean add(K key, V value) {
    if(isFull()||contains(key)) return false;
    Node<K,V> toAdd = new Node<K,V>(key,value);
    int insertLoc = find(toAdd, 0, size-1);
    for(int i=size; i>insertLoc; i--) nodeArray[i] = nodeArray[i-1];
    nodeArray[insertLoc] = toAdd;
    size++;
    modCtr++;
    return true;
  } //End insert()

  //Returns true if deleted value
  //returns false if cant find the key to delete
  public boolean delete(K key) {
    int index = getIdx(new Node<K,V>(key,null), 0, size-1);
    if(index==-1) return false;
    for(; index<size-1; index++) nodeArray[index] = nodeArray[index+1];
    size--;
    modCtr++;
    return true;
  } //End delete()

  //Gets the value of the key. Returns false if cant find.
  public V getValue(K key) {
    int index = getIdx(new Node<K,V>(key,null), 0, size-1);
    if(index==-1) return null;
    return (V) nodeArray[index].value;
  } //End getValue()

  //Returns the key associated with the value.
  //Returns the first one found, and null if not found.
  public K getKey(V value) {
    for(int i=0; i<size; i++)
      if(((Comparable<V>)nodeArray[i].value).compareTo(value)==0)
        return nodeArray[i].key;
    return null;
  } //End getKey()

  //Returns the current size.
  public int size() {
    return size;
  } //End size()

  //Clears the array and replaces it with a new one.
  public void clear() {
    size = 0;
    nodeArray = new Node[maxSize];
  } //End clear()

  //Returns true if the array is empty.
  public boolean isEmpty() {
    return size==0;
  } //End isEmpty()

  //Returns true if the array is full.
  public boolean isFull() {
    return size==maxSize;
  } //End isFull()

  //This will return the index of where an element should be inserted
  private int find(Node<K,V> obj, int low, int hi) {
    //Termination condition: Found the insertion point.
    if(hi<low) return low;

    //Compare the middle of the array to the sought object
    int mid = (low+hi)/2;
    int comp = ((Comparable<Node<K,V>>)obj).compareTo(nodeArray[mid]);

    //If not found, recursively call the function with a refined search area.
    return (comp>0)?find(obj, low, mid-1) : find(obj, mid+1, hi);
  } //End find()

  //Gets the index of a node. Returns -1 if it is nonexistant
  private int getIdx(Node<K,V> obj, int low, int hi) {
    if(hi<low) return -1;
    int mid = (low+hi)/2;
    int comp = ((Comparable<Node<K,V>>)obj).compareTo(nodeArray[mid]);
    if(comp==0) return mid;
    //If not found, recursively call the function with a refined search area.
    return (comp>0)?getIdx(obj, low, mid-1) : getIdx(obj, mid+1, hi);
  } //End getIdx()


  /**Iterators*******************************/
  /**                                      **/
  public Iterator<K> keys() {
    return new KeyIter();
  }
  public Iterator<V> values() {
    return new ValIter();
  }
  abstract class IteratorHelper<E> implements Iterator<E> {
    int iterIndex;
    long modChk;
    public IteratorHelper() {
      modChk = modCtr;
      iterIndex = size-1;
    }
    public boolean hasNext() {
      if(modChk!=modCtr)
        throw new ConcurrentModificationException();
      return iterIndex>=0;
    }
    abstract public E next();
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  class KeyIter<K> extends IteratorHelper<K> {
    public KeyIter() {
      super();
    }
    public K next() {
      if(modChk!=modCtr)
        throw new ConcurrentModificationException();
      return (K)nodeArray[iterIndex--].key;
    }
  }
  class ValIter<V> extends IteratorHelper<V> {
    public ValIter() {
      super();
    }
    public V next() {
      if(modChk!=modCtr)
        throw new ConcurrentModificationException();
      return (V)nodeArray[iterIndex--];
    }
  }
  /**                                      **/
  /******************************************/
} //End OrderedArrayPrior-- I mean, End OrderedArrayDictionary :)
