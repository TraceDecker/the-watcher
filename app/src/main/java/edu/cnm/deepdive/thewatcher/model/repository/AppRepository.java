package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import edu.cnm.deepdive.thewatcher.model.entity.PolicyEntity;
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

  public long insertApp(AppEntity appEntity) {
    return database.getAppDao().insert(appEntity);
  }

  public List<Long> insertApps(List<AppEntity> appEntities) {
    return database.getAppDao().insert(appEntities);
  }

  public LiveData<List<AppEntity>> getAllApps() {

    LiveData<List<AppEntity>> apps = database.getAppDao().select();
    return apps;
  }

  public LiveData<AppEntity> getAppById(PolicyEntity policyEntity) {
    return database.getAppDao().selectSingleByApp(policyEntity.getAppId());
  }



  private static class InstanceHolder {

    private static final AppRepository INSTANCE = new AppRepository();
  }

}
