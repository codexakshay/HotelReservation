package com.blz.hotelreservation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void givendetailsOf3Hotels_WhenAddedToHotelList_SizeOfListIs3() {
		Assert.assertEquals(3, HotelReservation.countNoOfHotels());
	}

	@Test
	public void givenDetailsOf3Hotels_InAGivenDataRage_shouldReturnCheapesthotel() {
		String cheapestHotelInfo = HotelReservation.findCheapestHotel("10Sep2020", "11Sep2020");
		Assert.assertEquals("Lakewood Total Cost: $220", cheapestHotelInfo);
	}

	@Test
	public void givenDetailsOf3Hotels_WhenWeekdayAndWeekendRatesAdded_ShouldReturnThoseRates() {
		List<Integer> weekendRoomRates = new ArrayList<>();
		List<Integer> weekdayRoomRates = new ArrayList<>();
		HotelReservation.hotelList.stream().forEach(hotelDetails -> {
			weekendRoomRates.add(hotelDetails.getWeekendRoomRate());
			weekdayRoomRates.add(hotelDetails.getWeekdayRoomRate());
			String cheapestHotelInfo = HotelReservation.findCheapestHotel("10Sep2020", "11Sep2020");
			Assert.assertEquals("Lakewood Total Cost: $220", cheapestHotelInfo);
		});
		Assert.assertEquals(110, (int) weekdayRoomRates.get(0));
		Assert.assertEquals(160, (int) weekdayRoomRates.get(1));
		Assert.assertEquals(220, (int) weekdayRoomRates.get(2));
		Assert.assertEquals(90, (int) weekendRoomRates.get(0));
		Assert.assertEquals(60, (int) weekendRoomRates.get(1));
		Assert.assertEquals(150, (int) weekendRoomRates.get(2));
	}
}
