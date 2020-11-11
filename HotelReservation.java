package com.blz.hotelreservation;

import java.util.ArrayList;

public class HotelReservation {

	private static ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		
	public ArrayList<Hotel> getHotel(){
		return hotelList;
	}

	public static void addhotel(String hotel, int price) {
		Hotel hotels = new Hotel(hotel,price);
		hotelList.add(hotels);
	}
	
	public static int countNoOfHotels() {
		return hotelList.size();
	}

	public static void main(String[] args) {
		System.out.println("WELCOME TO HOTEL RESERVATION PROGRAM");
		hotelList.add(new Hotel("Lakewood",110));
		hotelList.add(new Hotel("Bridgewood",160));
		hotelList.add(new Hotel("Ridgewood",220));
		System.out.println(hotelList);
	}
}