package com.david;

public class Barber {
	private boolean isCuttingHair;
	private boolean isSleeping;
	
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
	
	
}
