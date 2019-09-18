
public class Wait {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread("thread1");
		thread.start();
		thread.wait();
	}

}
