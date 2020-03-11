package edu.cnm.deepdive.thewatcher.controller.ui.pins;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.thewatcher.R;

public class PinsFragment extends Fragment {

  private PinsViewModel pinsViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    pinsViewModel =
        ViewModelProviders.of(this).get(PinsViewModel.class);
    View root = inflater.inflate(R.layout.fragment_pins, container, false);
    final TextView textView = root.findViewById(R.id.text_pins);
    pinsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}