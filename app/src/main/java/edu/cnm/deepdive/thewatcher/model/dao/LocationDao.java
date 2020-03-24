package edu.cnm.deepdive.thewatcher.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.thewatcher.model.entity.LocationEntity;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface LocationDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<LocationEntity> locationEntity);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(LocationEntity locationEntity);

  @Update
  Single<Integer> update(LocationEntity locationEntity);

  @Delete
  Single<Integer> delete(LocationEntity... locationEntities);

  @Query("SELECT * FROM LocationEntity ORDER BY location_name")
  LiveData<List<LocationEntity>> select();

  @Query("SELECT * FROM LocationEntity WHERE location_id = :locationId")
  LiveData<LocationEntity> getLocationById(long locationId);

  @Query("SELECT * FROM LocationEntity WHERE latitude = :latitude AND longitude = :longitude")
  LiveData<LocationEntity> getLocationByLatLong(double latitude, double longitude);

}
