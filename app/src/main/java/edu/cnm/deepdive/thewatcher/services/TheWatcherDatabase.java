package edu.cnm.deepdive.thewatcher.services;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.thewatcher.model.dao.AppDao;
import edu.cnm.deepdive.thewatcher.model.dao.LocationDao;
import edu.cnm.deepdive.thewatcher.model.dao.PolicyDao;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;

@Database(
    entities = {App.class, Policy.class, Location.class},
    version = 1,
    exportSchema = true
)
public abstract class TheWatcherDatabase extends RoomDatabase {

  private static final String DB_NAME = "watcher_db";

  private static Application context;

  public static void setContext(Application context) {
    TheWatcherDatabase.context = context;
  }

  public static TheWatcherDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract AppDao getAppDao();

  public abstract PolicyDao getPolicyDao();

  public abstract LocationDao getLocationDao();

  private static class InstanceHolder {

    private static final TheWatcherDatabase INSTANCE = Room.databaseBuilder(
        context, TheWatcherDatabase.class, DB_NAME)
        .build();

  }

}
