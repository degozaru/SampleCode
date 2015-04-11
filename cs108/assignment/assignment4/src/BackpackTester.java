import java.util.Arrays;


public class BackpackTester {

	public static void main(String[] args) {
		/* Step 1:
		 * Constructing backpacks of different types
		 */
		System.out.println("Constructing bags (String and Integer)");
		Backpack<String> wordBag = new Backpack<String>();
		Backpack<Integer> numBag = new Backpack<Integer>();
		System.out.println("============");
		
		/* Step 2:
		 * Add Strings to stringBag and nums to numBag
		 * try adding strings to numBag
		 */
		System.out.println("Adding contents to bag");
		wordBag.add("Space");
		wordBag.add("Pirate");
		wordBag.add("Space");
		wordBag.add("Cowboy");
		numBag.add(1);
		numBag.add(1);
		numBag.add(2);
		numBag.add(2);
		numBag.add(2);
		numBag.add(2);
		numBag.add(2);
		numBag.add(3);
		//numBag.add("String"); yields a compile error
		System.out.println("============");
		
		/* Step 3:
		 * Print contents
		 */
		System.out.println("Printing contents of bags...");
		wordBag.printContents();
		numBag.printContents();
		System.out.println("============");
		
		/* Step 4:
		 * Checking to see if a specified string is in the list
		 */
		System.out.println("Searching for 'Space', then 'Landlovers'...");
		System.out.println(wordBag.contains("Space"));
		System.out.println(wordBag.contains("Landlovers"));
		System.out.println("Searching for 1 then 4...");
		System.out.println(numBag.contains(1));
		System.out.println(numBag.contains(4));
		System.out.println("Seeing if wordBag is empty...");
		System.out.println(wordBag.isEmpty());
		System.out.println("Returning indicies of 2 in numBag");
		System.out.println(Arrays.toString(numBag.allIndicesOf(2)));
		System.out.println("============");
		
		/* Step 5: 
		 * Remove functions
		 */
		System.out.println("Removing ONE 2 from numBag...");
		numBag.removeOne(2);
		numBag.printContents();
		System.out.println("Removing ALL 2's from numBag");
		numBag.removeAll(2);
		numBag.printContents();
		System.out.println("Removing multiple occurances of 1's");
		numBag.removeMultipleInstancesOf(1);
		numBag.printContents();
		System.out.println("Trying to remove \"multiple 3s\"");
		numBag.removeMultipleInstancesOf(3);
		numBag.printContents();
		System.out.println("============");
	} //End main()

} //End BackpackTester()
