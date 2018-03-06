
public class Producer extends Thread {

	private String name;

	public Producer(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		Main.lock.lock();
		Main.criticalSection.add(name);
		Main.lock.unlock();
		try {
			Thread.sleep(500);
			
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
			
	}

}
