package edu.cnm.deepdive.thewatcher.model.repository;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import java.util.List;

public class TheWatcherRepository {

  private final TheWatcherDatabase database;

  private static Application context;

  private TheWatcherRepository() {
    if (context == null) {
      throw new IllegalArgumentException();
    }

    database = TheWatcherDatabase.getInstance();
  }

  public static void setContext(Application context) {
    TheWatcherRepository.context = context;
  }

  public static TheWatcherRepository getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public LiveData<List<Policy>> getAllPolicies() {
    return database.getPolicyDao().select();
  }

  private static class InstanceHolder {

    private static final TheWatcherRepository INSTANCE = new TheWatcherRepository();
  }

}
