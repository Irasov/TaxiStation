package com.irasov.taxi.entity;

import java.util.Comparator;

public abstract class Car {
 public static final Comparator<Car> PRICE_ORDER = new PriceComaparator();
 public static final Comparator<Car> YAER_ORDER = new  YearComaparator(); 	
 private String type;	
 private String mark;
 private String autoClass;
 private int price;
 private int year;
 
 
 public Car(){
	 
 }
 
 public Car(String type,String mark, String autoClass, int price, int year){
	 this.type = type;
	 this.mark = mark;
	 this.autoClass = autoClass;
	 this.price = price;
	 this.year = year;
 }
 
public static class PriceComaparator implements Comparator<Car>{
	public int compare(Car o1, Car o2){
		return o1.getPrice()-o2.getPrice();
	}	
}
public static class YearComaparator implements Comparator<Car>{
	public int compare(Car o1, Car o2){
		return o1.getYear()-o2.getYear();
	}
}


public void setType(String type){
	this.type = type;
}

public String getType(){
	return type;
}
 
public void setMark(String mark){
	 this.mark = mark;
 }
 
 public String getMark(){
	 return this.mark;
 }
 
 public void setAutoClass(String autoClass){
	 this.autoClass = autoClass;
 }
 
 public String getAutoClass(){
	 return this.autoClass;
 }
 
 public void setPrice(int price){
	 this.price = price;
 }
 
 public int getPrice(){
	 return this.price;
 }
 
 public void setYear(int year){
	 this.year = year;
 }
 
 public int getYear(){
	 return year;
 }
 
 @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((autoClass == null) ? 0 : autoClass.hashCode());
	result = prime * result + ((mark == null) ? 0 : mark.hashCode());
	result = prime * result + price;
	result = prime * result + year;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Car other = (Car) obj;
	if (autoClass == null) {
		if (other.autoClass != null)
			return false;
	} else if (!autoClass.equals(other.autoClass))
		return false;
	if (mark == null) {
		if (other.mark != null)
			return false;
	} else if (!mark.equals(other.mark))
		return false;
	if (price != other.price)
		return false;
	if (year != other.year)
		return false;
	return true;
}
 
 @Override
 public String toString(){
	 return " Type car:"+getType()+"\n mark: " + getMark()+"\n class: "+getAutoClass()+"\n price: "+getPrice()+"\n Year: "+getYear();
 }
}
