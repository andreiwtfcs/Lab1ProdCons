
public class Consumer extends Thread {
	private String name;

	public Consumer(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			
			try {
				Thread.sleep(500);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized (Main.condCons) {
				if (Main.criticalSection.size() == 0) {
					try {
						Main.condCons.wait();
	
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	
				}
			}
			 synchronized (Main.condProd){
				if (Main.criticalSection.size() != 0)
				{
					String removed = Main.criticalSection.removeFirst();
					System.out.println(name + " has removed " + removed);
				}
				Main.condProd.notify();
			}
		}
	}
}