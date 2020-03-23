package edu.cnm.deepdive.thewatcher.services;

import android.app.Application;
import android.location.Location;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class LocationProviderSerivce {


  private Location mlocation;
  private Application context;
  private FusedLocationProviderClient fusedLocationClient;

  public LocationProviderSerivce(Application context) {
    fusedLocationClient = LocationServices
        .getFusedLocationProviderClient(context);
  }

  public Location getLocation() {

    Task<Location> locationTask = fusedLocationClient.getLastLocation();
    locationTask.addOnSuccessListener(new OnSuccessListener<Location>() {
      @Override
      public void onSuccess(Location location) {
        if (location != null) {
          mlocation = location;
        }
      }
    });
    return mlocation;
  }

}
