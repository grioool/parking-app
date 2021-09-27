package by.epam.grigorieva.olga.parking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class ParkingPlace {
    private static final Logger logger = LoggerFactory.getLogger(ParkingPlace.class);
    private final int parkingPlaceId;
    private final int parkingId;

    public ParkingPlace(int parkingPlaceId, int parkingId) {
        this.parkingId = parkingId;
        this.parkingPlaceId = parkingPlaceId;
    }

    public void carsParkingPlaces() {
        logger.info("Parking place № " + parkingPlaceId + "is used by Car № " + Thread.currentThread().getId());
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            logger.error("", e);
        }
    }

    public int getParkingPlaceId() {
        return parkingPlaceId;
    }

    public int getParkingId() {
        return parkingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingPlace that = (ParkingPlace) o;
        return parkingPlaceId == that.parkingPlaceId && parkingId == that.parkingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingPlaceId, parkingId);
    }

    @Override
    public String toString() {
        return "Parking Place = " +
                "parking Place Id = " + parkingPlaceId +
                ", parking Id = " + parkingId;
    }
}
