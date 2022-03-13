import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
// EXERCISE 1.1
public class Main {
    //public static AtomicInteger totalPrimes = new AtomicInteger(0);
    public static int totalPrimes = 0;
    public static int totalPrimesSync = 0;
    public static int numberOfThreads = 16;
    public static int firstNr = 1;

    public static int lastNr = 100000000;
    public static int totalNumber = lastNr - firstNr;
    public static int nrPerThread = totalNumber/numberOfThreads;
    public static int remainderNumbers = totalNumber%numberOfThreads;

    public static void main(String[] args) throws InterruptedException {



        assert firstNr < lastNr;


        List<Thread> threads =  new ArrayList<>();
        Thread thread[] = new Thread[numberOfThreads];
        long timerStart = System.currentTimeMillis();
        for (int i = 1; i <= numberOfThreads; i++) {

            Thread th = new Thread(new MultiThreadDivisors(firstNr, nrPerThread));

            th.start();

            threads.add(th);
            firstNr += nrPerThread;

        }


        for (Thread th : threads){
            th.join();
        }
        long timerEnd = System.currentTimeMillis();
        long totalTime = timerEnd - timerStart;
        System.out.println("Total primes: " + totalPrimes);
        System.out.println("Total milliseconds: " + totalTime);
    }
}