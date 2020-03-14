package edu.cnm.deepdive.thewatcher.controller.ui.home;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.controller.MainActivity;
import java.util.Objects;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

  private HomeViewModel homeViewModel;
  private MapView mapView;
  private GoogleMap map;
  private FusedLocationProviderClient fusedLocationProvider;

  private static final String[] INITIAL_PERMS = {
      Manifest.permission.ACCESS_FINE_LOCATION,
  };

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestPermissions(INITIAL_PERMS, 0);



//    fusedLocationProvider = LocationServices.getFusedLocationProviderClient(getActivity());
  }
// not sure about this.
//  private void getLastLocation() {
//    fusedLocationProvider.getLastLocation().addOnCompleteListener(
//        new OnCompleteListener<Location>() {
//          @Override
//          public void onComplete(@NonNull Task<Location> task) {
//
//          }
//        });
//  }

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {

    homeViewModel =
        ViewModelProviders.of(this).get(HomeViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, false);
    final TextView textView = root.findViewById(R.id.text_home);
    final MapView mapView = root.findViewById(R.id.map);
    homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mapView = view.findViewById(R.id.map);
    if (mapView != null) {
      mapView.onCreate(null);
      mapView.onResume();
      mapView.getMapAsync(this);
    }
  }

  @Override
  public void onResume() {
    super.onResume();
    mapView.onResume();
  }

  @Override
  public void onStart() {
    super.onStart();
    mapView.onStart();
  }

  @Override
  public void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    map = googleMap;
    map.setMyLocationEnabled(true);
    map.addMarker(new MarkerOptions().position(new LatLng(35.089550, -106.504158)).title("Marker"));
    map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(35.089550, -106.504158)));

//    map = googleMap;
//    map.setMyLocationEnabled(true);
//    map.addMarker(new MarkerOptions()
//        .position(new LatLng(35.089550, -106.504158))
//        .title("Marker"));

  }

  @Override
  public void onPause() {
    mapView.onPause();
    super.onPause();
  }

  @Override
  public void onDestroy() {
    mapView.onDestroy();
    super.onDestroy();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
  }
}