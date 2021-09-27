package by.epam.grigorieva.olga;

import by.epam.grigorieva.olga.parking.Parking;
import by.epam.grigorieva.olga.parking.ParkingPlace;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static by.epam.grigorieva.olga.ParkingApp.fillParking;
import static by.epam.grigorieva.olga.ParkingApp.makeParking;

class ParkingAppTest {

    @Test
    void makeParkingTest() {
        Parking parkingExpected = new Parking(0, 5);
        parkingExpected.addToParkingPlaces(new ParkingPlace(0, parkingExpected.getParkingId()));
        parkingExpected.addToParkingPlaces(new ParkingPlace(1, parkingExpected.getParkingId()));
        parkingExpected.addToParkingPlaces(new ParkingPlace(2, parkingExpected.getParkingId()));
        parkingExpected.addToParkingPlaces(new ParkingPlace(3, parkingExpected.getParkingId()));
        parkingExpected.addToParkingPlaces(new ParkingPlace(4, parkingExpected.getParkingId()));

        Parking parkingActual = makeParking(0, 5);
        Assert.assertEquals(parkingExpected, parkingActual);
    }

    @Test
    void fillParkingTest() {
        Parking parkingExpected = new Parking(0, 5);
        parkingExpected.addToParkingPlaces(new ParkingPlace(0, parkingExpected.getParkingId()));
        parkingExpected.addToParkingPlaces(new ParkingPlace(1, parkingExpected.getParkingId()));
        parkingExpected.addToParkingPlaces(new ParkingPlace(2, parkingExpected.getParkingId()));
        parkingExpected.addToParkingPlaces(new ParkingPlace(3, parkingExpected.getParkingId()));
        parkingExpected.addToParkingPlaces(new ParkingPlace(4, parkingExpected.getParkingId()));

        Parking parkingActual = new Parking(0, 5);
        fillParking(parkingActual,5);
        Assert.assertEquals(parkingExpected, parkingActual);
    }

}