public interface BackpackInterface<E> {

	/*
	 * Returns a boolean indicating whether or not the 
	 * 	container contains the specified object
	 * Arguments:
	 * 		itemSought: the object we are searching for
	 * Return values
	 * 		true: the container does contain the object
	 * 		false: the container does not contain the object
	 */
	public boolean contains(E itemSought);
	
	/*
	 * Returns a boolean indicating whether the container
	 *   has 0 elements in it
	 * Return values
	 * 		true: the container has 0 elements
	 * 		false: the container has 1 or more elements
	 */
	public boolean isEmpty();
	
	/*
	 * Removes all instances of the specified object from the container
	 * Arguments
	 * 		E itemSought: the object to be removed from the container
	 * Return values
	 * 		true: at least one instance of the specified object was removed
	 * 		false: no instances of the specified object were removed
	 */
	public boolean removeAll(E itemSought);
	
	/*
	 * Returns an array containing the indices of each instance of
	 * 	the specified object
	 * Arguments
	 * 		E itemSought: the object to find the indices of
	 * Return value
	 * 		an array of ints containing the indices
	 */
	public int[] allIndicesOf(E itemSought);
	
	/*
	 * Removes all occurrences of the specified object from the
	 * 	container ONLY if it exists more than once is the container.
	 * 	If the specified object occurs once (or 0 times) in the container, then
	 * 	this method does not remove anything.
	  Arguments
	 * 		E toRemove: the object to (possibly) remove
	 * Return value
	 * 		true: items were removed
	 * 		false: no items were removed
	 */
	public boolean removeMultipleInstancesOf(E toRemove);
}
