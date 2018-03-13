import java.util.concurrent.Semaphore;

public class Producer extends Thread {

	private String name;

	public Producer(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			//Main.lock.lock();
			try {
				Main.semFree.acquire();
				Main.criticalSection.add(name);
				Main.semFull.release();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			//Main.lock.unlock();
			try {
				Thread.sleep(1500);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}

}
