package com.zoomcar.service;


import java.util.List;
import java.util.stream.Collectors;


import com.zoomcar.dao.CarDaoImpl;
import com.zoomcar.dao.ICarDao;
import com.zoomcar.exceptions.CarNotFoundException;
import com.zoomcar.model.Car;
import com.zoomcar.model.Rental;

public class CarServiceImpl implements ICarService {
	ICarDao carDao=new CarDaoImpl();
	@Override
	public List<Car> getAll() {
		return carDao.findAll().stream()
				.sorted((c1,c2)->c1.getBrand().compareTo(c2.getBrand())).collect(Collectors.toList());
	}

	@Override
	public void addCar(Car car) {
		carDao.addCar(car);
	}

	@Override
	public int modifyCar(int carId, double price) {
		return carDao.modifyCar(carId,price);
	}

	@Override
	public void removeCar(int carId) {
		carDao.removeCar(carId);
	}

	@Override
	public List<Car> getByTypeContains(String type) {
		List<Car> cars= carDao.findByTypeContains(type);
		if(cars.isEmpty()){
			throw new CarNotFoundException("Cars by the given type name is not found");
		}
		return cars.stream()
				.sorted((c1,c2)->c1.getBrand().compareTo(c2.getBrand())).collect(Collectors.toList());
	}

	@Override
	public List<Car> getByPricelessThan(double price) {
		List<Car> cars= carDao.findByPricelessThan(price);
		if(cars.isEmpty()){
			throw new CarNotFoundException("Cars by the given price less than is not found");
		}
		return cars.stream()
				.sorted((c1,c2)->c1.getBrand().compareTo(c2.getBrand())).collect(Collectors.toList());
	}

	@Override
	public List<Car> getByBrandContains(String brand) throws CarNotFoundException {
		List<Car> cars= carDao.findByBrandContains(brand);
		if(cars.isEmpty()){
			throw new CarNotFoundException("Cars by the given brand name is not found");
		}
		return cars.stream()
				.sorted((c1,c2)->c1.getBrand().compareTo(c2.getBrand())).collect(Collectors.toList());
	}

	@Override
	public List<Car> getByTypeContainsAndPricelessThan(String type, double price) {
		List<Car> cars= carDao.findByTypeContainsAndPricelessThan(type,price);
		if(cars.isEmpty()){
			throw new CarNotFoundException("Cars by the given type and price lessthan is not found");
		}
		return cars.stream()
				.sorted((c1,c2)->c1.getBrand().compareTo(c2.getBrand())).collect(Collectors.toList());
	}

	@Override
	public List<Car> getByBrandContainsAndPricelessThan(String brand, double price) {
		List<Car> cars= carDao.findByBrandContainsAndPricelessThan(brand,price);
		if(cars.isEmpty()){
			throw new CarNotFoundException("Cars by the given brand and price lessthan is not found");
		}
		return cars.stream()
				.sorted((c1,c2)->c1.getBrand().compareTo(c2.getBrand())).collect(Collectors.toList());
	}

	@Override
	public List<Rental> getRentals() {
		List<Rental>rent=carDao.findRentals();
		if(rent.isEmpty()) {
			System.out.println("No rentals found");
		}
		return rent;
	}

	@Override
	public void rentCar(Rental rental) {
		carDao.rentCar(rental);
		
	}

	@Override
	public Car getById(int carId) {
		if(carDao.findById(carId)==null) {
			throw new CarNotFoundException("Cars with the given id is not found");
		}
		return carDao.findById(carId);
	}


}
