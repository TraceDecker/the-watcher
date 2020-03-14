package edu.cnm.deepdive.thewatcher.controller;

import android.Manifest;
import android.Manifest.permission;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration mAppBarConfiguration;
  private MainViewModel mainViewModel;

  private static final String[] INITIAL_PERMS = {
      Manifest.permission.ACCESS_FINE_LOCATION,
      permission.READ_EXTERNAL_STORAGE
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    FloatingActionButton fab = findViewById(R.id.fab);

    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        setContentView(R.layout.activity_app_select);
      }
    });
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    NavigationView navigationView = findViewById(R.id.nav_view);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    mAppBarConfiguration = new AppBarConfiguration.Builder(
        R.id.nav_home, R.id.nav_pins, R.id.nav_restrictions,
        R.id.nav_tools)
        .setDrawerLayout(drawer)
        .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
    NavigationUI.setupWithNavController(navigationView, navController);
    setupViewModel();

    // does this go here?
    ActivityCompat.requestPermissions(this, INITIAL_PERMS, 0);
  }

  private void setupViewModel() {
    mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
// not sure if this is doing the same thing as above.
//    ActivityCompat.requestPermissions(this ,new String[]{permission.ACCESS_FINE_LOCATION,
//        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    return NavigationUI.navigateUp(navController, mAppBarConfiguration)
        || super.onSupportNavigateUp();
  }

}
