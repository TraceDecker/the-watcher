package edu.cnm.deepdive.thewatcher.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface PolicyDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<Policy> policies);

  @Update
  Single<Integer> update(Policy policy);

  @Delete
  Single<Integer> delete(Policy... policies);

  @Query("SELECT * FROM Policy ORDER BY time_value")
  LiveData<List<Policy>> select();

  @Query("SELECT * FROM Policy WHERE app_id = :appId AND location_id = :locationId")
  LiveData<List<Policy>> selectByAppAndLocation(long appId, long locationId);

  @Query("SELECT * FROM Policy WHERE app_id = :appId")
  LiveData<List<Policy>> selectByApp(long appId);

  @Query("SELECT * FROM Policy WHERE location_id = :locationId")
  LiveData<List<Policy>> selectByLocation(long locationId);
}
