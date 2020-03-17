package edu.cnm.deepdive.thewatcher;

import android.os.Bundle;
import android.widget.GridView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;


public class AppSelectFragment extends Fragment {

  private MainViewModel mainViewModel;
  private GridView gridView;
  private PackAdapter packAdapter;

  public AppSelectFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_app_select, container, false);
    gridView = view.findViewById(R.id.grid_view_apps);

    return view;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

    mainViewModel.getApps().observe(getViewLifecycleOwner(), (App) -> {
      PackAdapter packAdapter = new PackAdapter(App, getContext());
      gridView.setAdapter(packAdapter);
    });




  }
}
