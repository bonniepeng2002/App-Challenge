package com.bonniepeng.challenge;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

  private EditText name;
  private EditText email;
  private EditText password;
  private EditText password2;
  private Button register;
  private Button pickImage;
  private CheckBox agree;
  private ConstraintLayout parent;
  private Spinner continent;
  private String accContinent = null;
  private String accGender = "Other";
  private RadioGroup Gender;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    parent = findViewById(R.id.parent);
    name = findViewById(R.id.edtTxtName);
    email = findViewById(R.id.edtTxtEmail);
    password = findViewById(R.id.edtTxtPass);
    password2 = findViewById(R.id.edtTxtPass2);
    register = findViewById(R.id.btnRegister);
    pickImage = findViewById(R.id.btnImage);
    agree = findViewById(R.id.cbAgree);
    Gender = findViewById(R.id.rgGender);
    continent = findViewById(R.id.continent);

    // IMAGE PICKER
    pickImage.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Feature coming soon.", Toast.LENGTH_SHORT).show();
          }
        });

    // GENDER
    Gender.setOnCheckedChangeListener(
        new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
              case R.id.rbFemale:
                accGender = "Female";
                break;
              case R.id.rbMale:
                accGender = "Male";
                break;
              default:
                accGender = "Other";
                break;
            }
          }
        });

    // CONTINENT

    continent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            accContinent = continent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });

    // REGISTER
    register.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            if (agree.isChecked()) {
              if (password.getText().toString().equals(password2.getText().toString()) &&
                      !password.getText().toString().equals("") &&
                      !password2.getText().toString().equals("") ){
                if (!name.getText().toString().equals("") && !email.getText().toString().equals("")) {
                  Account newAccount =
                      new Account(
                          name.getText().toString(),
                          email.getText().toString(),
                          password.getText().toString(),
                          accGender,
                          accContinent);
                  Snackbar.make(
                          parent,
                          "Registered! Nice to meet you: "
                              + newAccount.getName()
                              + ", "
                              + newAccount.getEmail()
                              + ", "
                              + newAccount.getGender()
                              + ", "
                              + newAccount.getCountry()
                              + ", "
                              + newAccount.getPassword(),
                          Snackbar.LENGTH_INDEFINITE)
                      .setAction(
                          "Dismiss",
                          new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {}
                          })
                      .show();

                } else {
                  Toast.makeText(
                          MainActivity.this, "Please fill out all fields.", Toast.LENGTH_SHORT)
                      .show();
                }

              } else {
                Toast.makeText(
                        MainActivity.this, "Please make your passwords match.", Toast.LENGTH_SHORT)
                    .show();
              }

            } else {
              Toast.makeText(
                      MainActivity.this,
                      "Please read and agree with the license agreement.",
                      Toast.LENGTH_SHORT)
                  .show();
            }
          }
        });
  }
}
