package id.alin_gotama.pratikumprogmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.alin_gotama.pratikumprogmob.helper.ApiClient;
import id.alin_gotama.pratikumprogmob.helper.Service;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLoginServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.etUsername = findViewById(R.id.etUsernameLogin);
        this.etPassword = findViewById(R.id.etPasswordLogin);

        this.btnLoginServer = findViewById(R.id.btnLoginServer);
        this.btnLoginServer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLoginServer){
            if(!etUsername.getText().toString().matches("") && !etPassword.getText().toString().matches("")){
                Service service = ApiClient.getRetrofit().create(Service.class);

                Call<Model> call = service.Login(
                        this.etUsername.getText().toString(),
                        this.etPassword.getText().toString()
                );

                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {
                        Toast.makeText(LoginActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                        if(response.body().getStatus().matches("200")){
                            Intent dashboard = new Intent(LoginActivity.this,DashboardActivity.class);
                            dashboard.putExtra("username",etUsername.getText().toString());
                            startActivity(dashboard);
                        }
                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "fail", Toast.LENGTH_SHORT).show();
                        Log.d("anjay",t.getMessage());
                    }
                });
            }
        }
    }
}