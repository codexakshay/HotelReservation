package com.blz.hotelreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;

public class HotelReservation {

	private static ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	public ArrayList<Hotel> getHotel() {
		return hotelList;
	}

	public static void addhotel(String hotel, int price) {
		Hotel hotels = new Hotel(hotel, price);
		hotelList.add(hotels);
	}

	public static int countNoOfHotels() {
		return hotelList.size();
	}

	public static LocalDate convertStringToDate(String dateString) {
		LocalDate date = null;
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		try {
			date = LocalDate.parse(dateString, dateTimeFormat);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String findCheapestHotel(String startDate, String endDate) {

		LocalDate startDateInput = convertStringToDate(startDate);
		LocalDate endDateInput = convertStringToDate(endDate);

		int numOfBookingDays = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
		
		hotelList.add(new Hotel("Lakewood", 110));
		hotelList.add(new Hotel("Bridgewood", 150));
		hotelList.add(new Hotel("Ridgewood", 220));
		
		for(int hotel = 0; hotel < hotelList.size(); hotel++) {
			int newRate = hotelList.get(hotel).getRegularRate() * (numOfBookingDays);
			hotelList.get(hotel).setRegularRate(newRate);
		}
		String hotelName = hotelList.stream().min(Comparator.comparing(Hotel::getRegularRate)).get()
				.getHotelName();
		int regularRate = hotelList.stream().min(Comparator.comparing(Hotel::getRegularRate)).get()
				.getRegularRate();
		return hotelName + " Total Cost: $" + regularRate;
		}
}