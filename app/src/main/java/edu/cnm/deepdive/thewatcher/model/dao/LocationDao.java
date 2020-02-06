package edu.cnm.deepdive.thewatcher.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface LocationDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Location> location);

  @Update
  Single<Integer> update(Location location);

  @Delete
  Single<Integer> delete(Location... locations);

  @Query("SELECT * FROM Location ORDER BY location_name")
  LiveData<List<Location>> select();


}
