import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public class Main {
	public static LinkedList<String> criticalSection = new LinkedList<String>();
	public static Lock lock = new ReentrantLock();
	
	public static Semaphore semFree = new Semaphore(1);
	public static Semaphore semFull = new Semaphore(0);
	

	public static void main(String[] args) {
		System.out.println("Insert Number Of Threads:");

		Scanner in = new Scanner(System.in);
		Integer nrThreads = in.nextInt();
		in.close();
		Thread producers[] = new Producer[nrThreads];
		Thread consumers[] = new Consumer[nrThreads];

		for (int i = 0; i < nrThreads; i++) {
			producers[i] = new Producer("Producer " + i);
			consumers[i] = new Consumer("Consumer " + i);
		}

		for (int i = 0; i < nrThreads; i++) {
			producers[i].start();
			consumers[i].start();
		}

		for (int i = 0; i < nrThreads; i++) {
		
			try {
				producers[i].join();
				consumers[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
