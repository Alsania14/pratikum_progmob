package id.alin_gotama.pratikumprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {
    private TextView tvUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        this.tvUser = findViewById(R.id.tvLoginUser);
        String username = getIntent().getExtras().getString("username");
        this.tvUser.setText(username);
    }
}