package edu.cnm.deepdive.thewatcher;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.thewatcher.model.repository.AppRepository;
import edu.cnm.deepdive.thewatcher.model.repository.LocationRepository;
import edu.cnm.deepdive.thewatcher.model.repository.PolicyRepository;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import io.reactivex.schedulers.Schedulers;

public class TheWatcherApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);

    AppRepository.setContext(this);
    PolicyRepository.setContext(this);
    LocationRepository.setContext(this);

    TheWatcherDatabase.setContext(this);
    TheWatcherDatabase.getInstance().getAppDao().delete().subscribeOn(Schedulers.io()).subscribe();
  }

}
