package com.david;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WaitingRoom {
	private BlockingQueue<Customer> customerQueue = new LinkedBlockingQueue<>(10);

	public BlockingQueue<Customer> getCustomerQueue() {
		return customerQueue;
	}
	
	
}
