package com.irasov.taxi.entity;

public class Passenger extends Car{

	private int maxSpeed;
	private String motorType;
	
	public Passenger(){
		
	}
	
	public Passenger(String type, String mark, String autoClass, int price, int year,int maxSpeed, String motorType){
		super(type, mark,autoClass,price,year);
		this.maxSpeed = maxSpeed;
		this.motorType = motorType;
	}
	
	public void setMaxSpeed(int maxSpeed){
		this.maxSpeed = maxSpeed;
	}
	
	public int getMaxSpeed(){
		return this.maxSpeed;
	}
	
	public void setMotorType(String motorType){
		this.motorType = motorType;
	}
	
	public String getMotorType(){
		return this.motorType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + maxSpeed;
		result = prime * result + ((motorType == null) ? 0 : motorType.hashCode());
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
		Passenger other = (Passenger) obj;
		if (maxSpeed != other.maxSpeed)
			return false;
		if (motorType == null) {
			if (other.motorType != null)
				return false;
		} else if (!motorType.equals(other.motorType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString()+"\n maxSpeed=" + maxSpeed + "\n motorType=" + motorType+"\n";
	}
	
	
}
