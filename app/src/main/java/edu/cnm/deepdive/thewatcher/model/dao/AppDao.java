package edu.cnm.deepdive.thewatcher.model.dao;

import android.provider.LiveFolders;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Location;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import edu.cnm.deepdive.thewatcher.model.pojo.AppPolicies;
import io.reactivex.Single;
import java.util.List;

@Dao
public interface AppDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  long insert(App app);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(List<App> appsList);

  @Delete
  Single<Integer> delete(App... apps);

  @Query("SELECT * FROM App")
  LiveData<List<App>> select();

  @Transaction
  @Query("SELECT * FROM App ORDER BY app_name")
  LiveData<List<AppPolicies>> selectWithPolicies();

  @Query("SELECT * FROM App WHERE app_id = :appId")
  LiveData<App> selectSingleByApp(long appId);

}
