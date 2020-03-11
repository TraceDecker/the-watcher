package edu.cnm.deepdive.thewatcher.controller.ui.restrictions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestrctionsViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public RestrctionsViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is restrictions fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}