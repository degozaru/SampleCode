import java.util.ArrayList;

public class Backpack<E> implements BackpackInterface<E> {
	
	protected ArrayList<E>container;
	
	/* Table of contents for Backpack():
	 * Constructor					        Ln. 19
	 * add()						            Ln. 24
	 * removeOne()					        Ln. 29
	 * printContents()				      Ln. 36
	 * contains()					          Ln. 43
	 * isEmpty()					          Ln. 48
	 * removeAll()					        Ln. 53
	 * allIndiciesOf()				      Ln. 65
	 * removeMultipleInstancesOf()	Ln. 86
	 */
	
	//This is the constructor for backpack
	public Backpack(){
		container = new ArrayList<E>();
	} //End constructor
	
	//Adds element to backpack
	public void add(E toAdd){
		container.add(toAdd);
	} //End add()
	
	/*Removes first instance of specified item
	 *  returns true if successful.
	 */
	public boolean removeOne(E toRemove){
		return container.remove(toRemove);
	} //End removeOne()
	
	//Prints out all the contents of the backpack
	public void printContents(){
		for (E anObject : container)
		    System.out.print( anObject+" ");
		System.out.println("");
	} //End printContents()
	
	//Returns true if backpack has the specified element.
	public boolean contains(E itemSought) {
		return container.contains(itemSought);
	} //End contains()
	
	//Returns true if backpack is empty.
	public boolean isEmpty() {
		return container.isEmpty();
	} //Ends isEmpty()
	
	/*Removes all matching elements in backpack
	 * returns true if successful
	 */
	public boolean removeAll(E itemSought) {
		if (container.contains(itemSought)){
			while(container.remove(itemSought)) {}
			return true;
		} else {
			return false;
		}
	} //End removeAll()
	
	//Returns an array with addresses to the elements
	public int[] allIndicesOf(E itemSought) {
		int i;
		int[] returnList;
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
    //This will append all the indicies of the array into ArrayList
		for (i = 0; i < container.size(); i++) {
			if (itemSought == container.get(i))
					tempList.add(i);
		}		
		
    //This is the transfer from ArrayList to the return array
		returnList = new int[tempList.size()];
		for (i = 0; i < tempList.size(); i++) {
			returnList[i] = tempList.get(i);
		}
		
		return returnList;
	} //End allIndiciesOf()

	/* Will remove all instances of the specified element
	 * UNLESS the element appears once.
	 * returns True if at least one item was removed.
	 */
	public boolean removeMultipleInstancesOf(E toRemove) {
		if (container.indexOf(toRemove) == container.lastIndexOf(toRemove))
			return false;
		else
			return removeAll(toRemove);
	} //End removeMultipleInstancesOf()
		
} //End Backpack()
