package edu.cnm.deepdive.thewatcher.controller.ui.pins;

import android.Manifest;
import android.Manifest.permission;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;
import java.util.List;

public class PinsFragment extends Fragment implements OnMapReadyCallback {

  private MainViewModel mainViewModel;
  private MapView mapView;
  private GoogleMap pinsMap;

  private static final String[] INITIAL_PERMS = {
      Manifest.permission.ACCESS_FINE_LOCATION,
      permission.READ_EXTERNAL_STORAGE
  };

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestPermissions(INITIAL_PERMS, 0);
  }

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    mainViewModel =
        ViewModelProviders.of(this).get(MainViewModel.class);
    View root = inflater.inflate(R.layout.fragment_pins, container, false);
    final TextView textView = root.findViewById(R.id.text_pins);
    final MapView mapView = root.findViewById(R.id.pins_map);
    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mapView = view.findViewById(R.id.pins_map);
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
  public void onPause() {
    super.onPause();
    mapView.onPause();
  }

  @Override
  public void onStop() {
    super.onStop();
    mapView.onStop();
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    pinsMap = googleMap;
    if (ContextCompat.checkSelfPermission(getContext(),
        permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      requestPermissions(INITIAL_PERMS, 0);
    } else {
      pinsMap.setMyLocationEnabled(true);
    }
    addPins();

//    pinsMap.addMarker(new MarkerOptions()
//        .position(new LatLng(35.089550, -106.504158)).title("Marker"));
//    pinsMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(35.089550, -106.504158)));
  }

  private void addPins() {
    List<Location> locs = mainViewModel.getLocations().getValue();

    if (locs != null) {
      for (Location loc: locs) {
        pinsMap.addMarker(new MarkerOptions()
            .position(new LatLng(loc.getLatitude(), loc.getLongitude()))
            .title(loc.getLocationName()));
      }
    }
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