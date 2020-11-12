package com.blz.hotelreservation;

public class Hotel {

	private String hotelName;
	private int weekDayRegularRate;
	private int weekEndRegularRate;
	private int rate;
	private int weekDayRewardRate;
	private int weekEndRewardRate;

	public Hotel(String hotelName, int weekDayRegularRate, int weekEndRegularRate, int weekDayRewardRate,
			int weekEndRewardRate, int rate) {
		this.hotelName = hotelName;
		this.weekDayRegularRate = weekDayRegularRate;
		this.weekEndRegularRate = weekEndRegularRate;
		this.weekDayRewardRate = weekDayRewardRate;
		this.weekEndRewardRate = weekEndRewardRate;
		this.rate = rate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekDayRegularRate() {
		return weekDayRegularRate;
	}

	public void setWeekDayRegularRate(int weekDayRegularRate) {
		this.weekDayRegularRate = weekDayRegularRate;
	}

	public int getWeekEndRegularRate() {
		return weekEndRegularRate;
	}

	public void setWeekEndRegularRate(int weekEndRegularRate) {
		this.weekEndRegularRate = weekEndRegularRate;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getWeekDayRewardRate() {
		return weekDayRewardRate;
	}

	public void setWeekDayRewardRate(int weekDayRewardRate) {
		this.weekDayRewardRate = weekDayRewardRate;
	}

	public int getWeekEndRewardRate() {
		return weekEndRewardRate;
	}

	public void setWeekEndRewardRate(int weekEndRewardRate) {
		this.weekEndRewardRate = weekEndRewardRate;
	}

	@Override
	public String toString() {
		return "HotelDetails [Hotel Name: " + hotelName + "  Regular_WeekDayRoomRate: " + weekDayRegularRate
				+ " Regular_WeekendRoomRate: " + weekEndRegularRate + "  Reward_WeekDayRoomRate: " + weekDayRewardRate
				+ " Reward_WeekendRoomRate: " + weekEndRewardRate + " Rating: " + rate + "]";
	}
}
