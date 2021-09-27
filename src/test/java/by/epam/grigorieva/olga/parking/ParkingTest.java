package by.epam.grigorieva.olga.parking;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class ParkingTest {

    @Test
    void getParkingIdTest() {
        int parkingIdExpected = 0;
        Parking parking = new Parking(parkingIdExpected,5);
        int parkingIdActual = parking.getParkingId();
        Assert.assertEquals(parkingIdExpected, parkingIdActual);
    }

}