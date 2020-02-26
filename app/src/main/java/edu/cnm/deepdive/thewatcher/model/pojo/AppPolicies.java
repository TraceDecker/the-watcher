package edu.cnm.deepdive.thewatcher.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.thewatcher.model.entity.App;
import edu.cnm.deepdive.thewatcher.model.entity.Policy;
import java.util.List;

public class AppPolicies extends App {

  @Relation(entity = Policy.class, entityColumn = "app_id", parentColumn = "app_id")
  private List<Policy> policies;

  public List<Policy> getPolicies() {
    return policies;
  }

  public void setPolicies(List<Policy> policies) {
    this.policies = policies;
  }
}
