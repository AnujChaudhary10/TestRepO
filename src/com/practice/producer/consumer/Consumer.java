package com.practice.producer.consumer;
/**
 * @author Anujchaudhary
 *
 */
public class Consumer extends Thread {

	private final MarketPlace m;

	public Consumer(MarketPlace m) {
		super();
		this.m = m;
	}

	@Override
	public void run() {
		for(int i = 0;i < 10 ;i++){
			try {
				m.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}

