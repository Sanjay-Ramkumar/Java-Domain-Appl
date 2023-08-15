package com.zoomcar.dao;
import java.util.List;
import com.zoomcar.exceptions.CarNotFoundException;
import com.zoomcar.model.Car;
import com.zoomcar.model.Rental;

public interface ICarDao {
	List<Car>findAll();
	void addCar(Car car);
	int modifyCar(int carId,double price);
	void removeCar(int carId);
	Car findById(int carId);
	List<Car>findByTypeContains(String type) throws CarNotFoundException;
	List<Car>findByBrandContains(String brand)throws CarNotFoundException;
	List<Car>findByPricelessThan(double price) throws CarNotFoundException;
	List<Car>findByTypeContainsAndPricelessThan(String type,double price) throws CarNotFoundException;
	List<Car>findByBrandContainsAndPricelessThan(String brand,double price) throws CarNotFoundException;
	List<Rental>findRentals();
	void rentCar(Rental rental);
}
