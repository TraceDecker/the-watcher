package edu.cnm.deepdive.thewatcher.services;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import edu.cnm.deepdive.thewatcher.model.dao.AppDao;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import java.util.ArrayList;
import java.util.List;

public class PackService{

  private AppDao appDao;
  private Context context;
  List<AppEntity> appEntities = new ArrayList<>();

  public PackService(Context context) {
    this.appDao = TheWatcherDatabase.getInstance().getAppDao();
    this.context = context;
  }

  public void getAppsFromDevice() {
    List<PackageInfo> packageInfoList = context.getPackageManager().getInstalledPackages(0);

    for (PackageInfo info : packageInfoList) {
      AppEntity appEntity = new AppEntity();
      if(info.applicationInfo.name != null){
        appEntity.setAppName(info.applicationInfo.name);
        appEntity.setAppPackage(info.packageName);
        appEntities.add(appEntity);
      }

    }

    AppTask appTask = new AppTask();
    appTask.execute();

  }

  public class AppTask extends AsyncTask<Void, Void, List<AppEntity>> {

    List<AppEntity> appsList = appEntities;


    @Override
    protected List<AppEntity> doInBackground(Void... Voids) {
      TheWatcherDatabase.getInstance().getAppDao().insert(appsList);
      return appEntities;
    }
  }
}
