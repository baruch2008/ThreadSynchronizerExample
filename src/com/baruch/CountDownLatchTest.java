package com.baruch;

import java.util.concurrent.CountDownLatch;

import com.baruch.thread.WorkThreadForCountDownLatch;
import com.baruch.work.IWorkHandler;
import com.baruch.work.WorkHandler;

public class CountDownLatchTest {

	public void test() {
		CountDownLatch latch = new CountDownLatch(3);
		IWorkHandler handler = new WorkHandler();
		for (int i = 0; i < 3; i++) {
			new Thread(new WorkThreadForCountDownLatch(handler, latch)).start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Compleleted");
	}

	public static void main(String[] args) {
		CountDownLatchTest test = new CountDownLatchTest();
		test.test();
	}
}
