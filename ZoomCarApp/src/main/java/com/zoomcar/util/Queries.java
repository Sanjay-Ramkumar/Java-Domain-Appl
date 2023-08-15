package com.zoomcar.util;

public class Queries {
	//car table
	public static final String CREATEQUERY="create table if not exists car(carId int primary key,registerNo varchar(30),brand varchar(30),model varchar(30),type varchar(30),price double)";
	public static final String INSERTQUERY="insert into car(carId,registerNo,brand,model,type,price)values(?,?,?,?,?,?)";
	public static final String UPDATEQUERY="Update car SET price=? where carId=?";
	public static final String DELETEQUERY="Delete from car where carId=?";
	public static final String QUERYALL="Select * from car";
	public static final String QUERYBYTYPE="Select * from car where type LIKE ?";
	public static final String QUERYBYBRAND="Select * from car where brand LIKE ?";
	public static final String QUERYBYPRICELESSTHAN="Select * from car where price<?";
	public static final String QUERYBYTYPEANDPRICELESSTHAN="Select * from car where type LIKE ? && price<?";
	public static final String QUERYBYBRANDANDPRICELESSTHAN="Select * from car where brand LIKE ? && price<?";
	public static final String QUERYBYCARID="Select * from car where carId=?";
	//cust table
	public static final String CREATEQUERYRENTAL="create table if not exists rental(custId int,carId int,phone int(10),start_date varchar(30),end_date varchar(30))";
	public static final String QUERYALLBYRENTAL="Select * from rental";
	public static final String QUERYTORENT="insert into rental(custId,carId,phone,start_date,end_date) values(?,?,?,?,?)";
}
