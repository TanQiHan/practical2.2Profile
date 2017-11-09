package my.edu.tarc.practical22profile;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int PROFILE_UPDATE_REQUEST = 123;
    public static final String PROFILE_NAME="my.edu.tarc.practical22profile.name";
    public static final String PROFILE_EMAIL="my.edu.tarc.practical22profile.email";
    private TextView textViewName,textViewEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName=(TextView)findViewById(R.id.textViewName);
        textViewEmail=(TextView)findViewById(R.id.textViewEmail);




    }
    public void updateprofile(View view){
        Intent intent=new Intent(this,ProfileActivity.class);
        startActivityForResult(intent,PROFILE_UPDATE_REQUEST);

    }
    public void showSendTo(View v){
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:"+"seekt@tarc.edu.my"));

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;

        // Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(intent);
        }
    }


    public void phone(View view){
        Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"0122465778"));
        startActivity(intent);
    }
    public void web(View view){
        String uri="http://bait2073.000webhostapp.com/welcome.html";
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }
    public void home(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //requestcode = the unique code to identify an intent call
        //resultcode = the result of an intent call; either ok or cancel
        ////data = the actual adta returned bu an intent call
        if(requestCode == PROFILE_UPDATE_REQUEST && resultCode == RESULT_OK){
            String name,email;
            name = data.getStringExtra(PROFILE_NAME);
            email = data.getStringExtra(PROFILE_EMAIL);
            textViewName.setText(getString(R.string.name)+" : "+name);
            textViewEmail.setText(getString(R.string.email)+" : "+email);
        }

    }
}
