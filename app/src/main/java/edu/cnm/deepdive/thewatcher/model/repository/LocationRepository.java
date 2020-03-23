package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public class LocationRepository {

  private final TheWatcherDatabase database;

  private static Application context;

  private LocationRepository() {

    if (context == null) {
      throw new IllegalArgumentException();
    }

    database = TheWatcherDatabase.getInstance();
  }

  public static void setContext(Application context) {
    LocationRepository.context = context;
  }

  public static LocationRepository getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public LiveData<List<Location>> getAllLocations() {
    return database.getLocationDao().select();
  }

  public Single<Location> getLocationById(long locationId) {
    return database.getLocationDao().getLocationById(locationId);
  }

  public Single<Location> getLocationByLatLong(double latitude, double longitude) {
    return database.getLocationDao().getLocationByLatLong(latitude, longitude);
  }

  public Single<List<Long>> insertLocations(Collection<Location> locations) {
    return database.getLocationDao().insert(locations);
  }

  public Single<Long> insertLocation(Location location) {
    return database.getLocationDao().insert(location);
  }

  private static class InstanceHolder {

    private static final LocationRepository INSTANCE = new LocationRepository();
  }

}
