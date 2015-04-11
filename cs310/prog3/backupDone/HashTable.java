package data_structures;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class HashTable<K,V> implements DictionaryADT<K,V> {
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
  private int tableSize;
  private long modCtr;
  private UnorderedList<Node<K,V>>[] list;
  /*                                    */
  /**************************************/

  //The constructor will take one paramater:
  //max size. The hash table will be approx 1.3
  //times bigger than the max size to allow for better
  //hashing with less collusions.
  public HashTable(int n) {
    size = 0;
    maxSize = n;
    modCtr = 0;
    tableSize = (int)(maxSize*1.3f);
    list = new UnorderedList[tableSize];
    for(int i=0; i<tableSize; i++)
      list[i] = new UnorderedList<Node<K,V>>();
  } //End constructor

  //Returns true if the dictionary has the key identified
  public boolean contains(K key) {
    return list[hash(key)].contains(new Node<K,V>(key,null));
  } //End contains()

  //Adds the given key/value pair to the dictionary.
  //Returns  false if dictionary is full or if key is existant.
  public boolean add(K key, V value) {
    if(isFull() || list[hash(key)].contains(new Node<K,V>(key, null)))
      return false;
    list[hash(key)].addLast(new Node<K,V>(key, value));
    size++;
    modCtr++;
    return true;
  } //End add()

  //Will delete the key. Returns false if not found.
  public boolean delete(K key) {
    if(!list[hash(key)].contains(new Node<K,V>(key, null)))
      return false;
    size--;
    modCtr++;
    return list[hash(key)].remove(new Node<K,V>(key, null))!=null;
  } //End delete()

  //Returns the value of the associated key.
  //Returns null if the key is not found.
  public V getValue(K key) {
    Node tmp = list[hash(key)].find(new Node<K,V>(key, null));
    return (tmp==null)?null : (V)tmp.value;
  } //End getValue()

  //Return the key associated with the parameter value.
  //returns null if not found, returns the first match.
  public K getKey(V value) {
    for(int i=0; i<tableSize; i++)
      for(Node current : list[i])
        if(((Comparable<V>)value).compareTo((V)current.value)==0)
          return (K)current.key;
    return null;
  } //End getKey()

  //Returns the size of the array.
  public int size() {
    return size;
  } //End size()

  //Returns true if the dictionary is at max capacity
  public boolean isFull() {
    return size==maxSize;
  } //End isFull()

  //Returns true if the dictionary is empty.
  public boolean isEmpty() {
    return size==0;
  } //End isEmpty()

  //Returns the dictionary object to an empty state
  public void clear() {
    for(int i=0; i<tableSize; i++)
      list[i] = new UnorderedList<Node<K,V>>();
    size = 0;
    modCtr++;
  } //End clear()

  //Private auxiliary function for hashing the key.
  private int hash(K key) {
    return (key.hashCode()&0x7fffffff)%tableSize;
  } //End hash()
  /**Iterator Utilities**************************/
  /**                                          **/
  public Iterator<K> keys() {
    return new KeyIter();
  }
  public Iterator<V> values() {
    return new ValueIter();
  }
  abstract class MainIterator<E> implements Iterator<E> {
    protected Node<K,V> [] nodes;
    protected int index;
    protected long modChk;
    public MainIterator() {
      nodes = new Node[size];
      index = 0;
      modChk = modCtr;
      int j = 0;
      for(int i=0; i<tableSize; i++)
        for(Node current : list[i])
          nodes[j++] = current;
      sort(nodes, 0, size-1);
    }
    public boolean hasNext() {
      if(modChk!=modCtr)
        throw new ConcurrentModificationException();
      return index<size;
    }
    public abstract E next();
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
  class KeyIter<K> extends MainIterator<K> {
    public KeyIter() {
      super();
    }
    public K next() {
      return (K)nodes[index++].key;
    }
  }
  class ValueIter<V> extends MainIterator<V> {
    public ValueIter() {
      super();
    }
    public V next() {
      return (V)nodes[index++].value;
    }
  }
  /**                                          **/
  /**********************************************/

  //This will sort the array via shell sort.
  private void sort(Node<K,V>[] array, int start, int last) {
    int toSort, current;
    int gap = 1;
    int length = last-start+1;
    Node<K,V> temp;
      
    //Calculate the gaps using the Knuth's sequence
    while(gap<=length/3) gap = gap*3+1;
    //Sort the array
    while(gap>0) {
      //Sort with the given gap
      for(toSort=start+gap; toSort<last+1; toSort++) {
        temp = array[toSort];
        current = toSort;
        //Shift the array over until we find the place to insert the temp
        while(current>start+gap-1 && 
            ((Comparable<Node<K,V>>)temp).compareTo(array[current-gap])<=0) {
          array[current] = array[current-gap];
          current -= gap;
        }
        array[current] = temp;
      }
      //Reduce the gap and resort using the new gap.
      gap = (gap-1)/3;
    }
  }
} //End HashTable
