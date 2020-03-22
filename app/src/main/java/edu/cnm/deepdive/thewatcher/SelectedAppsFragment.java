package edu.cnm.deepdive.thewatcher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.view.SelectedAppRecyclerAdapter;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;
import java.util.List;


public class SelectedAppsFragment extends Fragment {

  private List<App> selectedApps;
  private  MainViewModel viewModel;
  private RecyclerView recyclerView;
  private SelectedAppRecyclerAdapter adapter;

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
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    adapter = new SelectedAppRecyclerAdapter(getContext(), selectedApps);
    recyclerView.setAdapter(adapter);
  }

//  @Override
//  public void onAppClick(int position) {
//    app = selectedApps.get(position);
//    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//    fragmentManager.beginTransaction()
//        .add(R.id.fragment_container, new selectTimeFragment(app), null)
//        .addToBackStack(selectTimeFragment.class.getName())
//        .commit();
//  }
//
}
