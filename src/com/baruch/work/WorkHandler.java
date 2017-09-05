package com.baruch.work;

public class WorkHandler implements IWorkHandler {

	@Override
	public void process() {
		System.out.println("Hello World!!!");
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
