package com.irasov.taxi.entity;

import java.util.ArrayList;
import java.util.List;

public class TaxiStation  {
	
	private String name;
	private List<Car> taxiStation;
	
	public TaxiStation(String name){
		this.name = name;
		taxiStation = new ArrayList<Car>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getTaxiStation() {
		return taxiStation;
	}

	public void setTaxiStation(List<Car> taxiStation) {
		this.taxiStation = taxiStation;
	}
	
	public void addTaxi(Car car){
		this.taxiStation.add(car);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((taxiStation == null) ? 0 : taxiStation.hashCode());
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
		TaxiStation other = (TaxiStation) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (taxiStation == null) {
			if (other.taxiStation != null)
				return false;
		} else if (!taxiStation.equals(other.taxiStation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String str="Taxistation name=" + name+"\n"+"Cars:";
		for(Car car:taxiStation){
			str+=car.toString()+"\n";
		}
		return str;
	}
	
	

}
