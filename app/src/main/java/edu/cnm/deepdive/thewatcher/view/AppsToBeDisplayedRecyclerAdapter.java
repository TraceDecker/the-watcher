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
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.view.AppsToBeDisplayedRecyclerAdapter.Holder;
import java.util.List;

public class AppsToBeDisplayedRecyclerAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final List<App> appsToBeDisplayed;
  private final PackageManager manager;

  public AppsToBeDisplayedRecyclerAdapter(Context context, List<App> appsToBeDisplayed) {
    this.context = context;
    this.appsToBeDisplayed = appsToBeDisplayed;
    this.manager = context.getPackageManager();
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.apps_for_pin_item, parent, false);
    return new Holder(root);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    try {
      holder.bind(position, appsToBeDisplayed.get(position));
    } catch (NameNotFoundException e) {
      Log.e(getClass().getName(), e.getMessage(), e);
    }
  }

  @Override
  public int getItemCount() {
    return appsToBeDisplayed.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final ImageView icon;
    private final TextView appName;
    private final TextView timeValue;
    private final View displayedAppsLayout;

    public Holder(@NonNull View itemView) {
      super(itemView);
      icon = itemView.findViewById(R.id.icon_to_display);
      appName = itemView.findViewById(R.id.app_name_to_display);
      timeValue = itemView.findViewById(R.id.time_value_display);
      displayedAppsLayout = itemView.findViewById(R.id.app_restrictions_at_pin);
    }

    public void bind(int position, App app) throws NameNotFoundException {
      icon.setImageDrawable(manager.getApplicationIcon(app.getAppPackage()));
      appName.setText(appName.getText());
      timeValue.setText(timeValue.getText());
    }
  }
}
