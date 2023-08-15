package com.zoomcar.client;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import com.zoomcar.model.Car;
import com.zoomcar.model.Rental;
import com.zoomcar.service.CarServiceImpl;
import com.zoomcar.service.ICarService;

public class Client {

	public static void main(String[] args) {
		ICarService carService=new CarServiceImpl();
		Scanner scanner =new Scanner(System.in);
		List<Car>car1=Arrays.asList(new Car(101,"KA01AB1234","Suzuki","Dzire",4000,"sedan"),
				new Car(102,"KA03XY4321","Suzuki","ciaz",6000,"sedan"),new Car(103,"KA05SA7890","Suzuki","SX4",9500,"sedan"),
				new Car(104,"KA51AB3678","Suzuki","Ertiga",14000,"compactsuv"),new Car(105,"KA05AS6590","Suzuki","Fronx",10500,"compactsuv"),
				new Car(106,"KA06SA7820","Toyota","Etios",5500,"sedan"),new Car(107,"KA05SA7090","Toyota","Innova",20500,"MPV"),
				new Car(108,"KA05SA7000","Toyota","Fortuner",23500,"MPV"),new Car(109,"KA60DC0989","Honda","City",11000,"sedan"),
				new Car(110,"KA01CF8765","Honda","Jazz",8500,"hatch"),new Car(111,"KA07SA7190","Honda","Brio",4000,"hatch"),
				new Car(112,"KA537RD8901","Hyundai","i20",10000,"hatch"),new Car(113,"KA05SA7820","Hyundai","Creta",11000,"compactsuv"));
//		for(Car car:car1) {
//			carService.addCar(car);
//		}
		List <Car>cars;
		List<Rental>rental;
		System.out.println("Welcome to Zoom Cars!!");
		System.out.println();
		System.out.println("1.Admin Login");		System.out.println("2.Customer Login");
		System.out.println();
		System.out.println("Enter your choice");
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:{
			System.out.println("Enter username");
			String username=scanner.next();
			System.out.println("Enter password");
			String password=scanner.next();
			if(username.equalsIgnoreCase("Sanjay") && password.equals("admin@123")) {
				System.out.println("Login Successful");
				System.out.println("Admin Fucntionalities");
				System.out.println("1. Show cars");
				System.out.println("2. Add car");
				System.out.println("3. Remove car");
				System.out.println("4. Modify car");
				System.out.println("5. See Rentals");
				System.out.println("6. Filter the records");
				System.out.println("Enter your choice for appropriate functionality");
				int choice1=scanner.nextInt();
				switch(choice1) {
				case 1:{
					System.out.println("Displaying all cars");
					cars=carService.getAll();
					cars.forEach(System.out::println);
					break;
				}
				case 2:{
					System.out.println("Add Car");
					System.out.println("Enter Id:");
					int carid=scanner.nextInt();
					System.out.println("Enter register no:");
					String regNo=scanner.next();
					System.out.println("Enter model:");
					String model=scanner.next();
					System.out.println("Enter brand:");
					String brand=scanner.next();
					System.out.println("Enter type:");
					String type=scanner.next();
					System.out.println("Enter price:");
					double price=scanner.nextDouble();
					carService.addCar(new Car(carid,regNo,model,brand,price,type));
					break;
				}
				case 3:{
					System.out.println("Removing Car");
						
						System.out.println("Enter the carId");
						int carid=scanner.nextInt();
						carService.removeCar(carid);
					break;
				}
				case 4:{
					System.out.println("Modify car");
					System.out.println("Enter the carId");
					int carId=scanner.nextInt();
					System.out.println("Enter the price");
					double price=scanner.nextDouble();
					if(carService.modifyCar(carId, price)>0) {
						System.out.println("Modified Successfully");
					}
					else {
						System.out.println("Modification failed");
					}
					break;
				}
				case 5:{
					System.out.println("Displaying all cars");
					rental=carService.getRentals();
					if(rental.isEmpty()) {
						System.out.println("Rental List is empty");
					}else {
						
						rental.forEach(System.out::println);
					}
					break;
				}
				case 6:{
					System.out.println("filtering options");
					System.out.println("1.By Type");
					System.out.println("2.By Brand");
					System.out.println("3.By PriceLessThan");
					System.out.println("4.By TypeAndPriceLessThan");
					System.out.println("5.By BrandAndPriceLessThan");
					System.out.println("6. By CarId");
					System.out.println("Enter Choice");
					int choice2=scanner.nextInt();
					switch(choice2) {
					case 1:{
						System.out.println("Enter type");
						String type=scanner.next();
						cars=carService.getByTypeContains(type);
						System.out.println("Cars by Type");
						cars.forEach(System.out::println);
						break;
					}
					case 2:{
						System.out.println("Enter brand");
						String brand=scanner.next();
						cars=carService.getByBrandContains(brand);
						System.out.println("Cars by Brand");
						cars.forEach(System.out::println);
						break;
					}
					case 3:{
						System.out.println("Enter price");
						double price=scanner.nextDouble();
						cars=carService.getByPricelessThan(price);
						System.out.println("Cars by Price less than ");
						cars.forEach(System.out::println);
						break;
					}
					case 4:{
						System.out.println("Enter type");
						String type=scanner.next();
						System.out.println("Enter price");
						double price=scanner.nextDouble();
						cars=carService.getByTypeContainsAndPricelessThan(type,price);
						System.out.println("Cars by type and Price less than ");
						cars.forEach(System.out::println);
						break;
					}
					case 5:{
						System.out.println("Enter brand");
						String brand=scanner.next();
						System.out.println("Enter price");
						double price=scanner.nextDouble();
						cars=carService.getByBrandContainsAndPricelessThan(brand,price);
						System.out.println("Cars by brand and Price less than ");
						cars.forEach(System.out::println);
						break;
					}
					case 6:{
						System.out.println("Enter carId");
						int carId=scanner.nextInt();
						Car car=carService.getById(102);
					    System.out.println("Cars by id");
					    System.out.println(car);
					    break;
					}
					default:{
						System.out.println("Enter a valid choice");
					}
					}
					break;
				}
				default :{
					System.out.println("Enter a valid choice");
				}
				}
			}
			else {
				System.out.println("Username is not found");
			}
			break;
		}
		case 2:{
			System.out.println("Enter username");
			String username=scanner.next();
			System.out.println("Enter password");
			String password=scanner.next();
			if(username.equalsIgnoreCase("sathya") && password.equals("123") || username.equalsIgnoreCase("Muthu") && password.equals("123")) {
			System.out.println("Customer Functionalities");
			System.out.println("1. Show car");
			System.out.println("2. Rent car");
			System.out.println("3. Filter the records");
			System.out.println("Enter your choice for appropriate functionality");
			int choice1=scanner.nextInt();
			switch(choice1) {
			case 1:{
				System.out.println("Displaying all cars");
				cars=carService.getAll();
				cars.forEach(System.out::println);
				break;
			}
			case 2:{
				System.out.println("Rent a Car");
				System.out.println("Enter custId:");
				int custid=scanner.nextInt();
				System.out.println("Enter carId:");
				int carId=scanner.nextInt();
				System.out.println("Enter phonenumber:");
				int phone=scanner.nextInt();
				System.out.println("Enter startdate:");
				String stdate=scanner.next();
				System.out.println("Enter Enddate");
				String enddate=scanner.next();
				carService.rentCar(new Rental(custid,carId,stdate,enddate,phone));
				break;
			}
			
			case 3:{
				System.out.println("filtering options");
				System.out.println("1.By Type");
				System.out.println("2.By Brand");
				System.out.println("3.By PriceLessThan");
				System.out.println("4.By TypeAndPriceLessThan");
				System.out.println("5.By BrandAndPriceLessThan");
				System.out.println("6.By carId");
				System.out.println("Enter Choice");
				int choice2=scanner.nextInt();
				switch(choice2) {
				case 1:{
					System.out.println("Enter type");
					String type=scanner.next();
					cars=carService.getByTypeContains(type);
					System.out.println("Cars by Type");
					cars.forEach(System.out::println);
					break;
				}
				case 2:{
					System.out.println("Enter brand");
					String brand=scanner.next();
					cars=carService.getByBrandContains(brand);
					System.out.println("Cars by Brand");
					cars.forEach(System.out::println);
					break;
				}
				case 3:{
					System.out.println("Enter price");
					double price=scanner.nextDouble();
					cars=carService.getByPricelessThan(price);
					System.out.println("Cars by Price less than ");
					cars.forEach(System.out::println);
					break;
				}
				case 4:{
					System.out.println("Enter type");
					String type=scanner.next();
					System.out.println("Enter price");
					double price=scanner.nextDouble();
					cars=carService.getByTypeContainsAndPricelessThan(type,price);
					System.out.println("Cars by type and Price less than ");
					cars.forEach(System.out::println);
					break;
				}
				case 5:{
					System.out.println("Enter brand");
					String brand=scanner.next();
					System.out.println("Enter price");
					double price=scanner.nextDouble();
					cars=carService.getByBrandContainsAndPricelessThan(brand,price);
					System.out.println("Cars by brand and Price less than ");
					cars.forEach(System.out::println);
					break;
				}
				case 6:{
					System.out.println("Enter carId");
					int carId=scanner.nextInt();
					Car car=carService.getById(102);
				    System.out.println("Cars by id");
				    System.out.println(car);
				    break;
				}
				default:{
					System.out.println("Enter a valid choice");
				}
				}
			}
			default :{
				System.out.println("Enter a valid choice");
			}
			}
			}
			break;
		}
		default:{
			System.out.println("Enter a valid choice");
		}
		}
		
	}

}
