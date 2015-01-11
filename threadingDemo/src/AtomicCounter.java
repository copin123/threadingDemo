import java.util.concurrent.atomic.AtomicInteger;


public class AtomicCounter {

	private AtomicInteger counter;
	
	public void incrementCount() {
		counter.incrementAndGet();
	}
	
	public void decrementCount() {
		counter.decrementAndGet();
	}
	
	public int getCount() {
		return counter.get();
	}
}
