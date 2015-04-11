import java.util.Random;
public class tester{
  public static void main(String[] args){
    Random random = new Random();
    int i, j;
    int size = 819200;
    System.out.println("Size = " + size);
    for(j = 1; j<=256; j*=2) {
    Integer[] test = new Integer[size];
    for(i=0; i<size; i++) test[i] = random.nextInt();
    long start = System.currentTimeMillis();
    test = ThreadedSorter.<Integer>shellSort(test, j);
    long stop = System.currentTimeMillis();
    //for(Integer d: test) System.out.println(d);
    System.out.println("Time for" + j + " threads = " + (stop-start));
  }}}
