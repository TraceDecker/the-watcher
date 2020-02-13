package edu.cnm.deepdive.thewatcher;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import io.reactivex.schedulers.Schedulers;

public class TheWatcherApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);

    TheWatcherDatabase.setContext(this);
    TheWatcherDatabase.getInstance().getAppDao().delete().subscribeOn(Schedulers.io()).subscribe();
  }

}
