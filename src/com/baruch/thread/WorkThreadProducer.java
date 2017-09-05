package com.baruch.thread;

import java.util.concurrent.SynchronousQueue;

public class WorkThreadProducer implements Runnable {
	private SynchronousQueue<String> syncQueue;

	public WorkThreadProducer(SynchronousQueue<String> syncQueue) {
		this.syncQueue = syncQueue;
	}

	@Override
	public void run() {
		int counter = 0;
		while (counter < 10) {
			try {
				syncQueue.put("Hello World" + counter);
				counter++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
