package com.practice.producer.consumer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MarketPlace {

	List<String> inventory = new ArrayList<String>();
	int count = 0;
	public AtomicBoolean terminate = new AtomicBoolean(false);

	public synchronized void supply(String str) throws InterruptedException {
		while (!inventory.isEmpty()) {
			wait();
		}
		inventory.add(str);
		System.out.println("produced " + str);
		System.out.println("pCount" + count++);
		notifyAll();

	}

	public synchronized void consume() throws InterruptedException {

		while (inventory.isEmpty()) {
			wait();
		}

		Iterator<String> i = inventory.iterator();
		while (i.hasNext()) {
			System.out.println("consumed " + i.next());
			System.out.println("cCount" + count++);
			i.remove();
		}
		notifyAll();
	}

	public static void main(String[] args) {
		MarketPlace m = new MarketPlace();
		for (int i = 0; i < 4; i++) {
			Producer p = new Producer(m);
			Consumer c = new Consumer(m);
			p.start();
			c.start();
		}

	}
}
