package edu.cnm.deepdive.thewatcher;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import java.util.List;

public class PackAdapter extends BaseAdapter {

  private final List<App> apps;
  private final Context context;

  public PackAdapter(List<App> apps, Context context) {
    this.apps = apps;
    this.context = context;
  }

  @Override
  public int getCount() {
    return apps.size();
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
    final App app = apps.get(position);
    if (convertView == null) {
      final LayoutInflater layoutInflater = LayoutInflater.from(context);
      convertView = layoutInflater.inflate(R.layout.app_item, null);
    }
    final ImageView imageView =
        convertView.findViewById(R.id.icons);

    final TextView textView =
        convertView.findViewById(R.id.app_name);

    imageView.setImageDrawable(context.getDrawable(R.drawable.amu_bubble_mask));
    textView.setText(app.getAppName());
    return convertView;
  }
}
