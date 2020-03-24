package edu.cnm.deepdive.thewatcher.controller;

import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import edu.cnm.deepdive.thewatcher.model.entity.PolicyEntity;
import edu.cnm.deepdive.thewatcher.services.LocationProviderSerivce;
import edu.cnm.deepdive.thewatcher.view.SelectedAppRecyclerAdapter;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;
import java.util.ArrayList;
import java.util.List;


public class SelectedAppsFragment extends Fragment implements OnClickListener {

  private List<AppEntity> selectedAppEntities;
  private  MainViewModel viewModel;
  private RecyclerView recyclerView;
  private SelectedAppRecyclerAdapter adapter;
  private Location mLocation;
  private Button button;

  public SelectedAppsFragment(List<AppEntity> selectedAppEntities) {
    this.selectedAppEntities = selectedAppEntities;
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_selected_apps, container, false);
    recyclerView = view.findViewById(R.id.apps_selected);
    button = view.findViewById(R.id.apps_selected_done);
    button.setOnClickListener(this);
    LocationProviderSerivce locationProviderSerivce = new LocationProviderSerivce(getActivity());
    mLocation = locationProviderSerivce.getLocation();
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    adapter = new SelectedAppRecyclerAdapter(getContext(), selectedAppEntities);
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onClick(View v) {

    List<AppEntity> appsToBeDisplayed = new ArrayList<>();
    List<PolicyEntity> newPolicies = new ArrayList<>();

    int[] durations = adapter.getDurations();
    for (int i = 0; i < selectedAppEntities.size(); i++) {
      AppEntity appEntityToBeInserted = selectedAppEntities.get(i);
      appsToBeDisplayed.addAll(selectedAppEntities);
      int time = durations[i];
      PolicyEntity policyEntity = new PolicyEntity();
      policyEntity.setTimeValue(time);
      policyEntity.setAppId(appEntityToBeInserted.getId());
      viewModel.savePoliciesAndLocations(newPolicies, mLocation);

      FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
      fragmentManager.popBackStack();
    }
  }

}
