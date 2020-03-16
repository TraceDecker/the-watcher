package edu.cnm.deepdive.thewatcher;

import android.Manifest;
import android.Manifest.permission;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION_CODES;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AppSelectActivity extends AppCompatActivity {

  private ImageView imageView;
  private Drawable appIcon;

  private static final String[] INITIAL_PERMS = {
      permission.READ_EXTERNAL_STORAGE
  };

  @RequiresApi(api = VERSION_CODES.M)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_app_select);
    imageView = (ImageView) findViewById(R.id.image_test);

   // requestPermissions(INITIAL_PERMS, 1);
   // installedApps();
  }

  public void installedApps() {
    List<PackageInfo> packages = new LinkedList<>();
    List<PackageInfo> packageList = getPackageManager().getInstalledPackages(0);
    for (int i = 0; i < packageList.size(); i++) {


      Drawable appIcon = null;
      try {
        appIcon = getPackageManager().getApplicationIcon("com.youtube");
      } catch (NameNotFoundException e) {
        e.printStackTrace();
      }
      imageView.setImageDrawable(appIcon);
    }
  }

}
