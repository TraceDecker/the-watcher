package edu.cnm.deepdive.thewatcher.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = AppEntity.class,
            parentColumns = "app_id",
            childColumns = "app_id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = LocationEntity.class,
            parentColumns = "location_id",
            childColumns = "location_id",
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = {
        @Index(value = "time_value"),
        @Index(value = "app_id"),
        @Index(value = "location_id")
    }
)
// Layout of PolicyEntity table.
public class PolicyEntity {

  @ColumnInfo(name = "policy_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "app_id")
  private long appId;

  @ColumnInfo(name = "location_id")
  private long locationId;

  @ColumnInfo(index = true)
  private boolean restricted;

  @ColumnInfo(name = "time_value")
  private long timeValue;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getAppId() {
    return appId;
  }

  public void setAppId(long appId) {
    this.appId = appId;
  }

  public long getLocationId() {
    return locationId;
  }

  public void setLocationId(long locationId) {
    this.locationId = locationId;
  }

  public boolean isRestricted() {
    return restricted;
  }

  public void setRestricted(boolean restricted) {
    this.restricted = restricted;
  }

  public long getTimeValue() {
    return timeValue;
  }

  public void setTimeValue(long timeValue) {
    this.timeValue = timeValue;
  }
}

