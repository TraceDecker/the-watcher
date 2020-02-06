package edu.cnm.deepdive.thewatcher.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
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

  public String getLocationId() {
    return locationId;
  }

  public void setLocationId(String locationId) {
    this.locationId = locationId;
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
}
