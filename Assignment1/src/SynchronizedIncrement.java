
// EXERCISE 1.2
public class SynchronizedIncrement implements Runnable{

    private static final int NUM_THREADS = 16;
    public static final int TOTAL_NUMBERS = 100000000;
    private Counter counter;



    public SynchronizedIncrement(Counter counter){
        this.counter = counter;
    }

    public  static void main(String args[]) throws InterruptedException{
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[NUM_THREADS];
        Counter counter = new Counter();

        for (int i = 0; i < NUM_THREADS; ++i) {
            threads[i] = new Thread(new SynchronizedIncrement(counter));
            threads[i].start();
        }

        for (int i = 0; i < NUM_THREADS; ++i){
            threads[i].join();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Count: " + counter.getCount());
        System.out.println("Primes: " + counter.getPrimes());
        System.out.println("Total time taken(in millis): " + (endTime - startTime));
    }

    @Override
    public void run() {
        while(counter.getCount() < TOTAL_NUMBERS){
            int number = counter.increment();
            counter.verifyPrime(number);

        }

        }



}
