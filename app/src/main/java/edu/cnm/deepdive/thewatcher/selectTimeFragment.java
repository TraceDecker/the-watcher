package edu.cnm.deepdive.thewatcher;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.selectTimeFragment.OnFragmentInteractionListener;


/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link selectTimeFragment.OnFragmentInteractionListener} interface to handle interaction events.
 */
public class selectTimeFragment extends Fragment implements OnClickListener {

  private static final String TAG = "";
  private OnFragmentInteractionListener mListener;
  private App app;
  private View view;
  private long restriction;
  Button button;
  EditText timeValue;

  public selectTimeFragment() {
    // Required empty public constructor
  }

  public selectTimeFragment(App app) {
    this.app = app;
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_select_time, container, false);
    timeValue = view.findViewById(R.id.time_value);
    button = view.findViewById(R.id.set_restriction_button);
    button.setOnClickListener(this);
    return view;
  }

  @Override
  public void onClick(View view) throws NumberFormatException{
// attempting to hide selectTimeFragment.
    try {
      restriction = Long.parseLong(timeValue.getText().toString().trim());
    } catch (NumberFormatException e) {
      Log.d(TAG, "onClick: No input");
    }
    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
    fragmentManager.beginTransaction()
        .hide(fragmentManager.findFragmentById(R.id.set_restriction_fragment));
  }

  /**
   * This interface must be implemented by activities that contain this fragment to allow an
   * interaction in this fragment to be communicated to the activity and potentially other fragments
   * contained in that activity.
   * <p>
   * See the Android Training lesson <a href= "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {

    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }
}
