package com.david;

public class Customer implements Runnable{
	private String name;
	private boolean isGettingHairCut;
	private boolean isInShop = true;
	
	public Customer(String name, boolean isGettingHairCut) {
		super();
		this.name = name;
		this.isGettingHairCut = isGettingHairCut;
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
			
		}
	}
	
	
}
