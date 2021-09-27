package by.epam.grigorieva.olga.parking;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParkingPlaceListTest {

    @Test
    void addToList() {
        Parking parking = new Parking(0,5);
        ParkingPlaceList parkingPlaceList = new ParkingPlaceList();
        ArrayList<Parking> parkingArrayList = new ArrayList<>();

        parkingArrayList.add(parking);
        parkingPlaceList.addToList(parking);
        Assert.assertEquals(parkingArrayList, parkingPlaceList);
    }
}