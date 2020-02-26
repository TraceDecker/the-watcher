package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import io.reactivex.Single;
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



  private static class InstanceHolder {

    private static final LocationRepository INSTANCE = new LocationRepository();
  }

}
