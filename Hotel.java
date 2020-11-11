package com.blz.hotelreservation;

public class Hotel {

	private String hotelName;
	private int weekdayRoomRate;
	private int weekendRoomRate;
	private int rate;

	public Hotel(String hotelName, int weekDayRoomRate, int weekendRoomRate, int rate) {
		this.hotelName = hotelName;
		this.weekdayRoomRate = weekDayRoomRate;
		this.weekendRoomRate = weekendRoomRate;
		this.rate = rate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekdayRoomRate() {
		return weekdayRoomRate;
	}

	public void setWeekdayRoomRate(int weekdayRoomRate) {
		this.weekdayRoomRate = weekdayRoomRate;
	}

	public int getWeekendRoomRate() {
		return weekendRoomRate;
	}

	public void setWeekendRoomRate(int weekendRoomRate) {
		this.weekendRoomRate = weekendRoomRate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "HotelDetails [Hotel Name: " + hotelName + "  WeekdayRoomRate: " + weekdayRoomRate + " WeekendRoomRate: "
				+ weekendRoomRate + " Rating: " + rate + "]";
	}
}
