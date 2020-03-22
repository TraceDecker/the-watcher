package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import io.reactivex.Single;
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

  public LiveData<List<Policy>> getPolicyByValue() {
    return database.getPolicyDao().select();
  }

  public LiveData<List<Policy>> getAllPolicies(App app, Location location) {
    return database.getPolicyDao().selectByAppAndLocation(app.getId(), location.getLocationId());
  }

  public LiveData<List<Policy>> getAllPolicies(App app) {
    return database.getPolicyDao().selectByApp(app.getId());
  }

  public LiveData<List<Policy>> getAllPolcies(Location location) {
    return database.getPolicyDao().selectByLocation(location.getLocationId());
  }

  public Single<List<Long>> insertPolicies(List<Policy> policies) {
    return database.getPolicyDao().insert(policies);
  }

  private static class InstanceHolder {

    private static final PolicyRepository INSTANCE = new PolicyRepository();
  }

}
