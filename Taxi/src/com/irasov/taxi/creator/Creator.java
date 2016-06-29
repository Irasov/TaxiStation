package com.irasov.taxi.creator;

import java.util.Random;

import com.irasov.taxi.entity.Car;
import com.irasov.taxi.entity.Cargo;
import com.irasov.taxi.entity.Limousine;
import com.irasov.taxi.entity.Passenger;
import com.irasov.taxi.entity.TaxiStation;

public class Creator {
	private TaxiStation taxiStation;
	private int countCar;	
	public static Random RANDOM = new Random();
	public enum ConstCar {CARGO,LIMOUSINE,PESSENGER};
	public enum ConstMarks {BMW,OPEL,MERCEDES,LADA};
	public enum ConstClassAuto {A,C,E,S};
	public static final int SEATS_NUMBER = 4;
	public enum MotorType {DISEL, GAS, PETROL};
	public static final int MAX_SPEED = 220;
	public static final int CAPACITY = 15;
	public static final int YEAR = 2016;
	public static final int PRICE = 50000;
	public static final int ADDITIVE_NOT_RANDOM_ZERO = 1;
	
	public Creator(TaxiStation taxiStation, int countCar){
		this.taxiStation = taxiStation;
		this.countCar = countCar;
	}

	public int getCountCar() {
		return countCar;
	}

	public void setCountCar(int countCar) {
		this.countCar = countCar;
	}
	
	public ConstCar randomCar(){
		 ConstCar values[] = ConstCar.values();
	     return values[RANDOM.nextInt(values.length)];
	}
	
	public ConstMarks randomMarks(){
		ConstMarks values[] = ConstMarks.values();
		return values[RANDOM.nextInt(values.length)];
	}
	
	public ConstClassAuto randomClassAuto(){
		ConstClassAuto values [] = ConstClassAuto.values();
		return values[RANDOM.nextInt(values.length)];
	}
	
	public MotorType randMotorType(){
		MotorType values[] = MotorType.values();
		return values[RANDOM.nextInt(values.length)];
	}
	
	public void createCar(){
		Car componentCar = null;
		for(int i = 1; i <= this.countCar; i++){
			ConstCar randCar = randomCar();
			String type = String.valueOf(randCar);
			switch(randCar){
			   case PESSENGER:
				 int randPrice = (RANDOM.nextInt(PRICE)+ ADDITIVE_NOT_RANDOM_ZERO);
				 int randYear = (RANDOM.nextInt(YEAR)+ADDITIVE_NOT_RANDOM_ZERO);
				 int randSpeed = (RANDOM.nextInt(MAX_SPEED)+ADDITIVE_NOT_RANDOM_ZERO);
				 componentCar = new Passenger(type,String.valueOf(randomMarks()),String.valueOf(randomClassAuto()),randPrice,randYear,randSpeed,String.valueOf(randMotorType()));
				 taxiStation.addTaxi(componentCar); 
				 break;
			   case LIMOUSINE:
				 boolean pub  = (RANDOM.nextBoolean());  
				 randPrice = (RANDOM.nextInt(PRICE)+ ADDITIVE_NOT_RANDOM_ZERO);
				 randYear = (RANDOM.nextInt(YEAR)+ADDITIVE_NOT_RANDOM_ZERO);
				 int seatsNumber = (RANDOM.nextInt(SEATS_NUMBER)+ ADDITIVE_NOT_RANDOM_ZERO);
				 componentCar = new Limousine(type,String.valueOf(randomMarks()),String.valueOf(randomClassAuto()),randPrice,randYear,seatsNumber,pub);
				 taxiStation.addTaxi(componentCar); 
				 break;
			   case CARGO:
				 randPrice = (RANDOM.nextInt(PRICE)+ ADDITIVE_NOT_RANDOM_ZERO);
				 randYear = (RANDOM.nextInt(YEAR)+ADDITIVE_NOT_RANDOM_ZERO);
				 int capacity = (RANDOM.nextInt(CAPACITY)+ADDITIVE_NOT_RANDOM_ZERO);
				 componentCar = new Cargo(type,String.valueOf(randomMarks()),String.valueOf(randomClassAuto()),randPrice,randYear,capacity); 
				 taxiStation.addTaxi(componentCar); 
				 break;
			}
		}
		
	}
}
	
