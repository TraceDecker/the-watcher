package edu.cnm.deepdive.thewatcher.controller.ui.pins;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PinsViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public PinsViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is pins fragment");
  }

  public LiveData<String> getText() {
    return mText;
  }
}