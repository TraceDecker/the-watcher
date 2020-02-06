package edu.cnm.deepdive.thewatcher.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = App.class,
            parentColumns = "app_id",
            childColumns = "app_id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = Location.class,
            parentColumns = "location_id",
            childColumns = "location_id",
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = {
        @Index(value = "time_value", unique = true)
    }
)
public class Policy {

  @ColumnInfo(name = "policy_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "location_id")
  private long locationId;

  @ColumnInfo(index = true)
  private boolean restrictions;

  @ColumnInfo(name = "time_value")
  private long timeValue;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getLocationId() {
    return locationId;
  }

  public void setLocationId(long locationId) {
    this.locationId = locationId;
  }

  public boolean isRestrictions() {
    return restrictions;
  }

  public void setRestrictions(boolean restrictions) {
    this.restrictions = restrictions;
  }

  public long getTimeValue() {
    return timeValue;
  }

  public void setTimeValue(long timeValue) {
    this.timeValue = timeValue;
  }
}
