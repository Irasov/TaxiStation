package com.irasov.taxi.logic;

import java.util.Collections;
import java.util.List;

import com.irasov.taxi.entity.Car;

public class Action {
	public static final String CONST_SORT_PRICE = "price";
	public static final String CONST_SORT_YEAR = "year";
	
	public static void sortCar(List<Car> cars, String variant){
		  if(variant==CONST_SORT_PRICE){
			   Collections.sort(cars, Car.PRICE_ORDER);
		  }
		  if(variant==CONST_SORT_YEAR){
			   Collections.sort(cars, Car.YAER_ORDER);
		  }	
	}
	
	public static int sumPrice(List<Car> cars){
		int sum = 0;
		for(Car car:cars){
			sum += car.getPrice();
		}
		return sum;
	}
}
