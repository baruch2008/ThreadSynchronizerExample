package com.baruch;

import java.util.concurrent.CyclicBarrier;

import com.baruch.thread.WorkThreadForCyclicBarrier;
import com.baruch.work.IWorkHandler;
import com.baruch.work.WorkHandler;

public class CyclicBarrierTest {
	public void test() {
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				System.out.println("How are you?");
			}
		});

		IWorkHandler handler = new WorkHandler();
		for (int i = 0; i < 3; i++) {
			new Thread(new WorkThreadForCyclicBarrier(handler, barrier)).start();
		}
	}

	public static void main(String[] args) {
		CyclicBarrierTest test = new CyclicBarrierTest();
		test.test();
	}
}
