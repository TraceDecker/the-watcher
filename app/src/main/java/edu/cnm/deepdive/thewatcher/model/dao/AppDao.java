package edu.cnm.deepdive.thewatcher.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import edu.cnm.deepdive.thewatcher.model.pojo.AppEntityPolicies;
import io.reactivex.Single;
import java.util.List;

@Dao
public interface AppDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(AppEntity appEntity);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(List<AppEntity> appsList);

  @Delete
  Single<Integer> delete(AppEntity... appEntities);

  @Query("SELECT * FROM AppEntity")
  LiveData<List<AppEntity>> select();

  @Transaction
  @Query("SELECT * FROM AppEntity ORDER BY app_name")
  LiveData<List<AppEntityPolicies>> selectWithPolicies();

  @Query("SELECT * FROM AppEntity WHERE app_id = :appId")
  LiveData<AppEntity> selectSingleByApp(long appId);

}
