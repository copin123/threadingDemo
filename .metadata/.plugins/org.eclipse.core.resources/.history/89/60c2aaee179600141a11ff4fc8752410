import java.io.IOException;


public class ContainerRunnableDemo implements Runnable{
	private Thread container;
	private String containerThreadName;

	/**
	 * @param args
	 */
	
	ContainerRunnableDemo (String name) {
		containerThreadName = name;
		System.out.println("Creating thread "+ containerThreadName);
	}
	
	public String getName() {
		return containerThreadName;
	}

	@Override
	public void run() {
		System.out.println("Running" + containerThreadName);
		FileWriterServie fw = new FileWriterServie();
		try {
			for(int i = 4; i > 0; i--) {
				fw.appendToFile("writing thread "+containerThreadName +", "+i);
				System.out.println("Thread: "+containerThreadName+", "+i);
				Thread.sleep(50);
			}
		} catch(InterruptedException e) {
			System.out.println("Thread "+containerThreadName+ " interrupted.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread "+containerThreadName+ " exiting");
		
	}
	
	public void start() {
		System.out.println("Starting "+containerThreadName);
		if(container == null){
			container  = new Thread(this, containerThreadName);
			container.start();
		}
	}
}

