package com.example.betav2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Singin extends AppCompatActivity {
    EditText et_mail, et_password ,location,age,weigh,height;
    String emailS, passwordS,loc,ge,weig,heig;
    FirebaseAuth mAuth;
    ProgressBar progressBar_ma;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        et_mail =  findViewById(R.id.email);
        et_password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        location=findViewById(R.id.location);
        age=findViewById(R.id.age);
        weigh=findViewById(R.id.weigh);
        height=findViewById(R.id.height);

        progressBar_ma = (ProgressBar) findViewById(R.id.progress);
        progressBar_ma.setVisibility(View.INVISIBLE);

        /*
        SharedPreferences settings = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        Boolean isChecked = settings.getBoolean("stayConnect", false);
        Intent si = new Intent(SignIn.this, Main.class);
        if (mAuth.getCurrentUser() != null && isChecked) {
            stayConnect = true;
            startActivity(si);

        }

         */
    }

    public void sign(View view) {
        progressBar_ma.setVisibility(View.VISIBLE);
        emailS= et_mail.getText().toString();
        passwordS= et_password.getText().toString();
        loc=location.getText().toString();
        ge=age.getText().toString();
        weig=weigh.getText().toString();
        heig=height.getText().toString();

        if (TextUtils.isEmpty(loc)){
            location.setError("location Is Required");
        }
        if (TextUtils.isEmpty(heig)){
            height.setError("height Is Required");
        }
        if (TextUtils.isEmpty(ge)){
            age.setError("age Is Required");
        }
        if (TextUtils.isEmpty(weig)){
            weigh.setError("weigh Is Required");
        }
        if (TextUtils.isEmpty(emailS)){
            et_mail.setError("Email Is Required");
        }
        if (TextUtils.isEmpty(passwordS)){
            et_password.setError("Password Is Required");
        }
        else {
            if (passwordS.length() < 6) {
                et_password.setError("Password must be longer than 6 digits");
            }
            else{
                mAuth.signInWithEmailAndPassword(emailS,passwordS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            progressBar_ma.setVisibility(View.INVISIBLE);
                            Toast.makeText(Singin.this, "User Signed", Toast.LENGTH_SHORT).show();
                            success();

                        }
                        else{
                            progressBar_ma.setVisibility(View.INVISIBLE);
                            Toast.makeText(Singin.this, "Error"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }





    }

    private void success() {

        Intent si = new Intent(this, Profile.class);
        startActivity(si);
    }


}