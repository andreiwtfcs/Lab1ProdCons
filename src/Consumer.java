import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
	private String name;

	public Consumer(String name) {
		this.name = name;
	}

	@Override
	public void run() { 
		while (!Thread.currentThread().isInterrupted()) {
			//Main.lock.lock();
			if (!Main.criticalSection.isEmpty()) {
				try {
					Main.semFull.acquire();
					String removed = Main.criticalSection.removeFirst();
					System.out.println(name + " has removed " + removed);
					Main.semFree.release();
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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