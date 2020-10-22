package id.alin_gotama.pratikumprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener{
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.btnLogin = findViewById(R.id.btnLogin);
        this.btnLogin.setOnClickListener(this);

        this.btnRegister = findViewById(R.id.btnRegister);
        this.btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLogin){
            Intent login = new Intent(this,LoginActivity.class);
            startActivity(login);
        }else if(v.getId() == R.id.btnRegister){
            Intent register = new Intent(this,RegisterActivity.class);
            startActivity(register);
        }
    }
}