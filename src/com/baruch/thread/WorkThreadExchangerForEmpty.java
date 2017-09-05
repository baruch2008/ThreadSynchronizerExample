package com.baruch.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class WorkThreadExchangerForEmpty implements Runnable {
	private Exchanger<List<String>> exchanger;

	public WorkThreadExchangerForEmpty(Exchanger<List<String>> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		List<String> buffer = new ArrayList<String>();
		try {
			while (null != buffer) {
				if (!buffer.isEmpty()) {
					System.out.println("Result:" + buffer.remove(0));
				}
				buffer = exchanger.exchange(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
