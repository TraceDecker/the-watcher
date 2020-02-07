package edu.cnm.deepdive.thewatcher.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.List;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Policy.class,
            parentColumns = "policy_id",
            childColumns = "policy_id",
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = {
        @Index(value = "location_name", unique = true),
    }
)
public class Location {

  @ColumnInfo(name = "location_id", collate = ColumnInfo.NOCASE)
  @PrimaryKey(autoGenerate = true)
  private String locationId;

  @ColumnInfo(name = "location_name", collate = ColumnInfo.NOCASE)
  private String locationName;

  @ColumnInfo(index = true)
  private double longitude;

  @ColumnInfo(index = true)
  private double latitude;

  @Ignore
  private List<Policy> policies;

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public List<Policy> getPolicies() {
    return policies;
  }

  public void setPolicies(List<Policy> policies) {
    this.policies = policies;
  }
}
