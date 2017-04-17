package com.david;

public class SleepingBarberProblemApp {
	private BarberShop barberShop;
	private Barber barber;

	public static void main(String[] args) {
		new SleepingBarberProblemApp().start();
	}

	private void start() {
		System.out.println("starting simulation...");
		initSetup();
	}

	private void initSetup() {
		barber = new Barber();
		WaitingRoom waitingRoom = new WaitingRoom();
		BarberChair barberChair = new BarberChair();
		barberShop = new BarberShop(barber, waitingRoom, barberChair);
	}
}
