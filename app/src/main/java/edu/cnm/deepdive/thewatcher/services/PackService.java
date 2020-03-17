package edu.cnm.deepdive.thewatcher.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import edu.cnm.deepdive.thewatcher.model.dao.AppDao;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PackService{

  private AppDao appDao;
  private Context context;
  List<App> apps = new ArrayList<>();

  public PackService(Context context) {
    this.appDao = TheWatcherDatabase.getInstance().getAppDao();
    this.context = context;
  }

  public void getAppsFromDevice() {
    List<PackageInfo> packageInfoList = context.getPackageManager().getInstalledPackages(0);

    for (PackageInfo info : packageInfoList) {
      App app = new App();
      if(info.applicationInfo.name != null){
        app.setAppName(info.applicationInfo.name);
        app.setAppPackage(info.packageName);
        apps.add(app);
      }

    }

    AppTask appTask = new AppTask();
    appTask.execute();

  }

  public class AppTask extends AsyncTask<Void, Void, List<App>> {

    List<App> appsList = apps;


    @Override
    protected List<App> doInBackground(Void... Voids) {
      TheWatcherDatabase.getInstance().getAppDao().insert(appsList);
      return apps;
    }
  }
}
