package com.baruch.thread;

import java.util.concurrent.Semaphore;

import com.baruch.work.IWorkHandler;

public class WorkThreadForSemaphore implements Runnable {
	private IWorkHandler handler;
	private Semaphore semaphore;

	public WorkThreadForSemaphore(IWorkHandler handler, Semaphore semaphore) {
		this.handler = handler;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			handler.process();
		} finally {
			semaphore.release();
		}

	}
}
