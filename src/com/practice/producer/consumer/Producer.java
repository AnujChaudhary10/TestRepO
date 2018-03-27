package com.practice.producer.consumer;
/**
 * @author Anujchaudhary
 *
 */
public class Producer extends Thread {

	private final MarketPlace m;

	public Producer(MarketPlace m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				m.supply("product"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		m.terminate.compareAndSet(false, true);
	}
}
