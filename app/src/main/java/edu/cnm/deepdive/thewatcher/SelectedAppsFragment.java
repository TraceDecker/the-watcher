package edu.cnm.deepdive.thewatcher;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Adapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;
import java.util.List;


public class SelectedAppsFragment extends Fragment {

  private List<App> selectedApps;
  private MainViewModel viewModel;

  public SelectedAppsFragment() {
    // Required empty public constructor
  }

  public SelectedAppsFragment(List<App> selectedApps) {
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_selected_apps, container, false);
    selectedApps = view.findViewById(R.id.apps_selected);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    viewModel.getApps().observe(getViewLifecycleOwner(), (app) -> {
      SelectedAppsAdapter adapter = new SelectedAppsAdapter(getContext(), app);
      // Im not sure why this line doesnt work.
      // selectedApps.setAdapter(adapter);
    });
  }
}
