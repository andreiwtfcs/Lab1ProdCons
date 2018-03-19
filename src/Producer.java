
public class Producer extends Thread {

	private String name;

	public Producer(String name) {
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
			
			synchronized (Main.condProd) {
				if (Main.criticalSection.size() == Main.nrThread) {
	
					try {
						Main.condProd.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
			synchronized (Main.condCons) {
				Main.criticalSection.add(name);
				Main.condCons.notify();
			}
			

		}
	}

}
