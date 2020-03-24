package edu.cnm.deepdive.thewatcher.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.thewatcher.model.entity.AppEntity;
import edu.cnm.deepdive.thewatcher.model.entity.PolicyEntity;
import java.util.List;

public class AppEntityPolicies extends AppEntity {

  @Relation(entity = PolicyEntity.class, entityColumn = "app_id", parentColumn = "app_id")
  private List<PolicyEntity> policies;

  public List<PolicyEntity> getPolicies() {
    return policies;
  }

  public void setPolicies(List<PolicyEntity> policies) {
    this.policies = policies;
  }
}
