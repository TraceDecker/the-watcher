package edu.cnm.deepdive.thewatcher;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import edu.cnm.deepdive.thewatcher.controller.ui.home.HomeFragment;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.model.repository.LocationRepository;
import edu.cnm.deepdive.thewatcher.services.TheWatcherDatabase;
import edu.cnm.deepdive.thewatcher.view.PackAdapter;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AppSelectFragment extends Fragment implements OnItemClickListener, OnClickListener {

  private MainViewModel mainViewModel;
  private GridView gridView;
  private PackAdapter packAdapter;
  private List<App> selectedApps;
  private List<App> allApps;
  private LocationRepository locationRepository;
  private Location newLocation;

  public AppSelectFragment() {
    selectedApps = new ArrayList<>();
    locationRepository = LocationRepository.getInstance();
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_app_select, container, false);
    gridView = view.findViewById(R.id.grid_view_apps);
    gridView.setOnItemClickListener(this);
    Button button = view.findViewById(R.id.next_button);
    button.setOnClickListener(this);
    return view;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
      mainViewModel.getApps().observe(getViewLifecycleOwner(), (Apps) -> {
        PackAdapter packAdapter = new PackAdapter(Apps, getContext());
      gridView.setAdapter(packAdapter);
      allApps = Apps;
    });

  }


  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    selectedApps.add(allApps.get(position));
    view.setBackgroundColor(Color.LTGRAY);
  }


  @Override
  public void onClick(View view) {
    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
    fragmentManager.beginTransaction()
        .add(R.id.fragment_container, new SelectedAppsFragment(selectedApps), null)
        .addToBackStack(AppSelectFragment.class.getName())
        .commit();
  }

}
