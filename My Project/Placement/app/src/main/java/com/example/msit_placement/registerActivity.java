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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class registerActivity extends AppCompatActivity {
    private Button createButton;
    private EditText inputname, inputphone, password;
    private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createButton = (Button) findViewById(R.id.register_btn);
        inputname = (EditText) findViewById(R.id.register_name);
        inputphone = (EditText) findViewById(R.id.register_phone);
        password = (EditText) findViewById(R.id.register_password);
        loadingbar = new ProgressDialog(this);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

    }
    private void createAccount() {
        String name = inputname.getText().toString();
        String phone = inputphone.getText().toString();
        String pass = password.getText().toString();
        if(TextUtils.isEmpty(name)) {
            Toast.makeText(this, "please enter name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "please enter phone number", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingbar.setTitle("Sign UP");
            loadingbar.setMessage("please wait, While we log in you");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();
            ValidateUser(name, phone, pass);
        }
    }
    private void ValidateUser(final String name, final String phone, final String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(phone).exists())) {
                    HashMap<String, Object> userHashmap = new HashMap<>();
                    userHashmap.put("name", name);
                    userHashmap.put("phone", phone);
                    userHashmap.put("password", password);
                    RootRef.child("Users").child(phone).updateChildren(userHashmap).
                            addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(registerActivity.this, "Your Account Has been created Successfully", Toast.LENGTH_SHORT).show();
                                        loadingbar.dismiss();
                                        Intent intent = new Intent(registerActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                    }
                                }
                            });


                }
                else {
                    Toast.makeText(registerActivity.this, "This" + phone+ "already exist", Toast.LENGTH_SHORT);
                    Toast.makeText(registerActivity.this,"please try again using another phone number.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(registerActivity.this, registerActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {


            }
        });


    }
}
