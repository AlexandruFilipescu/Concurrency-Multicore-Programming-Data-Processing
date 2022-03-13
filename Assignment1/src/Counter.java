import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int count = 0;
    private int totalPrimes;

    private synchronized int incrementPrimes(){
        return totalPrimes++;
    }

    public synchronized int increment(){
             return count++;
    }

    public synchronized int getCount(){
        return count;
    }

    public synchronized int getPrimes(){
        return totalPrimes;
    }

    public void verifyPrime(int number){
            //System.out.println("Current Working:" + Thread.currentThread().getName());
            if(isPrime(number)){
                incrementPrimes();
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
