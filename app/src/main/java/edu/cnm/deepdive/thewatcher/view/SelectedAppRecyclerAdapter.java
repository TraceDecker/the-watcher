package edu.cnm.deepdive.thewatcher.view;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.view.SelectedAppRecyclerAdapter.Holder;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectedAppRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final PackageManager manager;
  private final List<App> selectedApps;
  private OnAppListener onAppListener;
  private final Map<Integer, Class<? extends ViewHolder>> holders;


  public SelectedAppRecyclerAdapter(Context context, List<App> selectedApps, OnAppListener onAppListener) {
    this.context = context;
    this.selectedApps = selectedApps;
    this.onAppListener = onAppListener;
    holders = new HashMap<>();
    manager = context.getPackageManager();
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item, parent, false);
      return new Holder(root, onAppListener);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    try {
      holder.bind(0, selectedApps.get(position), manager);
    } catch (NameNotFoundException e) {
      Log.e(getClass().getName(), e.getMessage(), e);
    }
  }

  @Override
  public int getItemCount() {
    return selectedApps.size();
  }

  static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final ImageView icon;
    public final TextView appName;
    OnAppListener onAppListener;


    private Holder(@NonNull View itemView, OnAppListener onAppListener) {
      super(itemView);
      icon = itemView.findViewById(R.id.icon);
      appName = itemView.findViewById(R.id.app_name);
      this.onAppListener = onAppListener;
      itemView.setOnClickListener(this);
    }

    private void bind(int position, App app, PackageManager manager) throws NameNotFoundException {
      icon.setImageDrawable(manager.getApplicationIcon(app.getAppPackage()));
     appName.setText(appName.getText());
    }

    @Override
    public void onClick(View v) {
      onAppListener.onAppClick(getAdapterPosition());
    }
  }

  public interface OnAppListener {
    void onAppClick(int position);
  }

}

