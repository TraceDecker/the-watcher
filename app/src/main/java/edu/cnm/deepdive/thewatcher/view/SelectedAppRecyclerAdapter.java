package edu.cnm.deepdive.thewatcher.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import edu.cnm.deepdive.thewatcher.view.SelectedAppRecyclerAdapter.Holder;
import java.util.List;

public class SelectedAppRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final PackageManager manager;
  private final List<AppEntity> selectedAppEntities;
  private final int[] durations;
  private int selectedItem;


  public SelectedAppRecyclerAdapter(Context context, List<AppEntity> selectedAppEntities) {
    this.context = context;
    this.selectedAppEntities = selectedAppEntities;
    selectedItem = -1;
    manager = context.getPackageManager();
    durations = new int[selectedAppEntities.size()];
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View root = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.selected_app_item, parent, false);
    return new Holder(root);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    try {
      holder.bind(position, selectedAppEntities.get(position));
    } catch (NameNotFoundException e) {
      Log.e(getClass().getName(), e.getMessage(), e);
    }
  }

  @Override
  public int getItemCount() {
    return selectedAppEntities.size();
  }

  private void setSelectedItem(int selectedItem) {
    this.selectedItem = selectedItem;
  }

  class Holder extends RecyclerView.ViewHolder implements TextWatcher {

    private final ImageView icon;
    private final TextView appName;
    private final TextView timeValue;
    private final View timeLayout;
    private boolean selected;


    private Holder(@NonNull View itemView) {
      super(itemView);
      icon = itemView.findViewById(R.id.icon);
      appName = itemView.findViewById(R.id.app_name_to_display);
      timeLayout = itemView.findViewById(R.id.time_layout);
      timeValue = itemView.findViewById(R.id.time_value);
      timeValue.addTextChangedListener(this);
    }

    private void bind(int position, AppEntity appEntity) throws NameNotFoundException {
      icon.setImageDrawable(manager.getApplicationIcon(appEntity.getAppPackage()));
      appName.setText(appName.getText());
      timeValue.setText(Integer.toString(durations[position]));
      setSelected(position == selectedItem);
      itemView.setOnClickListener((v) -> {
        if (!selected) {
          setSelected(true);
          int deselected = selectedItem;
          selectedItem = getAdapterPosition();
          notifyItemChanged(deselected);
        }
//        onAppListener.onAppClick(getAdapterPosition());
      });
    }

    private void setSelected(boolean selected) {
      this.selected = selected;
      timeLayout.setVisibility(selected ? View.VISIBLE : View.GONE);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
      String entry = timeValue.getText().toString().trim();
      durations[getAdapterPosition()] = (!entry.isEmpty()) ? Integer.parseInt(entry) : 0;

    }

  }

  public int[] getDurations() {
    return durations;
  }

}

