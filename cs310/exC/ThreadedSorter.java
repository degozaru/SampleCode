/* Vincent Chan
 * masc0264
 */

/*ThreadedSorter
 * This program will sort an array using the specified number of threads
 * It will do so using shell sort and merge sort.
 * This program is NOT in place or stable.
 * To use:
 * array = ThreadedSorter.shellSort(toSortArray, threads)
 */

public class ThreadedSorter{
  /* Class ThreadedSorter
   * === PUBLIC ===
   * shellSort(E[], threads) //Ln.29
   * === PRIVATE ===
   * sort(E[])               //Ln.74
   * merge(E[])              //Ln.102
   * getMin(E[])             //Ln.113
   * 
   * === CLASSES === 
   * WorkerThread            //Ln.134
   */

  private static int[] indices;
  private static int threadCount;

  //This is the function that is called for sorting.
  //It will sort using the array and threads specified.
  public static <E> E[] shellSort(E[] array, int threads) {
    //This will calculate the chunk to be used for each array.
    //if the number of threads exceeds half the array length (chunk=2),
    //or exceeds the max number of threads, we will use a different number of threads.
    if(threads>array.length) threads = array.length/2;
    if(threads>256) threads=256;
    else if(threads<=0) threads=1;

    //This will initialize the thread count and indices for use
    //in the merge() function.
    threadCount = threads;
    WorkerThread[] threadArray = new WorkerThread[threads];
    indices = new int[threads*2];

    //This will create the threads and start them.
    //They will also record the indices they start at for use
    //in the merge() function.
    int arrayChunk = array.length/threads;
    int first = 0, last = arrayChunk, curIndex = 0;
    for(int i=0; i<threads; i++) {
      if(i==threads-1) last = array.length-1;
      threadArray[i] = new WorkerThread<E>(array, first, last);
      threadArray[i].start();
      indices[curIndex++] = first;
      indices[curIndex++] = last;
      first = last+1;
      last += arrayChunk;
    }

    //Waiting for the threads to join
    //and the merge to finish
    try{
      for(int i=0; i<threads; i++) threadArray[i].join();
    }
    catch(Exception e) {
      System.out.println("ERROR, " + 2);
    }

    //This will return the merged array
    merge(array);
    return array;
  } //End shellSort()

 //This will sort the array via shell sort.
  private static <E> void sort(E[] array, int start, int last) {
    int toSort, current;
    int gap = 1;
    int length = last-start+1;
    E temp;
    
    //Calculate the gaps using the Knuth's sequence
    while(gap<=length/3) gap = gap*3+1;
    
    //Sort the array
    while(gap>0) {
      //Sort with the given gap
      for(toSort=start+gap; toSort<last+1; toSort++) {
        temp = array[toSort];
        current = toSort;
        //Shift the array over until we find the place to insert the temp
        while(current>start+gap-1 && ((Comparable<E>)temp).compareTo(array[current-gap])<=0) {
          array[current] = array[current-gap];
          current -= gap;
        }
        array[current] = temp;
      }
      //Reduce the gap and resort using the new gap.
      gap = (gap-1)/3;
    } 
  } //End sort()

  //This will merge the arrays.
  private static <E> void merge(E[] array) {
    E[] aux = (E[])new Object[array.length];
    for(int i=0; i<array.length; i++) {
      aux[i] = getMin(array);
    }
    for(int i=0; i<array.length; i++) {
      array[i] = aux[i];
    }
  } //End merge()

  //This will return the minimum of the all the threads
  //This is used for merging at the end of the sort
  private static <E> E getMin(E[] array) {
    E minimum = null;
    int index = -1;
    for(int i=0;i<threadCount;i++) {
      if(indices[i*2]>indices[i*2+1]) continue;
      if(minimum==null) {
        minimum = array[indices[i*2]];
        index = i*2;
        continue;
      }
      if(((Comparable<E>)minimum).compareTo(array[indices[i*2]])>0) {
        minimum = array[indices[i*2]];
        index = i*2;
      }
    }
    indices[index]++;
    return minimum;
  } //End getMin()

  //This is the thread that we will use to sort.
  static class WorkerThread<T> extends Thread{
    int start, end;
    T[] tmp;

    //Constructor that will take an array, and the start/end indices
    public WorkerThread(T[] arr, int s, int e) {
      tmp = arr;
      start = s;
      end = e;
    } //End constructor

    public void run() {
      sort(tmp, start, end);
    } //End run()
  } //End WorkerThread
}//End ThreadedSorter


