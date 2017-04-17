package com.david;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class BarberShop {
	private Barber barber;
	private WaitingRoom waitingRoom;
	private BarberChair barberChair;
	private BlockingQueue<Customer> customerQueue;
	private int id;
		
	public BarberShop(Barber barber, WaitingRoom waitingRoom, BarberChair barberChair) {
		super();
		this.barber = barber;
		this.waitingRoom = waitingRoom;
		this.barberChair = barberChair;
		this.customerQueue = waitingRoom.getCustomerQueue();
	}
	
	public Barber getBarber() {
		return barber;
	}
	
	public void setBarber(Barber barber) {
		this.barber = barber;
	}
	
	public WaitingRoom getWaitingRoom() {
		return waitingRoom;
	}
	
	public void setWaitingRoom(WaitingRoom waitingRoom) {
		this.waitingRoom = waitingRoom;
	}
	
	public BarberChair getBarberChair() {
		return barberChair;
	}
	
	public void setBarberChair(BarberChair barberChair) {
		this.barberChair = barberChair;
	}
	
	public void generateNewCustomer() throws InterruptedException{
		Random random = new Random();
		int waitingTimeForNextCustomer = random.nextInt(14) * 1000;
		try {
			wait(waitingTimeForNextCustomer);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		customerQueue.put(new Customer("custumer-" + id, false, this));
		++id;
	}	
}
