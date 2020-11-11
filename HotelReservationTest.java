package com.blz.hotelreservation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.blz.hotelreservation.*;

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
}
