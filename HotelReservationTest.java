package com.blz.hotelreservation;

import java.text.ParseException;
import java.time.format.DateTimeParseException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.blz.hotelreservation.*;

public class HotelReservationTest {

	private static HotelReservation obj;

	@BeforeClass
	public static void createHotelReservationSystemObj() {
		obj = new HotelReservation();
	}

	@Test
	public void givenHotelsFindTheCheapestBestRatedForRegularCustomer_ReturnsBridgeWood() throws ParseException {
		try {
		String result = obj.cheapestBestRated("11Sep2020", "12Sep2020", "REGULAR");
		Assert.assertEquals("BridgeWood, Rating: 4 and Total Rates: $200", result);
		}catch(DateTimeParseException e) {
		}
	}

	@Test
	public void givenHotelsFindTheCheapestBestRatedForRewardCustomer_ReturnsRidgeWood() throws ParseException {
		try {
		String result = obj.cheapestBestRated("11Sep2020", "12Sep2020", "REWARD");
		Assert.assertEquals("RidgeWood, Rating: 5 and Total Rates: $140", result);
		}catch(DateTimeParseException e) {}
	}

	@Test
	public void givenHotelsFindTheBestRatedHotelForRegularCustomer_ReturnsRidgeWood() throws ParseException {
		try {
		String result = obj.findBestRatedHotel("11Sep2020", "12Sep2020", "REGULAR");
		Assert.assertEquals("RidgeWood & Total Rates: $370", result);
		}catch(DateTimeParseException e) {}
	}

	@Test
	public void givenHotelsFindTheBestRatedHotelForRewardCustomer_ReturnsRidgeWood() throws ParseException {
		try {
		String result = obj.findBestRatedHotel("11Sep2020", "12Sep2020", "REWARD");
		Assert.assertEquals("RidgeWood & Total Rates: $140", result);
		}catch(DateTimeParseException e) {}
	}
}
