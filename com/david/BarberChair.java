package com.david;

public class BarberChair {
	private boolean isEmpty = true;

	public synchronized boolean isEmpty() {
		return isEmpty;
	}

	public synchronized void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
	
	
}
