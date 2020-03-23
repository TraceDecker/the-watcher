package edu.cnm.deepdive.thewatcher.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
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

import edu.cnm.deepdive.thewatcher.services.LocationProviderSerivce;
import io.reactivex.Single;
import java.util.List;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<List<App>> apps;
  private final MutableLiveData<List<Policy>> policies;
  private final MutableLiveData<List<Location>> locations;
  private final AppRepository appRepository;
  private final PolicyRepository policyRepository;
  private final LocationRepository locationRepository;
  private List<Policy> newPolicies;
  private List<Location> newLocations;
  private Location newLocation;
  private LocationProviderSerivce locationProviderSerivce;

  public MainViewModel(@NonNull Application application) {
    super(application);
    appRepository = AppRepository.getInstance();
    apps = new MutableLiveData<>();
    policyRepository = PolicyRepository.getInstance();
    policies = new MutableLiveData<>();
    locationRepository = LocationRepository.getInstance();
    locations = new MutableLiveData<>();

    locationProviderSerivce = new LocationProviderSerivce(getApplication());
  }

  public LiveData<List<App>> getApps() {
    return appRepository.getAllApps();
  }

  public LiveData<List<Policy>> getPolicies() {
    return policyRepository.getPolicyByValue();
  }

  public LiveData<List<Location>> getLocations() {
    return locationRepository.getAllLocations();
  }

  public Single<Location> getLocationByLatLong(double latitude, double longitude) {
    return locationRepository.getLocationByLatLong(latitude, longitude);
  }

  public android.location.Location getCurrentDeviceLocation() {

    return locationProviderSerivce.getLocation();
  }

  public class InsertPolicyAndLocationTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {


      locationRepository.insertLocations(newLocations);
      policyRepository.insertPolicies(newPolicies);
      return null;
    }
  }
}
