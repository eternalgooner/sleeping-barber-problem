package com.david;

public class Customer {
	private String name;
	private boolean isGettingHairCut;
	
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
	
	
}
