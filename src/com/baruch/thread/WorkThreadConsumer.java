package com.baruch.thread;

import java.util.concurrent.SynchronousQueue;

public class WorkThreadConsumer implements Runnable {
	private SynchronousQueue<String> syncQueue;

	public WorkThreadConsumer(SynchronousQueue<String> syncQueue) {
		this.syncQueue = syncQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String str = syncQueue.take();
				System.out.println(str);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
