package com.irasov.taxi.entity;

public class Limousine extends Car{
	private int seatsNumber;
	private boolean pub;
	
	public Limousine(){
	}
	
	public Limousine(String type, String mark, String autoClass, int price, int year,int seatsNumber, boolean pub){
		super(type, mark, autoClass, price, year);
		this.seatsNumber = seatsNumber;
		this.pub = pub;
	}

	public int getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(int seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public boolean isPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (pub ? 1231 : 1237);
		result = prime * result + seatsNumber;
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
		Limousine other = (Limousine) obj;
		if (pub != other.pub)
			return false;
		if (seatsNumber != other.seatsNumber)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n seatsNumber=" + seatsNumber + "\n pub=" + pub+"\n";
	}
	
}
