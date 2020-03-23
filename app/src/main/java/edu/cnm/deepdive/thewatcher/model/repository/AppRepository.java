package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import io.reactivex.Single;
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

  public long insertApp(App app) {
    return database.getAppDao().insert(app);
  }

  public List<Long> insertApps(List<App> apps) {
    return database.getAppDao().insert(apps);
  }

  public LiveData<List<App>> getAllApps() {

    LiveData<List<App>> apps = database.getAppDao().select();
    return apps;
  }

  public LiveData<App> getAppById(Policy policy) {
    return database.getAppDao().selectSingleByApp(policy.getAppId());
  }



  private static class InstanceHolder {

    private static final AppRepository INSTANCE = new AppRepository();
  }

}
