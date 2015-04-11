/*Masc0264
 *Vincent Chan
 */
package data_structures;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class RedBlackTree<K,V> implements DictionaryADT<K,V> {
  TreeMap<K,V> storage;

  public RedBlackTree() {
    storage = new TreeMap<K,V>();
  }

  public boolean contains(K key) {
    return storage.containsKey(key);
  }

  public boolean add(K key, V value) {
    storage.put(key, value);
    return true;
  }

  public boolean delete(K key) {
    if(storage.remove(key)!=null) {
      return true;
    }
    return false;
  }

  public V getValue(K key) {
    return storage.get(key);
  }

  public K getKey(V value) {
    for(Entry<K,V> node : storage.entrySet())
      if(((Comparable<V>)value).compareTo(node.getValue())==0)
        return node.getKey();
    return null;
  }

  public int size() {
    return storage.size();
  }

  public boolean isFull() {
    return false;
  }

  public boolean isEmpty() {
    return storage.size()==0;
  }

  public void clear() {
    storage.clear();
  }

  public Iterator<K> keys() {
    return storage.keySet().iterator();
  }

  public Iterator<V> values() {
    return storage.values().iterator();
  }

}
