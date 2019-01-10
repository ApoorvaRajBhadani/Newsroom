package com.woc.apoorva.newsroom;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    TextView passwordSignupText,emailSignupText;
    Button signupButton;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        passwordSignupText = (TextView)findViewById(R.id.password_signup_text);
        emailSignupText = (TextView)findViewById(R.id.email_signup_text);
        signupButton = (Button)findViewById(R.id.signup_button);
        signupButton.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup_button:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        email = emailSignupText.getText().toString();
        password = passwordSignupText.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Signup", "createUserWithEmail:success");
                            Toast.makeText(getApplicationContext(),"Sign Up successful",Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
//                                    updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Signup", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                        }
                    }
                });
    }
}
