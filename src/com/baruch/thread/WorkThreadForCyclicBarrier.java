package com.baruch.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.baruch.work.IWorkHandler;

public class WorkThreadForCyclicBarrier implements Runnable {

	private IWorkHandler handler;
	private CyclicBarrier barrier;

	public WorkThreadForCyclicBarrier(IWorkHandler handler, CyclicBarrier barrier) {
		this.handler = handler;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		handler.process();
		try {
			barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
