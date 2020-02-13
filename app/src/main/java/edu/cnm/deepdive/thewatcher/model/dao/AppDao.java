package edu.cnm.deepdive.thewatcher.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import io.reactivex.Single;
import java.util.List;

@Dao
public interface AppDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(Policy policy);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(Location location);

  @Update
  Single<Integer> update(Policy policy);

  @Delete
  Single<Integer> delete(Policy... policies);

  @Query("SELECT * FROM App ORDER BY app_name")
  LiveData<List<App>> select();


}
