package com.zoomcar.service;

import java.util.List;
import com.zoomcar.exceptions.CarNotFoundException;
import com.zoomcar.model.Car;
import com.zoomcar.model.Rental;

public interface ICarService {
	List<Car>getAll();
	void addCar(Car car);
	int modifyCar(int carId,double price);
	void removeCar(int carId);
	Car getById(int carId);
	List<Car>getByTypeContains(String type);
	List<Car>getByBrandContains(String brand)throws CarNotFoundException;
	List<Car>getByPricelessThan(double price);
	List<Car>getByTypeContainsAndPricelessThan(String type,double price);
	List<Car>getByBrandContainsAndPricelessThan(String brand,double price);
	List<Rental>getRentals();
	void rentCar(Rental rental);
}
