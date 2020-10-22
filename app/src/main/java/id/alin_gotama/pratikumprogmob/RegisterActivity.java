package id.alin_gotama.pratikumprogmob;

import androidx.appcompat.app.AppCompatActivity;

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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnRegister;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etFullname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.btnRegister = findViewById(R.id.btnRegisterServer);
        this.btnRegister.setOnClickListener(this);

        this.etFullname = findViewById(R.id.etFullName);
        this.etPassword = findViewById(R.id.etPassword);
        this.etUsername = findViewById(R.id.etUsername);
    }

    @Override
    public void onClick(View v) {
            if(v.getId() == R.id.btnRegisterServer){
                if(
                        !etFullname.getText().toString().matches("") &&
                        !etPassword.getText().toString().matches("") &&
                        !etUsername.getText().toString().matches("")
                ){
                        Service service = ApiClient.getRetrofit().create(Service.class);

                        Call<ResponseBody> call = service.addNewMember(
                                etUsername.getText().toString(),
                                etPassword.getText().toString(),
                                etFullname.getText().toString()
                        );

                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                Log.d("respon",response.message());
                                Toast.makeText(RegisterActivity.this, "Anda Berhasil Register", Toast.LENGTH_SHORT).show();
                                finish();
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(RegisterActivity.this, "Gagal, Sesuatu yang buruk terjadi", Toast.LENGTH_SHORT).show();
                            }
                        });
                }else{
                    if(etFullname.getText().toString().matches("")){
                        etFullname.setError("Mohon isi full name anda");
                    }

                    if(etUsername.getText().toString().matches("")){
                        etUsername.setError("Mohon isi username");
                    }

                    if(etPassword.getText().toString().matches("")){
                        etPassword.setError("Mohon isi Password");
                    }
                }

            }
    }
}