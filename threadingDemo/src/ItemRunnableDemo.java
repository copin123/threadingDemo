import java.io.IOException;


public class ItemRunnableDemo implements Runnable{

	private Thread itemThread;
	private String itemThreadName;
	private String containerThreadName;
	AtomicCounter counter;
	
	
	ItemRunnableDemo(String containerName){
		containerThreadName = containerName;
	}
	@Override
	public void run() {
		System.out.println("Running" + containerThreadName);
		FileWriterServie fw = new FileWriterServie();
		try {
			for(int i = 4; i > 0; i--) {
				fw.appendToFile("writing thread "+itemThreadName +", "+i);
				System.out.println("Thread: "+itemThreadName+", "+i);
				counter.incrementCount();
				System.out.println("The counter says: "+counter.getCount());
				Thread.sleep(50);
			}
		} catch(InterruptedException e) {
			System.out.println("Thread "+itemThreadName+ " interrupted.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread "+containerThreadName+ " exiting");
		
	}
	public void start() {
		System.out.println("Starting "+itemThreadName);
		if(itemThread == null){
			itemThread  = new Thread(this, itemThreadName);
			itemThread.start();
		}
	}

}
