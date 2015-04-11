import java.util.Random;
public class Timerr {
  public static void main(String[] args) {
    Random random = new Random();
    int iter = 10;
    int structureSize = 100;
    int [] threadCount = {1, 8, 16, 32, 64, 128, 256}; 
    long start, stop;
    Integer [] array;
    array = new Integer[structureSize]
    /*
    for(int t=0; t<7; t++) {
      System.out.println("Sorting with " + threadCount[t] + " Threads:");
      for(int i=0; i<iter; i++) {
        array = new Integer[structureSize];
        for(int j=0; j<structureSize; j++) array[i] = random.nextInt()%100;
        start = System.currentTimeMillis();
        array = ThreadedSorter.shellSort(array, threadCount[t]);
        stop = System.currentTimeMillis();
        System.out.println("n = " + structureSize + " | Time = " + (stop-start));
        structureSize*=structureSize;
      }
    }
    */
  }
}

