package by.epam.grigorieva.olga.parking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;

public class Car extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Car.class);
    private final ParkingPlaceList parkingPlaceList;

    public Car(ParkingPlaceList parkingPlaceList){
        this.parkingPlaceList = parkingPlaceList;
    }

    @Override
    public void run(){
        this.setName("Car № " + this.getId());
        ParkingPlace parkingPlace = null;

        while(parkingPlace == null){
            parkingPlace = parkingPlaceList.getPlace(1000);
        }

        logger.info("Car № " + this.getId() + " took parking place № " + parkingPlace.getParkingPlaceId() + "Parking № " + parkingPlace.getParkingId());

        parkingPlace.carsParkingPlaces();

        logger.info("Car № " + this.getId() + " : " + parkingPlace.getParkingPlaceId() + " place owner. Parking № " + parkingPlace.getParkingId());

        while (true){
            if (parkingPlaceList.isPlaceForTaking(parkingPlace)){
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(parkingPlaceList, car.parkingPlaceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingPlaceList);
    }

    @Override
    public String toString() {
        return "Car's " +
                "parking: " + parkingPlaceList;
    }
}
