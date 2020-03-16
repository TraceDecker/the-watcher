package edu.cnm.deepdive.thewatcher.controller.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.viewmodel.MainViewModel;

public class ToolsFragment extends Fragment {

  private MainViewModel mainViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    mainViewModel =
        ViewModelProviders.of(this).get(MainViewModel.class);
    View root = inflater.inflate(R.layout.fragment_tools, container, false);
    final TextView textView = root.findViewById(R.id.text_tools);

    return root;
  }
}