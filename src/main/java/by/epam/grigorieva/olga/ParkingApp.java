package by.epam.grigorieva.olga;

import by.epam.grigorieva.olga.parking.Car;
import by.epam.grigorieva.olga.parking.ParkingPlaceList;
import by.epam.grigorieva.olga.parking.Parking;
import by.epam.grigorieva.olga.parking.ParkingPlace;

public class ParkingApp {

    public static void main(String[] args) {
        ParkingPlaceList parkingPlaceList = new ParkingPlaceList();
        parkingPlaceList.addToList(makeParking(1,5));
        parkingPlaceList.addToList(makeParking(1,6));
        startThread(parkingPlaceList);
    }

    public static Parking makeParking(int parkingId, int parkingSize) {
        Parking parking = new Parking(parkingId, parkingSize);
        fillParking(parking, parkingSize);
        return parking;
    }

    public static void fillParking(Parking parking, int parkingSize) {
        for(int i = 0; i < parkingSize; i++) {
            parking.addToParkingPlaces(new ParkingPlace(i, parking.getParkingId()));
        }
    }

    public static void startThread(ParkingPlaceList parkingPlaceList) {
        for (int i = 0; i < 100; i++) {
            new Car(parkingPlaceList).start();
        }
    }

}