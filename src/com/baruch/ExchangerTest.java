package com.baruch;

import java.util.List;
import java.util.concurrent.Exchanger;

import com.baruch.thread.WorkThreadExchangerForEmpty;
import com.baruch.thread.WorkThreadExchangerForFull;

public class ExchangerTest {
	public void test() {
		Exchanger<List<String>> exchanger = new Exchanger<List<String>>();
		new Thread(new WorkThreadExchangerForFull(exchanger)).start();
		new Thread(new WorkThreadExchangerForEmpty(exchanger)).start();
	}

	public static void main(String[] args) {
		ExchangerTest test = new ExchangerTest();
		test.test();
	}
}
