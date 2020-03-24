package edu.cnm.deepdive.thewatcher.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import edu.cnm.deepdive.thewatcher.model.entity.LocationEntity;
import edu.cnm.deepdive.thewatcher.model.entity.PolicyEntity;
import edu.cnm.deepdive.thewatcher.model.repository.AppRepository;
import edu.cnm.deepdive.thewatcher.model.repository.LocationRepository;
import edu.cnm.deepdive.thewatcher.model.repository.PolicyRepository;

import edu.cnm.deepdive.thewatcher.services.LocationProviderSerivce;
import java.util.List;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<List<AppEntity>> apps;
  private final MutableLiveData<List<PolicyEntity>> policies;
  private final MutableLiveData<List<LocationEntity>> locations;
  private final AppRepository appRepository;
  private final PolicyRepository policyRepository;
  private final LocationRepository locationRepository;
  private List<PolicyEntity> newPolicies;
  private List<LocationEntity> newLocationEntities;
  private LocationEntity newLocationEntity;
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

  public LiveData<List<AppEntity>> getApps() {
    return appRepository.getAllApps();
  }

  public LiveData<List<PolicyEntity>> getPolicies() {
    return policyRepository.getPolicyByValue();
  }

  public LiveData<List<LocationEntity>> getLocations() {
    return locationRepository.getAllLocations();
  }

  public LiveData<LocationEntity> getLocationByLatLong(double latitude, double longitude) {
    return locationRepository.getLocationByLatLong(latitude, longitude);
  }

  public android.location.Location getCurrentDeviceLocation() {

    return locationProviderSerivce.getLocation();
  }

  public LiveData<List<PolicyEntity>> getPoliciesByLocationId(long locationId) {
    return policyRepository.getPoliciesByLocation(locationId);
  }

  public LiveData<AppEntity> getAppByPolicy(PolicyEntity policyEntity) {
    return policyRepository.getAppByPolicy(policyEntity);
  }

  public void savePoliciesAndLocations(List<PolicyEntity> newPolicies, android.location.Location newLocation) {
    this.newPolicies = newPolicies;
    InsertPolicyAndLocationTask task = new InsertPolicyAndLocationTask();
    task.execute();
  }

  public class InsertPolicyAndLocationTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected Void doInBackground(Void... voids) {


      locationRepository.insertLocations(newLocationEntities);
      policyRepository.insertPolicies(newPolicies);
      return null;
    }
  }
}
