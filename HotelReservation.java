package com.blz.hotelreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HotelReservation {

	private static int price;
	public static ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	static Map<String, Integer> map = new HashMap<>();
	static Map<String, Integer> rent = new HashMap<>();

	public ArrayList<Hotel> getHotel() {
		return hotelList;
	}

	public static void addhotel(String name, int weekDayRegularRate, int weekEndRegularRate, int weekDayRewardRate,
			int weekEndRewardRate, int rate) {

		Hotel hotels = new Hotel(name, weekDayRegularRate, weekEndRegularRate, weekDayRewardRate, weekEndRewardRate,
				rate);
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

	public static void findhotelRent(String startDate, String endDate, String customer) {
		LocalDate startDateInput = convertStringToDate(startDate);
		LocalDate endDateInput = convertStringToDate(endDate);
		Integer hotelRent;

		addhotel("LakeWood", 110, 90, 80, 80, 3);
		addhotel("BridgeWood", 150, 50, 110, 50, 4);
		addhotel("RidgeWood", 220, 150, 100, 40, 5);

		for (Hotel hotelDetail : hotelList) {
			LocalDate startDay = startDateInput;
			LocalDate endDay = endDateInput.plusDays(1);
			hotelRent = 0;
			while (!(startDay.equals(endDay))) {
				int day = startDay.getDayOfWeek().getValue();
				switch (customer) {
				case "REGULAR":
					if (day == 6 || day == 7) {
						hotelRent = hotelRent + hotelDetail.getWeekEndRegularRate();
					} else {
						hotelRent = hotelRent + hotelDetail.getWeekDayRegularRate();
					}
					break;
				case "REWARD":
					if (day == 6 || day == 7) {
						hotelRent = hotelRent + hotelDetail.getWeekEndRewardRate();
					} else {
						hotelRent = hotelRent + hotelDetail.getWeekDayRewardRate();
					}
					break;
				}
				startDay = startDay.plusDays(1);
			}
			rent.put(hotelDetail.getHotelName(), hotelRent);
		}
	}

	public static ArrayList<String> findCheapestHotel(String startDate, String endDate, String customer) {
		LocalDate startDateInput = convertStringToDate(startDate);
		LocalDate endDateInput = convertStringToDate(endDate);

		addhotel("LakeWood", 110, 90, 80, 80, 3);
		addhotel("BridgeWood", 150, 50, 110, 50, 4);
		addhotel("RidgeWood", 220, 150, 100, 40, 5);

		ArrayList<String> cheapestHotelNameList = new ArrayList<>();

		int minRate = Integer.MAX_VALUE;
		for (Hotel hotelDetail : hotelList) {
			LocalDate startDay = startDateInput;
			LocalDate endDay = endDateInput.plusDays(1);
			int hotelRent = 0;
			while (!(startDay.equals(endDay))) {
				int day = startDay.getDayOfWeek().getValue();
				switch (customer) {
				case "REGULAR":
					if (day == 6 || day == 7) {
						hotelRent = hotelRent + hotelDetail.getWeekEndRegularRate();
					} else {
						hotelRent = hotelRent + hotelDetail.getWeekDayRegularRate();
					}
					break;
				case "REWARD":
					if (day == 6 || day == 7) {
						hotelRent = hotelRent + hotelDetail.getWeekEndRewardRate();
					} else {
						hotelRent = hotelRent + hotelDetail.getWeekDayRewardRate();
					}
					break;
				}
				startDay = startDay.plusDays(1);
			}
			if (hotelRent <= minRate) {
				minRate = hotelRent;
				price = hotelRent;
				cheapestHotelNameList.add(hotelDetail.getHotelName());
				map.put(hotelDetail.getHotelName(), hotelDetail.getRate());
			}
		}
		return cheapestHotelNameList;
	}

	public String cheapestBestRated(String startDate, String endDate, String customer) {
		findCheapestHotel(startDate, endDate, customer);

		Map.Entry<String, Integer> cheapestBestRatedHotel = null;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (cheapestBestRatedHotel == null || entry.getValue().compareTo(cheapestBestRatedHotel.getValue()) > 0) {
				cheapestBestRatedHotel = entry;
			}
		}
		return cheapestBestRatedHotel.getKey() + ", Rating: " + cheapestBestRatedHotel.getValue()
				+ " and Total Rates: $" + price;
	}

	public String findBestRatedHotel(String startDate, String endDate, String customer) {
		findhotelRent(startDate, endDate, customer);

		addhotel("LakeWood", 110, 90, 80, 80, 3);
		addhotel("BridgeWood", 150, 50, 110, 50, 4);
		addhotel("RidgeWood", 220, 150, 100, 40, 5);

		int bestRating = 0;
		Hotel BestRatedHotel = null;
		for (Hotel hotelDetail : hotelList) {
			if (hotelDetail.getRate() > bestRating) {
				bestRating = hotelDetail.getRate();
				BestRatedHotel = hotelDetail;
			}
		}
		return BestRatedHotel.getHotelName() + " & Total Rates: $" + rent.get(BestRatedHotel.getHotelName());
	}
}