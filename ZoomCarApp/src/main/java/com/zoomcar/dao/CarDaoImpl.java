package com.zoomcar.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.zoomcar.exceptions.CarNotFoundException;
import com.zoomcar.model.Car;
import com.zoomcar.model.Rental;
import com.zoomcar.util.DBConnection;
import com.zoomcar.util.Queries;

public class CarDaoImpl implements ICarDao {

	@Override
	public List<Car> findAll() {
		List<Car> cars = new ArrayList<Car>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYALL);) {
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Car car = new Car();
				car.setCarId(result.getInt(1));
				car.setRegisterNo(result.getString(2));
				car.setModel(result.getString(4));
				car.setBrand(result.getString(3));
				car.setType(result.getString(5));
				car.setPrice(result.getDouble(6));
				cars.add(car);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public void addCar(Car car) {
		try (Connection connection = DBConnection.openConnection();
				 PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) {
				statement.setInt(1, car.getCarId());
				statement.setString(2, car.getRegisterNo());
				statement.setString(4, car.getModel());
				statement.setString(3, car.getBrand());
				statement.setString(5, car.getType());
				statement.setDouble(6, car.getPrice());
				statement.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public int modifyCar(int carId, double price) {
		int result = 0;
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);) {
				statement.setDouble(1, price);
				statement.setInt(2, carId);
				result =statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;
	}

	@Override
	public void removeCar(int carId) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);) {
			statement.setInt(1, carId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Car> findByTypeContains(String type) throws CarNotFoundException {
		List<Car> cars = new ArrayList<Car>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYTYPE);) {
			statement.setString(1, "%"+type+"%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Car car = new Car();
				car.setCarId(result.getInt(1));
				car.setRegisterNo(result.getString(2));
				car.setModel(result.getString(4));
				car.setBrand(result.getString(3));
				car.setType(result.getString(5));
				car.setPrice(result.getDouble(6));
				cars.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;

	}

	@Override
	public List<Car> findByPricelessThan(double price) throws CarNotFoundException {
		List<Car> cars = new ArrayList<Car>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYPRICELESSTHAN);) {
			statement.setDouble(1,price);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Car car = new Car();
				car.setCarId(result.getInt(1));
				car.setRegisterNo(result.getString(2));
				car.setModel(result.getString(4));
				car.setBrand(result.getString(3));
				car.setType(result.getString(5));
				car.setPrice(result.getDouble(6));
				cars.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public List<Car> findByTypeContainsAndPricelessThan(String type, double price) throws CarNotFoundException {
		List<Car> cars = new ArrayList<Car>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYTYPEANDPRICELESSTHAN);) {
			statement.setString(1, "%"+type+"%");
			statement.setDouble(2,price);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Car car = new Car();
				car.setCarId(result.getInt(1));
				car.setRegisterNo(result.getString(2));
				car.setModel(result.getString(4));
				car.setBrand(result.getString(3));
				car.setType(result.getString(5));
				car.setPrice(result.getDouble(6));
				cars.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public List<Car> findByBrandContains(String brand) throws CarNotFoundException {
		List<Car> cars = new ArrayList<Car>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYBRAND);) {
			statement.setString(1, "%"+brand+"%");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Car car = new Car();
				car.setCarId(result.getInt(1));
				car.setRegisterNo(result.getString(2));
				car.setModel(result.getString(4));
				car.setBrand(result.getString(3));
				car.setType(result.getString(5));
				car.setPrice(result.getDouble(6));
				cars.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public List<Car> findByBrandContainsAndPricelessThan(String brand, double price) throws CarNotFoundException {
		List<Car> cars = new ArrayList<Car>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYBRANDANDPRICELESSTHAN);) {
			statement.setString(1, "%"+brand+"%");
			statement.setDouble(2,price);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Car car = new Car();
				car.setCarId(result.getInt(1));
				car.setRegisterNo(result.getString(2));
				car.setModel(result.getString(4));
				car.setBrand(result.getString(3));
				car.setType(result.getString(5));
				car.setPrice(result.getDouble(6));
				cars.add(car);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public List<Rental> findRentals() {
		List<Rental> rent = new ArrayList<Rental>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYALLBYRENTAL);) {
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Rental rental = new Rental();
				rental.setCustId(result.getInt(1));
				rental.setCarID(result.getInt(2));
				rental.setPhone(result.getInt(3));
				rental.setStartDate(result.getString(4));
				rental.setEndDate(result.getString(5));
				rent.add(rental);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rent;
	}

	@Override
	public void rentCar(Rental rental) {
		try (Connection connection = DBConnection.openConnection();
				 PreparedStatement statement = connection.prepareStatement(Queries.QUERYTORENT);) {
				statement.setInt(1, rental.getCustId());
				statement.setInt(2, rental.getCarID());
				statement.setInt(3, rental.getPhone());
				statement.setString(4, rental.getStartDate());
				statement.setString(5, rental.getEndDate());
				statement.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public Car findById(int carId) {
		Car car = null;
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYCARID);) {
			statement.setInt(1, carId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				car = new Car();
				car.setCarId(result.getInt(1));
				car.setRegisterNo(result.getString(2));
				car.setModel(result.getString(4));
				car.setBrand(result.getString(3));
				car.setType(result.getString(5));
				car.setPrice(result.getDouble(6));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return car;
	}

}
