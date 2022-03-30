package com.example.betav2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText pass_ET, email_ET,name,age,wei,hei,loc;
    Spinner gender,level;
    String e, pass,name_use,age_use,weight_use,height_use,location_use,exelevel,gender_use;
    FirebaseAuth fAuth;
    String[] ExerciseLevel= {"","1","2","3","4","5"};
    String[] Gnder= {"","female","male","ather"};
    public String useID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pass_ET = findViewById(R.id.TextPassword);
        email_ET = findViewById(R.id.TextEmail);
        fAuth = FirebaseAuth.getInstance();
        gender = findViewById(R.id.gender);
        level = findViewById(R.id.ExerciseLevel);
        name=findViewById(R.id.Name);
        age =findViewById(R.id.age);
        wei =findViewById(R.id.weigh);
        hei = findViewById(R.id.height);
        loc = findViewById(R.id.location);


        level.setOnItemSelectedListener(this);
        ArrayAdapter<String> lv = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, ExerciseLevel);
        level.setAdapter(lv);

        gender.setOnItemSelectedListener(this);
        ArrayAdapter<String> ge = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,Gnder);
        gender.setAdapter(ge);

    }

    public void loogin(View view) {


        e = email_ET.getText().toString();
        pass = pass_ET.getText().toString();

        name_use=name.getText().toString();
        age_use=age.getText().toString();
        weight_use=wei.getText().toString();
        height_use=hei.getText().toString();
        location_use=loc.getText().toString();


        if (TextUtils.isEmpty(height_use)) {
            email_ET.setError("height Is Required.");
        }
        if (TextUtils.isEmpty(weight_use)) {
            email_ET.setError("weight Is Required.");
        }
        if (TextUtils.isEmpty(age_use)) {
            email_ET.setError("age Is Required.");
        }
        if (TextUtils.isEmpty(name_use)) {
            email_ET.setError("name Is Required.");
        }
        if (TextUtils.isEmpty(location_use)) {
            email_ET.setError("location Is Required.");
        }
        if (TextUtils.isEmpty(e)) {
            email_ET.setError("Email Is Required.");
        }

        if (TextUtils.isEmpty(pass)) {
            pass_ET.setError("Password Is Required.");
        } else {
            if (pass.length() < 8) {
                pass_ET.setError("Password must be longer than 8 digits.");
            } else {
                fAuth.createUserWithEmailAndPassword(e, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser currentUser = fAuth.getCurrentUser();
                            useID= currentUser.getUid();
                            weighing w=new weighing(Float.parseFloat(weight_use));
                           User new_use = new User(name_use,Integer.parseInt(gender_use),w,Integer.parseInt(height_use),Integer.parseInt(exelevel),location_use,Integer.parseInt(age_use));

                            Toast.makeText(Login.this, "hello new user", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

        Intent si = new Intent(this, Profile.class);
        startActivity(si);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}