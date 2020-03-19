package edu.cnm.deepdive.thewatcher;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.cnm.deepdive.thewatcher.SelectedAppsAdapter.Holder;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import java.util.List;

public class SelectedAppsAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final List<App> selectedApps;
  private final PackageManager manager;


  public SelectedAppsAdapter(Context context, List<App> selectedApps) {
    this.context = context;
    this.selectedApps = selectedApps;
    this.manager = context.getPackageManager();
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.fragment_selected_apps, parent, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
     App selectedApp = selectedApps.get(position);
     holder.bind(position, selectedApp);
  }

  @Override
  public int getItemCount() {
    return selectedApps.size();
  }


  class Holder extends RecyclerView.ViewHolder {

    private final View view;
    private final ImageView icon;
    private final TextView appName;

    private Holder(@NonNull View view) {
      super(view);
      this.view = view;
      this.icon = view.findViewById(R.id.icons);
      this.appName = view.findViewById(R.id.app_name);
    }

    public void bind(int position, App selectedApp) {
      try {
        icon.setImageDrawable(manager.getApplicationIcon(selectedApp.getAppPackage()));
      } catch (NameNotFoundException e) {
        e.printStackTrace();
      }
      appName.setText(selectedApp.getAppName());
    }
  }
}
