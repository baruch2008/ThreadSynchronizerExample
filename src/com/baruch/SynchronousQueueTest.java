package com.baruch;

import java.util.concurrent.SynchronousQueue;

import com.baruch.thread.WorkThreadConsumer;
import com.baruch.thread.WorkThreadProducer;

public class SynchronousQueueTest {
	public void test() {
		SynchronousQueue<String> syncQueue = new SynchronousQueue<String>();
		Thread producer = new Thread(new WorkThreadProducer(syncQueue));
		Thread consumer = new Thread(new WorkThreadConsumer(syncQueue));
		producer.start();
		consumer.start();
	}

	public static void main(String[] args) {
		SynchronousQueueTest test = new SynchronousQueueTest();
		test.test();
	}
}
