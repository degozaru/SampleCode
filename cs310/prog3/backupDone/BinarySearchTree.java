/*Masc0264
 *Vincent Chan
 */
package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class BinarySearchTree<K,V> implements DictionaryADT<K,V> {
  /**Node class***********************************/
  /**                                           **/
  class Node<K,V> implements Comparable<Node<K,V>> {
    K key;
    V value;
    Node<K,V> left, right;
    public Node(K k, V v) {
      key = k;
      value = v;
      left = right = null;
    }
    public int compareTo(Node<K,V> that) {
      return ((Comparable<K>)key).compareTo(that.key);
    }
  }
  /**                                           **/
  /***********************************************/

  /**Variables******************/ 
  /**                         **/
  private int size;
  private long modCtr;
  private Node<K,V> root;
  /**                         **/
  /*****************************/

  //Constructor
  public BinarySearchTree() {
    size = 0;
    modCtr = 0;
    root = null;
  } //End constructor

  //Returns ture if the dictionary has an object identified.
  public boolean contains(K key) {
    Node<K,V> find = new Node<K,V>(key, null);
    Node<K,V> current = root;
    int comp;
    while(current!=null) {
      comp = ((Comparable<Node<K,V>>)current).compareTo(find);
      if(comp==0) return true;
      current = (comp>0)?current.left : current.right;
    }
    return false;
  } //End contains()

  //Adds the specified element to the dictionary. Returns true on successful addition.
  //Returns false if failed because of duplicate.
  public boolean add(K key, V value) {
    Node<K,V> toAdd = new Node<K,V>(key, value);
    Node<K,V> current = root;
    Node<K,V> previous = null;
    int comp = 0;
    if(isEmpty()) root = toAdd;
    else {
      while(current!=null) {
        comp = ((Comparable<Node<K,V>>)current).compareTo(toAdd);
        if(comp==0) return false;
        previous = current;
        current = (comp>0)?current.left : current.right;
      }
      if(comp>0) previous.left = toAdd;
      else previous.right = toAdd;
    }
    size++;
    modCtr++;
    return true;
  } //End add()
  
  //Removes the specified element. Returns ture on succesful deletion.
  public boolean delete(K key) {
    if(!contains(key)) return false;
    Node<K,V> toDel = new Node<K,V>(key,null);
    Node<K,V> previous = null;
    Node<K,V> current = root;
    while(((Comparable<Node<K,V>>)current).compareTo(toDel)!=0) {
      previous = current;
      current = 
        (((Comparable<Node<K,V>>)current).compareTo(toDel)>0) ? 
        current.left : current.right;
    }
    //Case 1: leaf node
    if(current.left==null && current.right==null) {
      if(previous==null) root = null;
      else if (((Comparable<Node<K,V>>)toDel).compareTo(previous)<0)
        previous.left = null;
      else previous.right = null;
      size--;
      modCtr++;
      return true;
    }
    //Case 2: one child
    else if(current.left==null) {
      if(previous==null) root = current.right;
      else if (((Comparable<Node<K,V>>)toDel).compareTo(previous)<0)
        previous.left = current.right;
      else previous.right = current.right;
      size--;
      modCtr++;
      return true;
    }
    else if(current.right==null) {
      if(previous==null) root = current.left;
      else if (((Comparable<Node<K,V>>)toDel).compareTo(previous)<0)
        previous.left = current.left;
      else previous.right = current.left;
      size--;
      modCtr++;
      return true;
    }
    //Case 3: 2 children
    else {
      Node<K,V> min = findMin(current);
      delete(min.key);
      current.key=min.key;
      current.value=min.value;
      return true;
    }
  } //End delete()

  //Finds the predecessor or prodecessor node.
  private Node<K,V> findMin(Node<K,V> current) {
    Node<K,V> cur;
    Node<K,V> next;
    if(modCtr%2==0) {
      cur = current.right;
      next = cur.left;
      while(next!=null) {
        cur = next;
        next = next.left;
      }
    }
    else {
      cur = current.left;
      next = cur.right;
      while(next!=null) {
        cur = next;
        next = next.right;
      }
    }
    return cur;
  } //End findMin()

  //Returns the value of the given key.
  //Returns null if nonexistant.
  public V getValue(K key) {
    Node<K,V> find = new Node<K,V>(key, null);
    Node<K,V> current = root;
    int comp;
    while(current!=null) {
      comp = ((Comparable<Node<K,V>>)current).compareTo(find);
      if(comp==0) return (V)current.value;
      current = (comp>0)?current.left : current.right;
    }
    return null;
  } //End getValue()

  //Returns a key associated with the parameter value.
  //Returns null if now found.
  public K getKey(V value) {
    return findKey(root, value);
  } //End getKey()
  private K findKey(Node<K,V> current, V value) {
    if(current==null) return null;
    K key = findKey(current.left, value);
    if(key!=null) return (K)key;
    else if(((Comparable<V>)current.value).compareTo(value)==0)
      return (K)current.key;
    else return findKey(current.right, value);
  } //End findKey

  //returns the size.
  public int size() {
    return size;
  } //End size()

  //Returns false always because bsts are never full
  public boolean isFull() {
    return false;
  } //End isFull()

  //Returns true if empty
  public boolean isEmpty() {
    return size==0;
  } //End isEmpty()

  //Returns dictionary to empty
  public void clear() {
    size = 0;
    modCtr = 0;
    root = null;
  } //End clear() 

  /**Iterator Utilities***************************************/
  /**                                                       **/
  public Iterator<K> keys() {
    return new KeyIter();
  }
  public Iterator<V> values() {
    return new ValIter();
  }
  abstract class MainIterator<E> implements Iterator<E> {
    protected Node<K,V>[] nodes;
    protected int index;
    protected long modChk;
    private int j = 0;
    public MainIterator() {
      nodes = new Node[size];
      index = 0;
      modChk = modCtr;
      fillArray(root);
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
    private void fillArray(Node<K,V> current) {
      if(current==null) return;
      fillArray(current.left);
      nodes[j++] = current;
      fillArray(current.right);
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
  class ValIter<V> extends MainIterator<V> {
    public ValIter() {
      super();
    }
    public V next() {
      return (V)nodes[index++].value;
    }
  }
  /**                                                       **/
  /***********************************************************/
} //End BinarySearchTree
      
