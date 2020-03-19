package edu.cnm.deepdive.thewatcher;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import java.util.List;


public class SelectedAppsFragment extends Fragment {

  public SelectedAppsFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_selected_apps, container, false);
  }


}
