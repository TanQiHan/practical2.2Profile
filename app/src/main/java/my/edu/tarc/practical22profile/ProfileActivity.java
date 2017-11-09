package my.edu.tarc.practical22profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {
private EditText editTextName,editTextEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main Activity","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main Activity","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main Activity","onPause");
    }

    public void saveprofile(View view){
        //TODO: capture data from screen
        String name,email;
        name=editTextName.getText().toString();
        email=editTextEmail.getText().toString();

        //TODO: pass data to main activity
        Intent intent=getIntent();
        intent.putExtra(MainActivity.PROFILE_NAME,name);
        intent.putExtra(MainActivity.PROFILE_EMAIL,email);
        setResult(RESULT_OK,intent);
        //TODO: terminate this activity
        finish();
    }




}
