package edu.cnm.deepdive.thewatcher.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.thewatcher.R;
import edu.cnm.deepdive.thewatcher.services.GoogleSignInRepository;

public class LoginActivity extends AppCompatActivity {

  private static final int LOGIN_REQUEST_CODE = 1000;

  private GoogleSignInRepository repository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    repository = GoogleSignInRepository.getInstance();
    repository.refresh()
        .addOnSuccessListener((account) -> switchToMain())
        .addOnFailureListener((ex) -> {
          setContentView(R.layout.activity_login);
          findViewById(R.id.sign_in).setOnClickListener((v) ->
              repository.startSignIn(this, LOGIN_REQUEST_CODE));
          Button button = findViewById(R.id.new_user);
          button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              setContentView(R.layout.activity_user_creation);
            }
          });
        });

  }



  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    if (requestCode == LOGIN_REQUEST_CODE) {
      repository.completeSignIn(data)
          .addOnSuccessListener((account) -> switchToMain())
          .addOnFailureListener((ex) ->
              Toast.makeText(this, R.string.login_failure, Toast.LENGTH_LONG).show());
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }

  private void switchToMain() {
    Intent intent = new Intent(this, MainActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }


}
