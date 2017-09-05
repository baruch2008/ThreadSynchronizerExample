package com.baruch.thread;

import java.util.concurrent.CountDownLatch;

import com.baruch.work.IWorkHandler;

public class WorkThreadForCountDownLatch implements Runnable {
	private IWorkHandler handler;
	private CountDownLatch latch;

	public WorkThreadForCountDownLatch(IWorkHandler handler, CountDownLatch latch) {
		this.handler = handler;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			handler.process();
		} finally {
			latch.countDown();
		}
	}
}
