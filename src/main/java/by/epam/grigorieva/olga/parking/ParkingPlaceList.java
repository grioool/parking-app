package by.epam.grigorieva.olga.parking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingPlaceList {
    private static final Logger logger = LoggerFactory.getLogger(Car.class);
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final ArrayList<Parking> parkingArrayList = new ArrayList<>();

    public void addToList(Parking parking) {
        parkingArrayList.add(parking);
    }

    public ParkingPlace getPlace(long maxWaitMillis) {
        ParkingPlace place = null;
        for (Parking parking : parkingArrayList) {
            ParkingPlace parkingPlace = parking.takePlace(maxWaitMillis);
            if (parkingPlace != null) {
                place = parkingPlace;
                break;
            } else {
                logger.info("Car №" + Thread.currentThread().getId() + " -> time is up. Going to another parking place.");
            }
        }
        return place;
    }

    public boolean isPlaceForTaking(ParkingPlace parkingPlace) {
        boolean isPlaceForTaking = false;

        if (reentrantLock.tryLock()) {
            for (Parking park : parkingArrayList) {
                if (park.getParkingId() == parkingPlace.getParkingId()) {
                    park.leavePlace(parkingPlace);
                }
            }
            isPlaceForTaking = true;
            reentrantLock.unlock();
        }
        return isPlaceForTaking;
    }

}
