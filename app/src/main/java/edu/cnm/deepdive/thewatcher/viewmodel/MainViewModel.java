package edu.cnm.deepdive.thewatcher.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import edu.cnm.deepdive.thewatcher.model.repository.AppRepository;
import edu.cnm.deepdive.thewatcher.model.repository.LocationRepository;
import edu.cnm.deepdive.thewatcher.model.repository.PolicyRepository;
import java.util.List;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<List<App>> apps;
  private final MutableLiveData<List<Policy>> policies;
  private final MutableLiveData<List<Location>> locations;
  private final AppRepository appRepository;
  private final PolicyRepository policyRepository;
  private final LocationRepository locationRepository;

  public MainViewModel(@NonNull Application application) {
    super(application);
    appRepository = AppRepository.getInstance();
    apps = new MutableLiveData<>();
    policyRepository = PolicyRepository.getInstance();
    policies = new MutableLiveData<>();
    locationRepository = LocationRepository.getInstance();
    locations = new MutableLiveData<>();
  }

  public MutableLiveData<List<App>> getApps() {
    return apps;
  }

  public MutableLiveData<List<Policy>> getPolicies() {
    return policies;
  }

  public MutableLiveData<List<Location>> getLocations() {
    return locations;
  }
}
