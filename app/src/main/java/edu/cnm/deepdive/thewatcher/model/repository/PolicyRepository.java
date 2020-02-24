package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
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

  public LiveData<List<Policy>> getAllPolicies() {
    return database.getPolicyDao().select();
  }

  private static class InstanceHolder {

    private static final PolicyRepository INSTANCE = new PolicyRepository();
  }

}
