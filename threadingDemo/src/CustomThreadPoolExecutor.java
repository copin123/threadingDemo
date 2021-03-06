import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

	AtomicCounter counter = new AtomicCounter();
	public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		counter.incrementCount();
		System.out.println("The counter says: "+counter.getCount());
		System.out.println("Perfom beforeExecute() logic");
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		counter.decrementCount();
		if (t != null) {
			System.out.println("Perform exception handler logic");
		}
		System.out.println("The decremented Counter says: "+counter.getCount());
		System.out.println("Perform afterExecute() logic");
	}
}
