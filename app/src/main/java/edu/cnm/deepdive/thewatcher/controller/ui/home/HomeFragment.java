package edu.cnm.deepdive.thewatcher.controller.ui.home;

import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.view.AppsToBeDisplayedRecyclerAdapter;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

  private MainViewModel mainViewModel;
  private MapView mapView;
  private static GoogleMap googleMap;
  private RecyclerView recyclerView;

  private static final String[] INITIAL_PERMS = {
      Manifest.permission.ACCESS_FINE_LOCATION,
  };

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    requestPermissions(INITIAL_PERMS, 0);
  }

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {

    mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    View root = inflater.inflate(R.layout.fragment_home, container, false);
    final TextView textView = root.findViewById(R.id.text_home);
    final MapView mapView = root.findViewById(R.id.map);
    final RecyclerView recyclerView = root.findViewById(R.id.app_restrictions_at_pin);
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

    if (recyclerView == null) {
      LinearLayoutManager manager = new LinearLayoutManager(getContext());
      recyclerView.setLayoutManager(manager);
      recyclerView.setHasFixedSize(true);
//      AppsToBeDisplayedRecyclerAdapter adapter = new AppsToBeDisplayedRecyclerAdapter()
//      recyclerView.setAdapter(adapter);
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
    this.googleMap = googleMap;

    if (ContextCompat.checkSelfPermission(getContext(),
        permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      requestPermissions(INITIAL_PERMS, 1);
    } else {
      this.googleMap.setMyLocationEnabled(true);
    }

//    map.setMyLocationEnabled(true);
//    map.addMarker(new MarkerOptions().position(new LatLng(35.089550, -106.504158)).title("Marker"));
//    map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(35.089550, -106.504158)));

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
// test data attempting to add pin
  public static void locationHelper() {
    googleMap.addMarker(new MarkerOptions().position(new LatLng(4892, 7654)).title("Test Pin"));
    googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(4892, 7654)));
  }

}