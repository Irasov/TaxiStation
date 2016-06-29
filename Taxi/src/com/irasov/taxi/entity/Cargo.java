package com.irasov.taxi.entity;

public class Cargo extends Car{

	private int capacity;
	
	public Cargo(){
		
	}
	
	public Cargo(String type,String mark, String autoClass, int price, int year, int capacity ){
		super(type, mark, autoClass, price, year);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + capacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (capacity != other.capacity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+"\n capacity=" + capacity+"\n";
	}
	
	
	
	
}
