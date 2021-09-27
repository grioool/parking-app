package by.epam.grigorieva.olga.parking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking {
    private static final Logger logger = LoggerFactory.getLogger(ParkingPlace.class);
    private final int parkingId;
    private int parkingSize;
    private final Queue<ParkingPlace> places = new ConcurrentLinkedQueue<>();
    private final Semaphore semaphore;

    public Parking(int parkingId, int parkingSize) {
        this.parkingId = parkingId;
        this.parkingSize = parkingSize;
        this.semaphore = new Semaphore(parkingSize, true);
    }

    public int getParkingId() {
        return parkingId;
    }

    public void addToParkingPlaces(ParkingPlace place) {
        if (parkingSize >= 0) {
            places.add(place);
            parkingSize--;
        }
    }

    public ParkingPlace takePlace(long maxWaitMillis) {
        ParkingPlace parkingPlace = null;
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                ParkingPlace place = places.poll();
                parkingPlace = place;
            }
        } catch (InterruptedException e) {
            logger.error("", e);
        }
        return parkingPlace;
    }

    public void leavePlace(ParkingPlace place) {
        places.add(place);
        semaphore.release();
    }

    @Override
    public String toString() {
        return "Parking: " +
                " parkingId = " + parkingId +
                "\nparkingSize=" + parkingSize +
                "\nparking places=" + places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return parkingId == parking.parkingId && parkingSize == parking.parkingSize && Objects.equals(places, parking.places) && Objects.equals(semaphore, parking.semaphore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingId, parkingSize, places, semaphore);
    }
}
