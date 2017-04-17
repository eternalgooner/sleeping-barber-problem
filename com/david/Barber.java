package com.david;

import java.util.concurrent.BlockingQueue;

public class Barber  implements Runnable{
	private boolean isCuttingHair;
	private boolean isSleeping;
	private int customersServed;
	private BarberShop barberShop;
	private BlockingQueue<Customer> customerQueue;
	
	public Barber(BarberShop barberShop) {
		super();
		this.barberShop = barberShop;
	}

	public BlockingQueue<Customer> getCustomerQueue() {
		return customerQueue;
	}

	public synchronized int getCustomersServed() {
		return customersServed;
	}

	public void setCustomerQueue(BlockingQueue<Customer> customerQueue) {
		this.customerQueue = customerQueue;
	}

	public synchronized boolean isCuttingHair() {
		return isCuttingHair;
	}
	
	public synchronized void setCuttingHair(boolean isCuttingHair) {
		this.isCuttingHair = isCuttingHair;
	}
	
	public synchronized boolean isSleeping() {
		return isSleeping;
	}
	
	public synchronized void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}
		
	//check if anyone in waiting room
	private void checkForNextCustomer(){
		if (customersServed < 20) {
			System.out.println("Barber checking the waiting room for next customer...");
			Customer nextCustomer = customerQueue.poll();
			if (nextCustomer != null) {
				cutHair(nextCustomer);
				System.out.println(
						nextCustomer.getName() + " is waiting for a haircut & will be brought to the barber's chair");
			} else {
				goForANap();
			} 
		}
	}
	
	//if no, then have a nap
	private void goForANap() {
		this.isSleeping = true;
		try {
			Thread.sleep(12_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//if yes then start cutting hair in barber chair
	private synchronized void cutHair(Customer customer){
		this.isCuttingHair = true;
		this.isSleeping = false;
		customer.setGettingHairCut(true);
		System.out.println(customer.getName() + " is now getting their hair cut");
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.isCuttingHair = false;
		customer.setGettingHairCut(false);
		customerLeavesTheShop(customer);
	}

	private void customerLeavesTheShop(Customer customer) {
		System.out.println(customer.getName() + " is now leaving the barber shop");
		customer.setInShop(false);
		System.out.println("customers served: " + customersServed);
		checkForNextCustomer();
	}
	
	//wake up barber
	public void wakeUp(Customer customer){
		System.out.println("waking up barber as customer just walked into the shop");
		//Customer customer = new Customer("J.U.S.T.I.N", false, barberShop);
		cutHair(customer);
	}

	@Override
	public void run() {
		while(customersServed < 20){
			checkForNextCustomer();
		}
	}
	
}
