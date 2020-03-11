package edu.cnm.deepdive.thewatcher.controller.ui.restrictions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.thewatcher.R;

public class RestrictionsFragment extends Fragment {

  private RestrctionsViewModel restrctionsViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    restrctionsViewModel =
        ViewModelProviders.of(this).get(RestrctionsViewModel.class);
    View root = inflater.inflate(R.layout.fragment_restrictions, container, false);
    final TextView textView = root.findViewById(R.id.text_restrictions);
    restrctionsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}