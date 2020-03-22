package edu.cnm.deepdive.thewatcher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.thewatcher.model.dao.AppDao;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.view.SelectedAppRecyclerAdapter;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;
import java.util.List;


public class SelectedAppsFragment extends Fragment implements OnClickListener {

  private List<App> selectedApps;
  private  MainViewModel viewModel;
  private RecyclerView recyclerView;
  private SelectedAppRecyclerAdapter adapter;
  private Button button;

  public SelectedAppsFragment() {
    // Required empty public constructor

  }

  public SelectedAppsFragment(List<App> selectedApps) {
    this.selectedApps = selectedApps;
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_selected_apps, container, false);
    recyclerView = view.findViewById(R.id.apps_selected);
    button = view.findViewById(R.id.apps_selected_done);
    button.setOnClickListener(this);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    adapter = new SelectedAppRecyclerAdapter(getContext(), selectedApps);
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onClick(View v) {
    int[] durations = adapter.getDurations();

    for (int i = 0; i < selectedApps.size(); i++) {
      App appToBeInserted = selectedApps.get(i);
      int time = durations[i];

    }
  }

}
