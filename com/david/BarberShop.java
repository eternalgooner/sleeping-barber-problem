package com.david;

import java.util.concurrent.BlockingQueue;

public class BarberShop {
	private Barber barber;
	private WaitingRoom waitingRoom;
	private BarberChair barberChair;
	private BlockingQueue<Customer> customerQueue;
		
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
	
	
}
