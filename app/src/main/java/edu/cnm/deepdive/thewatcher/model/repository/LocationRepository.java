package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.LocationEntity;
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

  public LiveData<List<LocationEntity>> getAllLocations() {
    return database.getLocationDao().select();
  }

  public LiveData<LocationEntity> getLocationById(long locationId) {
    return database.getLocationDao().getLocationById(locationId);
  }

  public LiveData<LocationEntity> getLocationByLatLong(double latitude, double longitude) {
    return database.getLocationDao().getLocationByLatLong(latitude, longitude);
  }

  public Single<List<Long>> insertLocations(Collection<LocationEntity> locationEntities) {
    return database.getLocationDao().insert(locationEntities);
  }

  public Single<Long> insertLocation(LocationEntity locationEntity) {
    return database.getLocationDao().insert(locationEntity);
  }

  private static class InstanceHolder {

    private static final LocationRepository INSTANCE = new LocationRepository();
  }

}
