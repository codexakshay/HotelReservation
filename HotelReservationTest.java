package com.blz.hotelreservation;

import java.text.ParseException;
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
	public void inGivenHotelsFindTheCheapestRatedOne() throws ParseException {
		String result = obj.cheapestBestRated("11Sep2020", "12Sep2020");
		Assert.assertEquals("BridgeWood, Rating: 4 and Total Rates: $200", result);
	}

	@Test
	public void givenHotelsFindTheBestRatedHotel() throws ParseException {
		String result = obj.findBestRatedHotel("11Sep2020", "12Sep2020");
		Assert.assertEquals("RidgeWood & Total Rates: $370", result);
	}
}
