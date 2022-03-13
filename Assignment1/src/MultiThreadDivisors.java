import java.util.ArrayList;
import java.util.List;

public class MultiThreadDivisors implements Runnable {
    int firstNr;
    long nrPerThread;
    ArrayList <Integer> primes = new ArrayList<Integer>();
    public int totalPrimes;
    String lastThread = String.valueOf((Main.numberOfThreads -1));
    String lastThreadName;

    MultiThreadDivisors(int firstNr, int nrPerThread) {
        this.firstNr = firstNr;
        this.nrPerThread = nrPerThread;
    }


    @Override
    public void run() {
        lastThreadName = Thread.currentThread().getName().replaceAll("[^0-9]", "");

        if(lastThreadName.equals(lastThread)){
            nrPerThread+= Main.remainderNumbers;
        }
        for (int number = firstNr; number <= firstNr + nrPerThread; number++) {
                if(isPrime(number)){
                    totalPrimes++;
//                      synchronized (this){
//                          Main.totalPrimesSync++;
//                      } FOR NOW IT DOESN'T WORK WITH SYNCHRONIZED
                }
        }

        synchronized (this){
            Main.totalPrimes += totalPrimes;
        }
    }

    private boolean isPrime(int number) {
        for (int denominator = 2; denominator <= Math.sqrt(number) + 1; denominator++) {
            if (number % denominator == 0) {
                return false;
            }
        }
        return true;
    }



}
