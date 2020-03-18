package edu.cnm.deepdive.thewatcher.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.media.Image;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.model.SelectedAppRecyclerAdapter.Holder;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import java.util.List;

public class SelectedAppRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final PackageManager manager;
  private final List<App> selectedApps;

  public SelectedAppRecyclerAdapter(Context context, List<App> selectedApps) {
    this.context = context;
    this.selectedApps = selectedApps;


    manager = context.getPackageManager();
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(LayoutInflater.from(context).inflate(R.layout.app_item, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position, selectedApps.get(position), manager);
  }

  @Override
  public int getItemCount() {
    return selectedApps.size();
  }

  static class Holder extends RecyclerView.ViewHolder {

    private final ImageView icon;
    private final TextView appName;

    private Holder(@NonNull View itemView) {
      super(itemView);
      icon = itemView.findViewById(R.id.icon);
      appName = itemView.findViewById(R.id.app_name);
    }

    private void bind(int position, App app, PackageManager manager) {
      appName.setText(app.getAppName());
      icon.setContentDescription(app.getAppPackage());
      try {
        icon.setImageDrawable(manager.getApplicationIcon(app.getAppPackage()));
      } catch (NameNotFoundException e) {
        icon.setImageResource(R.drawable.ic_launcher_foreground);
      }
    }
  }



}

