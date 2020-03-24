package edu.cnm.deepdive.thewatcher.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import java.util.List;

public class PackAdapter extends BaseAdapter {

  private final List<AppEntity> appEntities;
  private final Context context;
  private PackageManager manager;

  public PackAdapter(List<AppEntity> appEntities, Context context) {
    this.appEntities = appEntities;
    this.context = context;
    manager = context.getPackageManager();
  }

  @Override
  public int getCount() {
    return appEntities.size();
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ApplicationInfo applicationInfo = null;
    final AppEntity appEntity = appEntities.get(position);
    if (convertView == null) {
      final LayoutInflater layoutInflater = LayoutInflater.from(context);
      convertView = layoutInflater.inflate(R.layout.app_item, null);
    }
    final ImageView imageView =
        convertView.findViewById(R.id.icon);

    final TextView textView =
        convertView.findViewById(R.id.app_name_to_display);

    try {
      imageView.setImageDrawable(manager.getApplicationIcon(appEntity.getAppPackage()));
    } catch (NameNotFoundException e) {
      e.printStackTrace();
    }
//    textView.setText(appEntity.getAppName());

    return convertView;
  }
}
