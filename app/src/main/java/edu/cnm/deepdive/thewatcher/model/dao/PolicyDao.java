package edu.cnm.deepdive.thewatcher.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
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

  @Query("SELECT * FROM Policy ORDER BY restricted DESC")
  LiveData<List<Policy>> select();

}
