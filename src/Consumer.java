
public class Consumer extends Thread {
	private String name;

	public Consumer(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		if (!Main.criticalSection.isEmpty()) {
			Main.lock.lock();
			String removed = Main.criticalSection.removeFirst();
			System.out.println(name + " has removed " + removed);
			Main.lock.unlock();
		}
		
		try {
				Thread.sleep(500);
				
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}