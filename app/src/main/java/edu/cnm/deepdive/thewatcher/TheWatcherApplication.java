package edu.cnm.deepdive.thewatcher;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class TheWatcherApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
