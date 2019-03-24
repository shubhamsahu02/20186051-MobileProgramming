package com.example.msit_placement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.msit_placement.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginActivity extends AppCompatActivity {
    private EditText inputNumber, inputPassword;
    private Button loginButton;
    private ProgressDialog loadingbar;
    String parentDbName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.login_btn);
        inputNumber = (EditText) findViewById(R.id.login_phone);
        inputPassword = (EditText) findViewById(R.id.login_password);
        loadingbar = new ProgressDialog(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


    }
    private void loginUser() {
        String phone = inputNumber.getText().toString();
        String pass = inputPassword.getText().toString();

         if(TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "please enter phone number", Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingbar.setTitle("Login Account");
            loadingbar.setMessage("please wait, While we log in you");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            loginAccount(phone, pass);
        }
    }
    private void loginAccount(final String phone, final String password) {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(parentDbName).child(phone).exists()) {
                    Users userData = dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);
                    if (userData.getPhone().equals(phone)) {
                        if (userData.getPassword().equals(password)) {
                            Toast.makeText(loginActivity.this, "You have Logged in Successfully", Toast.LENGTH_SHORT).show();
                            loadingbar.dismiss();

                            Intent intent = new Intent(loginActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(loginActivity.this, "Please give Correct Password", Toast.LENGTH_SHORT).show();
                            loadingbar.dismiss();

                        }
                    }
                }
                else {
                    Toast.makeText(loginActivity.this, "There is no account with this "+phone+" number", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
