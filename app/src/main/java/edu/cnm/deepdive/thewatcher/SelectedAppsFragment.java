package edu.cnm.deepdive.thewatcher;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.thewatcher.view.SelectedAppRecyclerAdapter;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.view.SelectedAppRecyclerAdapter.OnAppListener;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;
import java.util.List;


public class SelectedAppsFragment extends Fragment implements OnClickListener,
    OnAppListener {

  private List<App> selectedApps;
  private  MainViewModel viewModel;
  private RecyclerView recyclerView;
  private App app;

  public SelectedAppsFragment() {
    // Required empty public constructor

  }

  public SelectedAppsFragment(List<App> selectedApps) {
    this.selectedApps = selectedApps;
    this.app = new App();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_selected_apps, container, false);
    recyclerView = view.findViewById(R.id.apps_selected);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    SelectedAppRecyclerAdapter adapter = new SelectedAppRecyclerAdapter(getContext(), selectedApps, this);
    recyclerView.setAdapter(adapter);
  }

  @Override
  public void onAppClick(int position) {
    app = selectedApps.get(position);
    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
    fragmentManager.beginTransaction()
        .add(R.id.fragment_container, new selectTimeFragment(app), null)
        .addToBackStack(selectTimeFragment.class.getName())
        .commit();
  }

  @Override
  public void onClick(View v) {

  }
}
