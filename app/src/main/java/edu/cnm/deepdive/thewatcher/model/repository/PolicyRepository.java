package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import java.util.List;

public class PolicyRepository {

  private final TheWatcherDatabase database;

  private static Application context;

  private PolicyRepository() {

    if (context == null) {
      throw new IllegalArgumentException();
    }

    database = TheWatcherDatabase.getInstance();
  }

  public static void setContext(Application context) {
    PolicyRepository.context = context;
  }

  public static PolicyRepository getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public LiveData<List<Policy>> getAllPolicies(App app, Location location) {
    return database.getPolicyDao().selectByAppAndLocation(app.getId(), location.getLocationId());
  }

  private LiveData<List<Policy>> getAllPolicies(App app) {
    return database.getPolicyDao().selectByApp(app.getId());
  }

  private LiveData<List<Policy>> getAllPolcies(Location location) {
    return database.getPolicyDao().selectByLocation(location.getLocationId());
  }

  private static class InstanceHolder {

    private static final PolicyRepository INSTANCE = new PolicyRepository();
  }

}
