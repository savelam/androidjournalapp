package journalapp.slamadeku.example.com.journalapp;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class UserActivity extends AppCompatActivity {

    private static final String TAG = "UserActivity";

    private TextView greetingTextView;
    private Button btnLogOut;
    private Button btnPostArticle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Bundle bundle = getIntent().getExtras();
        String user = bundle.getString("username");
        greetingTextView = (TextView) findViewById(R.id.greeting_text_view);
        btnLogOut = (Button) findViewById(R.id.logout_button);
        btnPostArticle= (Button) findViewById(R.id.btn_post_diary);
        greetingTextView.setText("Hello "+ user);
        // Progress dialog
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        // call intent to the article artivity

        btnPostArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DiaryActivity.class);
                startActivity(i);
            }
        });
    }
}