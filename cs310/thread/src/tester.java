import java.util.Random;
public class tester{
  public static void main(String[] args){
    Random random = new Random();
    int i, j;
    System.out.println("Test");
    Integer[] test = new Integer[10];
    for(i=0; i<10; i++) test[i] = random.nextInt()%100;
    ThreadedSorter.shellSort(test, 2);
    for(Integer d: test) System.out.println(d);
  }}
