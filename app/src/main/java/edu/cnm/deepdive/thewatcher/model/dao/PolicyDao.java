package edu.cnm.deepdive.thewatcher.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.thewatcher.model.entity.PolicyEntity;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface PolicyDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<List<Long>> insert(Collection<PolicyEntity> policies);

  @Update
  Single<Integer> update(PolicyEntity policyEntity);

  @Delete
  Single<Integer> delete(PolicyEntity... policies);

  @Query("SELECT * FROM PolicyEntity ORDER BY time_value")
  LiveData<List<PolicyEntity>> select();

  @Query("SELECT * FROM PolicyEntity WHERE app_id = :appId AND location_id = :locationId")
  LiveData<List<PolicyEntity>> selectByAppAndLocation(long appId, long locationId);

  @Query("SELECT * FROM PolicyEntity WHERE app_id = :appId")
  LiveData<List<PolicyEntity>> selectByApp(long appId);

  @Query("SELECT * FROM PolicyEntity WHERE location_id = :locationId")
  LiveData<List<PolicyEntity>> selectByLocation(long locationId);
}
