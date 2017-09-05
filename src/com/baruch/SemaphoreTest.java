package com.baruch;

import java.util.concurrent.Semaphore;

import com.baruch.thread.WorkThreadForSemaphore;
import com.baruch.work.IWorkHandler;
import com.baruch.work.WorkHandler;

public class SemaphoreTest {
	public void test() {
		IWorkHandler handler = new WorkHandler();
		Semaphore semaphore = new Semaphore(3);
		for (int i = 0; i < 20; i++) {
			new Thread(new WorkThreadForSemaphore(handler, semaphore)).start();
		}
	}

	public static void main(String[] args) {
		SemaphoreTest semaphoreTest = new SemaphoreTest();
		semaphoreTest.test();
	}
}
