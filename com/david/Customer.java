package com.david;

public class Customer implements Runnable{
	private String name;
	private boolean isGettingHairCut;
	private boolean isInShop = true;
	private BarberShop barberShop;
	
	public Customer(String name, boolean isGettingHairCut, BarberShop barberShop) {
		super();
		this.name = name;
		this.isGettingHairCut = isGettingHairCut;
		this.barberShop = barberShop;
	}
	
	public synchronized boolean isInShop() {
		return isInShop;
	}

	public synchronized void setInShop(boolean isInShop) {
		this.isInShop = isInShop;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public synchronized boolean isGettingHairCut() {
		return isGettingHairCut;
	}
	
	public synchronized void setGettingHairCut(boolean isGettingHairCut) {
		this.isGettingHairCut = isGettingHairCut;
	}

	@Override
	public void run() {
		while(isInShop){
			tryToGetHairCut();
		}
	}

	private void tryToGetHairCut() {
		System.out.println(this.name + " is checking to see if the Barber is free");
		checkIfBarberIsFree();
	}

	private void checkIfBarberIsFree() {
		if(barberShop.getBarber().isCuttingHair()){
			System.out.println(this.name + "going to waiting room");
			goToWaitingRoom();
		}else if(barberShop.getBarber().isSleeping()){
			barberShop.getBarber().wakeUp(this);
		}
	}

	private void goToWaitingRoom() {
		if(barberShop.getWaitingRoom().getCustomerQueue().size() < 10){
			takeASeat();
		}else{
			leaveShopAsNoRoom();
		}
	}

	private void leaveShopAsNoRoom() {
		System.out.println(this.name + " is leaving the shop as no available seats. Waiting room has " + barberShop.getWaitingRoom().getCustomerQueue().size() + " people.");
	}

	private void takeASeat() {
		System.out.println(this.name + " is taking a seat in the waiting room");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getHairCut();
	}

	private void getHairCut() {
		System.out.println(this.name + " is being called to get their hair cut");
		isGettingHairCut = true;
		try {
			wait(5_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		}
	}	
}
