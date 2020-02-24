package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import java.util.List;

public class AppRepository {

  private final TheWatcherDatabase database;

  private static Application context;

  private AppRepository() {

    if (context == null) {
      throw new IllegalArgumentException();
    }

    database = TheWatcherDatabase.getInstance();
  }

  public static void setContext(Application context) {
    AppRepository.context = context;
  }

  public static AppRepository getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public LiveData<List<App>> getAllApps() {
    return database.getAppDao().select();
  }

  public LiveData<List<Policy>> getAllPolicies() {
    return database.getPolicyDao().select();
  }

  private static class InstanceHolder {

    private static final AppRepository INSTANCE = new AppRepository();
  }

}
