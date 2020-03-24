package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import edu.cnm.deepdive.thewatcher.model.entity.LocationEntity;
import edu.cnm.deepdive.thewatcher.model.entity.PolicyEntity;
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

  public LiveData<List<PolicyEntity>> getPolicyByValue() {
    return database.getPolicyDao().select();
  }

  public LiveData<List<PolicyEntity>> getAllPolicies(AppEntity appEntity, LocationEntity locationEntity) {
    return database.getPolicyDao().selectByAppAndLocation(appEntity.getId(), locationEntity.getLocationId());
  }

  public LiveData<List<PolicyEntity>> getAllPolicies(AppEntity appEntity) {
    return database.getPolicyDao().selectByApp(appEntity.getId());
  }

  public LiveData<List<PolicyEntity>> getAllPolcies(LocationEntity locationEntity) {
    return database.getPolicyDao().selectByLocation(locationEntity.getLocationId());
  }

  public Single<List<Long>> insertPolicies(List<PolicyEntity> policies) {
    return database.getPolicyDao().insert(policies);
  }

  public LiveData<List<PolicyEntity>> getPoliciesByLocation(long locationId) {
    return database.getPolicyDao().selectByLocation(locationId);
  }

  public LiveData<AppEntity> getAppByPolicy(PolicyEntity policyEntity) {
    return null;
  }

  private static class InstanceHolder {

    private static final PolicyRepository INSTANCE = new PolicyRepository();
  }

}
