import java.util.*;

public class QueueTester {
  public static void main(String[] args) {

    //Step 1: Constructing various queues
    SimpleQueue intQueue = new SimpleQueue<Integer>(); 
    SimpleQueue stringQueue = new SimpleQueue<String>();

    //Step 2: trying functions on empty queues
    System.out.println("====EMPTY QUEUE TESTS====");
    System.out.println("Queue should be empty: " + intQueue.isEmpty());
    System.out.println("Polling empty queue: " + intQueue.poll());
    System.out.println("Peeking at empty array: " + intQueue.peek());
    System.out.println("Size of current array: " + intQueue.size());
    System.out.println("Clearing blank array...");
    intQueue.clear();
    System.out.println("Returning blank array " +
                      Arrays.toString(intQueue.toArray()));
    try {
      System.out.print("Trying remove: ");
      intQueue.remove();
    } catch (Exception e) { 
      System.out.println(e.getMessage());
    }
    try {
      System.out.print("Trying element: ");
      intQueue.element();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("");

    //Step 3: adding/removing elements to the queue
    System.out.println("====ADDING ELEMENTS====");
    System.out.println("Adding some elements to intQueue");
    intQueue.add(1);
    System.out.println("Trying isEmpty(): " + intQueue.isEmpty());
    intQueue.add(2);
    intQueue.add(3);
    System.out.println("Size: " + intQueue.size());
    System.out.println("Queue is now: " +
                      Arrays.toString(intQueue.toArray()));
    System.out.println("Lets move the array around...");
    System.out.println("Removed: " + intQueue.remove());
    System.out.println("Polled: " + intQueue.poll());
    System.out.println("Adding...");
    intQueue.add(4);
    intQueue.add(5);
    intQueue.add(6);
    System.out.println("Size: " + intQueue.size());
    System.out.println("Queue is now: " +
                      Arrays.toString(intQueue.toArray()));
    System.out.println("Peeking: " + intQueue.peek());
    System.out.println("Element: " + intQueue.element());
    System.out.println("Adding a ton of numbers to intQueue");
    intQueue.stressTest(10, 1337);
    System.out.println("Queue is now: " +
                      Arrays.toString(intQueue.toArray()));
    System.out.println("Clearing the queue: ");
    intQueue.clear();
    System.out.println("Queue is now: " +
                      Arrays.toString(intQueue.toArray()));
    System.out.println("");

    //Step 4: String tests
    System.out.println("====String Queue test====");
    System.out.println("Adding string \"null\"");
    stringQueue.add("null");
    System.out.println("Queue: " + 
                      Arrays.toString(stringQueue.toArray()));
    System.out.println("isEmpty(): " + stringQueue.isEmpty());
    System.out.println("Adding some strings...");
    stringQueue.add("Space");
    stringQueue.add("Cowboy");
    stringQueue.add("Cyber Decker");
    System.out.println("Adding strange \"\0\" string");
    stringQueue.add("\0");
    System.out.println("Queue: " +
                      Arrays.toString(stringQueue.toArray()));
    System.out.println("Removing \"null\"");
    stringQueue.remove();
    System.out.println("Queue: " +
                      Arrays.toString(stringQueue.toArray()));
    System.out.println("Clearing");
    stringQueue.clear();
    System.out.println("Queue: " +
                      Arrays.toString(stringQueue.toArray()));
  } //End main()
} //End QueueTester()
