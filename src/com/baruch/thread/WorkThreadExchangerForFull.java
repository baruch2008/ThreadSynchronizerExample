package com.baruch.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class WorkThreadExchangerForFull implements Runnable {
	private Exchanger<List<String>> exchanger;

	public WorkThreadExchangerForFull(Exchanger<List<String>> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		List<String> buffer = new ArrayList<String>();
		try {
			int count = 0;
			while (null != buffer && count < 10) {
				buffer.add("Hello" + count);
				buffer = exchanger.exchange(buffer);
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
